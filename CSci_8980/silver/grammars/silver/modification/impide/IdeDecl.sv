grammar silver:modification:impide;

import silver:modification:copper_mda only findSpec; -- TODO
import silver:driver:util only RootSpec;
import silver:extension:list;
import silver:analysis:typechecking:core;
import silver:modification:ffi;
import silver:definition:type;

-- We're going to make this an especially annoying looking declaration
-- to emphasize that this is currently a temporary hack just to get things
-- moving.
terminal ImpIde_t 'temp_imp_ide_dcl' lexer classes {KEYWORD,RESERVED};

terminal ImpIde_OptFunc_Property 'property' lexer classes {KEYWORD};

terminal ImpIde_PropType_string_t 'string' lexer classes {KEYWORD};
terminal ImpIde_PropType_integer_t 'integer' lexer classes {KEYWORD};
terminal ImpIde_PropType_path_t 'path' lexer classes {KEYWORD};
terminal ImpIde_PropType_url_t 'url' lexer classes {KEYWORD};

terminal ImpIde_PropOption_Required_t 'required' lexer classes {KEYWORD};
terminal ImpIde_PropOption_Display_t 'display' lexer classes {KEYWORD};
terminal ImpIde_PropOption_Default_t 'default' lexer classes {KEYWORD};

terminal ImpIde_Product_t 'product' lexer classes {KEYWORD};
terminal ImpIde_ProdInfo_Name_t 'name' lexer classes {KEYWORD};
terminal ImpIde_ProdInfo_Version_t 'version' lexer classes {KEYWORD};

concrete production ideDcl
top::AGDcl ::= 'temp_imp_ide_dcl' parsername::QName fileextension::String_t stmts::IdeStmts
{
  top.pp = "temp_imp_ide_dcl " ++ parsername.pp ++ " " ++ fileextension.lexeme ++ "\n";

  top.defs = [];

  top.errors := parsername.lookupValue.errors;

  -- lexeme starts with ", but also ensure first character is a dot.
  top.errors <-
    if startsWith("\".", fileextension.lexeme) then []
    else [err(fileextension.location, "File extension should begin with dot (like \".sv\")")];
  
  -- This gets the compiler's representation of the grammar the parser is declared in
  -- This should NOT be accessed unless we know the lookup for the name succeeded
  -- since we're unconditionally calling 'head' here!
  local attribute parsergrammar :: Decorated RootSpec;
  parsergrammar = head(searchEnvTree(parsername.lookupValue.dcl.sourceGrammar, top.compiledGrammars));
  
  -- This looks up the actual specification of the parser in that grammar.
  local attribute spec :: [ParserSpec];
  spec = findSpec(parsername.lookupValue.fullName, parsergrammar.parserSpecs);

  stmts.startNTName = makeGrammarName(head(spec).startNT);

  -- If there were errors looking up the name, do nothing. If we couldn't find the
  -- parser, then raise the error message noting that the name isn't a parser!
  top.errors <- if !null(parsername.lookupValue.errors) || !null(spec) then []
                else [err(parsername.location, parsername.name ++ " is not a parser.")];
  
  -- Strip off the quotes AND the initial dot
  local fext :: String = substring(2, length(fileextension.lexeme) - 1, fileextension.lexeme);
  
  local info :: IdeProductInfo = getIdeProductInfo(stmts);

  top.ideSpecs = [ideSpec(fext, stmts.funcDcls, stmts.propDcls, head(spec), info, getConfig(stmts.funcDcls, stmts.optDcls, stmts.propDcls))];
  
  top.errors <- stmts.errors;

  forwards to emptyAGDcl(location=top.location);
}

function getConfig
PluginConfig ::= funcs::[Pair<String String>] opts::[IdeOption] props::[IdeProperty] 
{
    local hasExporter :: Boolean = checkExistence(funcs, "exporter");
    local hasSourceLinker :: Boolean = checkSwitchedOn(opts, "source linker");
    local hasCodeFolder :: Boolean = checkExistence(funcs, "folder");

    local tabs::[Pair<String String>] = 
        (if null(props) then [] else [pair("Commons", "TabCommons")]) ++
        (if hasSourceLinker then [pair("Source", "TabBuildConfig")] else []);

    return pluginConfig(hasExporter, hasSourceLinker, hasCodeFolder, tabs);
}

function checkExistence
Boolean ::= funcs::[Pair<String String>] name::String
{
    return 
      if null(funcs)
      then false
      else if head(funcs).fst == name
           then true
           else checkExistence(tail(funcs), name);
}    

function checkSwitchedOn
Boolean ::= opts::[IdeOption] name::String
{
    return 
      if null(opts)
      then false
      else if head(opts).optKey == name
           then if head(opts).optValue == "on"
                then true
                else false
           else checkSwitchedOn(tail(opts), name);
}  

function getIdeProductInfo
IdeProductInfo ::= stmts::IdeStmts
{
    return   
      case stmts of
        listIdeStmts(_, stmtList, _) -> recurGetIdeProductInfo(stmtList)
        | _ -> makeEmptyIdeProductInfo()
      end;
}

function recurGetIdeProductInfo
IdeProductInfo ::= stmtList::IdeStmtList
{
    return  
     case stmtList of
       nilIdeStmtList() -> makeEmptyIdeProductInfo()
     | consIdeStmtList(h, t) ->  
         case h of
         makeIdeStmt_Product(_, _, _, _) -> h.productInfo
         | _ -> recurGetIdeProductInfo(t)
         end
     end;
}

nonterminal IdeProperty with propName, propType, optional, defaultVal, displayName;

nonterminal IdePropertyOption with optionType, optional, defaultVal, displayName;
nonterminal IdePropertyOptions with optional, defaultVal, displayName;

synthesized attribute optionType :: String;--"optional", "defaultVal"

autocopy attribute startNTName :: String;

concrete production nilPropertyOptions
top::IdePropertyOptions ::= 
{
  top.optional = true;--a property is optional by default
  top.defaultVal = "";--a property's default value is always empty
  top.displayName = "";--a property's display name is same to its name (propName), see production makeIdeProperty
}

concrete production consPropertyOptions
top::IdePropertyOptions ::= opt::IdePropertyOption opts::IdePropertyOptions
{

  top.optional = if opt.optionType == "optional" then opt.optional else opts.optional;
  top.defaultVal = if opt.optionType == "default" then opt.defaultVal else opts.defaultVal;
  top.displayName = if opt.optionType == "display" then opt.displayName else opts.displayName;
}

concrete production idePropertyOption_optional
top::IdePropertyOption ::= 'required'
{
  top.optionType = "optional";
  top.optional = false;--a mandatory property
  top.defaultVal = "";
  top.displayName = "";
}

concrete production idePropertyOption_defaultVal
top::IdePropertyOption ::= 'default' '=' str::String_t
{
  top.optionType = "default";
  top.optional = true;
  top.defaultVal = substring(1, length(str.lexeme) - 1, str.lexeme);
  top.displayName = "";
}

concrete production idePropertyOption_displayName
top::IdePropertyOption ::= 'display' '=' str::String_t
{
  top.optionType = "display";
  top.optional = true;
  top.defaultVal = "";
  top.displayName = substring(1, length(str.lexeme) - 1, str.lexeme);
}

-- Functions

-- function called when build is triggered
terminal ImpIde_OptFunc_Builder 'builder';

-- function called in background thread, if builder returns without errors
terminal ImpIde_OptFunc_PostBuilder 'postbuilder';

-- function called when exporting is demanded
terminal ImpIde_OptFunc_Exporter 'exporter';

-- function to mark the foldable ranges on the source file; called after parsing
terminal ImpIde_OptFunc_Folder 'folder';

-- funcDcls, propDcls and optDcls are defined in ./IdeSpec.sv
nonterminal IdeStmts with env, location, errors, grammarName, funcDcls, propDcls, optDcls, startNTName;
nonterminal IdeStmt with env, location, errors, grammarName, funcDcls, propDcls, optDcls, startNTName, productInfo;
nonterminal IdeStmtList with env, location, errors, grammarName, funcDcls, propDcls, optDcls, startNTName;

function makeGrammarName
String ::= str::String
{
  return substitute(".", ":", str);
}

concrete production emptyIdeStmts
top::IdeStmts ::= ';'
{
  top.errors := [];
  top.funcDcls := [];
  top.propDcls := [];
  top.optDcls := [];
}

concrete production listIdeStmts
top::IdeStmts ::= '{' funcList::IdeStmtList '}'
{
  top.errors := funcList.errors;
  top.funcDcls := funcList.funcDcls;
  top.propDcls := funcList.propDcls;
  top.optDcls := funcList.optDcls;
}

-- with optional ending ';'
concrete production listIdeStmts2
top::IdeStmts ::= '{' funcList::IdeStmtList '}' ';'
{
  top.errors := funcList.errors;
  top.funcDcls := funcList.funcDcls;
  top.propDcls := funcList.propDcls;
  top.optDcls := funcList.optDcls;
}

concrete production nilIdeStmtList
top::IdeStmtList ::= 
{
  top.errors := [];
  top.funcDcls := [];
  top.propDcls := [];
  top.optDcls := [];
}

concrete production consIdeStmtList
top::IdeStmtList ::= func::IdeStmt funcList::IdeStmtList
{
  top.errors := func.errors ++ funcList.errors;
  top.funcDcls := func.funcDcls ++ funcList.funcDcls;
  top.propDcls := func.propDcls ++ funcList.propDcls;
  top.optDcls := func.optDcls ++ funcList.optDcls;
}

aspect default production
top::IdeStmt ::=
{
  top.productInfo = error("Internal compiler error: should only ever be demanded of Production Info declaration.");
}

concrete production makeIdeStmt_Builder
top::IdeStmt ::= 'builder' builderName::QName ';' 
{
  top.funcDcls := [pair("builder", builderName.lookupValue.fullName)];
  top.propDcls := [];
  top.optDcls := [];

  top.errors := builderName.lookupValue.errors;
  
  -- IOVal<[IdeMessage]> ::= [IdeProperty] IO
  local builderTypeExpected :: TypeExp =
    functionTypeExp(
      nonterminalTypeExp(
        "core:IOVal", 
        [listTypeExp(nonterminalTypeExp("ide:IdeMessage", []))]
      ),
      [listTypeExp(nonterminalTypeExp("ide:IdeProperty", [])),
        nonterminalTypeExp("ide:IdeEnv", []),
        foreignTypeExp("core:IO", [])], []);
  
  local tc1 :: TypeCheck = check(freshenCompletely(builderName.lookupValue.typerep), builderTypeExpected);
  tc1.downSubst = emptySubst();
  tc1.finalSubst = tc1.upSubst;

  top.errors <-
    if !tc1.typeerror then []
    else [err(builderName.location, "Builder function should have type:\n\t" ++ tc1.rightpp 
        ++ "\nInstead it has the type:\n\t" ++ tc1.leftpp)];
}  

concrete production makeIdeStmt_PostBuilder
top::IdeStmt ::= 'postbuilder' postbuilderName::QName ';' 
{
  top.funcDcls := [pair("postbuilder", postbuilderName.lookupValue.fullName)];
  top.propDcls := [];
  top.optDcls := [];

  top.errors := postbuilderName.lookupValue.errors;
  
  -- IOVal<[IdeMessage]> ::= [IdeProperty] IO
  local postbuilderTypeExpected :: TypeExp =
    functionTypeExp(
      nonterminalTypeExp(
        "core:IOVal", 
        [listTypeExp(nonterminalTypeExp("ide:IdeMessage", []))]
      ),
      [listTypeExp(nonterminalTypeExp("ide:IdeProperty", [])),
        nonterminalTypeExp("ide:IdeEnv", []),
        foreignTypeExp("core:IO", [])], []);
  
  local tc1 :: TypeCheck = check(freshenCompletely(postbuilderName.lookupValue.typerep), postbuilderTypeExpected);
  tc1.downSubst = emptySubst();
  tc1.finalSubst = tc1.upSubst;

  top.errors <-
    if !tc1.typeerror then []
    else [err(postbuilderName.location, "Post-builder function should have type:\n\t" ++ tc1.rightpp 
        ++ "\nInstead it has the type:\n\t" ++ tc1.leftpp)];
}  

concrete production makeIdeStmt_Exporter
top::IdeStmt ::= 'exporter' exporterName::QName ';' 
{
  top.funcDcls := [pair("exporter", exporterName.lookupValue.fullName)];
  top.propDcls := [];
  top.optDcls := [];

  top.errors := exporterName.lookupValue.errors;
  
  -- IOVal<[IdeMessage]> ::= [IdeProperty] IdeEnv IO
  local exporterTypeExpected :: TypeExp =
    functionTypeExp(
      nonterminalTypeExp(
        "core:IOVal", 
        [listTypeExp(nonterminalTypeExp("ide:IdeMessage", []))]
      ),
      [listTypeExp(nonterminalTypeExp("ide:IdeProperty", [])), 
        nonterminalTypeExp("ide:IdeEnv", []),
        foreignTypeExp("core:IO", [])], []);
  
  local tc1 :: TypeCheck = check(freshenCompletely(exporterName.lookupValue.typerep), exporterTypeExpected);
  tc1.downSubst = emptySubst();
  tc1.finalSubst = tc1.upSubst;

  top.errors <-
    if !tc1.typeerror then []
    else [err(exporterName.location, "Exporter function should have type:\n\t" ++ tc1.rightpp 
        ++ "\nInstead it has the type:\n\t" ++ tc1.leftpp)];
}  

concrete production makeIdeStmt_Folder
top::IdeStmt ::= 'folder' folderName::QName ';' 
{
  top.funcDcls := [pair("folder", folderName.lookupValue.fullName)];
  top.propDcls := [];
  top.optDcls := [];

  top.errors := folderName.lookupValue.errors;
  
  -- [Location] ::= <<CST root's type>>
  local folderTypeExpected :: TypeExp =
    functionTypeExp(
      listTypeExp(nonterminalTypeExp("core:Location", [])),
      [nonterminalTypeExp(top.startNTName, [])], 
      []);
  
  local tc1 :: TypeCheck = check(freshenCompletely(folderName.lookupValue.typerep), folderTypeExpected);
  tc1.downSubst = emptySubst();
  tc1.finalSubst = tc1.upSubst;

  top.errors <-
    if !tc1.typeerror then []
    else [err(folderName.location, "Folder function for this language should have type:\n\t" ++ tc1.rightpp 
        ++ "\nInstead it has the type:\n\t" ++ tc1.leftpp)];
}  

concrete production makeIdeStmt_Porperty
top::IdeStmt ::= 'property' pname::IdLower_t ptype::TypeName options::IdePropertyOptions ';' 
{
  top.funcDcls := [];

  top.propDcls := [makeIdeProperty(pname.lexeme, ptype.propType, options)];

  top.optDcls := [];

  local defaultVal :: String = getDefaultVal(options);

  top.errors := if ptype.propType=="integer"
                then if (defaultVal=="" || isDigit(defaultVal))
                     then []
                     else [err($1.location, "The default value for integer property must be of integer type.\nInstead it is \"" ++ defaultVal ++ "\".")]
                else [];
} 

-- Options

terminal ImpIde_Option_t 'option' lexer classes {KEYWORD};
terminal ImpIde_Source_Linker_t 'source linker' lexer classes {KEYWORD};
terminal ImpIde_Switch_On_t 'on' lexer classes {KEYWORD};
terminal ImpIde_Switch_Off_t 'off' lexer classes {KEYWORD};

nonterminal IdeOptionPart_c with funcDcls, propDcls, optDcls, errors;

concrete production makeIdeStmt_Option
top::IdeStmt ::= 'option' op::IdeOptionPart_c ';'
{
  top.funcDcls := [];

  top.propDcls := [];

  top.optDcls := op.optDcls;

  top.errors := op.errors;
} 

concrete production makeIdeOption_SourceLinker
top::IdeOptionPart_c ::= 'source linker' value::OnOff
{
  top.funcDcls := [];

  top.propDcls := [];

  top.optDcls := [makeIdeOption("source linker", switch2Str(value))];

  top.errors := [];
} 

function switch2Str
String ::= value::OnOff
{
  return case value of
           switchOn(_) -> "on"
         | switchOff(_) -> "off"
         end;
}

nonterminal OnOff;

concrete production switchOn
top::OnOff ::= 'on'
{

}

concrete production switchOff
top::OnOff ::= 'off'
{

}

function getDefaultVal
String ::= options::IdePropertyOptions
{
  return
    case options of
      nilPropertyOptions() ->
        ""
    | consPropertyOptions(ht, tl) ->
        if ht.optionType == "default"
        then ht.defaultVal
        else getDefaultVal(tl)
 -- | _ -> ""
    end;
}

concrete production makeIdeStmt_Product
top::IdeStmt ::= 'product' '{' dcls::IdeProductInfoDcls '}' 
{
  top.funcDcls := [];

  top.propDcls := [];

  top.optDcls := [];

  top.productInfo = makeIdeProductInfo(dcls.info);

  top.errors := [];

  top.errors <- dcls.errors;
} 

synthesized attribute info :: [Pair<String String>] with ++;

nonterminal IdeProductInfoDcls with errors, info;
nonterminal IdeProductInfoDcl with errors, info;

concrete production nilIdeProductInfoDcls
top::IdeProductInfoDcls ::= 
{
  top.info := [];
  top.errors := [];
}

concrete production consIdeProductInfoDcls
top::IdeProductInfoDcls ::= h::IdeProductInfoDcl t::IdeProductInfoDcls
{
  top.info := h.info ++ t.info;
  top.errors := h.errors ++ t.errors;
}

concrete production ideProductInfoDcl_name
top::IdeProductInfoDcl ::= 'name' ideName::String_t ';'
{
  -- Strip off the quotes
  local iName :: String = substring(1, length(ideName.lexeme) - 1, ideName.lexeme);
  
  top.errors := [];
  top.errors <- 
        if (iName=="") then [wrn(ideName.location, "The name of IDE product is empty. A default name will be used.")]
        else if isDigit(substring(0,1,iName)) then [err(ideName.location, "The name of IDE product cannot be started with digital.")]
        else [];

  top.info := [pair("name", iName)];
}

concrete production ideProductInfoDcl_version
top::IdeProductInfoDcl ::= 'version' v::String_t ';'
{
  -- Strip off the quotes
  local iV :: String = substring(1, length(v.lexeme) - 1, v.lexeme);
 
  top.errors := [];
  top.errors <- 
        if (iV=="") then [wrn(v.location, "The version of IDE product is empty. A default version number will be used.")]
        else if !isLegalVersion(iV) then [err(v.location, "The version of IDE product must comply to the format \"N+.N+\" or \"N+.N+.N+\".")]
        else [];

  top.info := [pair("version", iV)];
}

function isLegalVersion
Boolean ::= ver::String
{
    local parts::[String] = explode(".", ver);

    return if(length(parts)==2 || length(parts)==3) 
           then isAllDigital(parts) 
           else false;
}

function isAllDigital
Boolean ::= parts::[String]
{
    return if(null(parts))
           then true
           else if isDigit(head(parts))
                then isAllDigital(tail(parts)) 
                else false;
}

nonterminal TypeName with propType;

concrete production propType_String
top::TypeName ::= 'string'
{
  top.propType = "string";
}

concrete production propType_Integer
top::TypeName ::= 'integer'
{
  top.propType = "integer";
}

concrete production propType_Path
top::TypeName ::= 'path'
{
  top.propType = "path";
}

concrete production propType_URL
top::TypeName ::= 'url'
{
  top.propType = "url";
}

