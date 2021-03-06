grammar silver:definition:concrete_syntax;

import silver:definition:regex;

terminal Ignore_kwd      'ignore'      lexer classes {KEYWORD};
terminal Marking_kwd     'marking'     ;
terminal Left_kwd        'left'        lexer classes {KEYWORD};
terminal Association_kwd 'association' lexer classes {KEYWORD};
terminal Right_kwd       'right'       lexer classes {KEYWORD};

-- We actually need to reserved this due to its appearance in PRODUCTION modifiers.
terminal Precedence_kwd  'precedence'  lexer classes {KEYWORD,RESERVED};

abstract production terminalDclDefault
top::AGDcl ::= t::TerminalKeywordModifier id::Name r::RegExpr tm::TerminalModifiers
{
  top.pp = t.pp ++ "terminal " ++ id.pp ++ " " ++ r.pp ++ " " ++ tm.pp ++ ";";

  production attribute fName :: String;
  fName = top.grammarName ++ ":" ++ id.name;

  top.defs = [termDef(top.grammarName, id.location, fName, r.terminalRegExprSpec)];
  
  top.errors <-
    if length(getTypeDclAll(fName, top.env)) > 1
    then [err(id.location, "Type '" ++ fName ++ "' is already bound.")]
    else [];
  
  top.errors <-
    if isLower(substring(0,1,id.name))
    then [err(id.location, "Types must be capitalized. Invalid terminal name " ++ id.name)]
    else [];

  top.errors := tm.errors;

  top.syntaxAst = [
    syntaxTerminal(fName, r.terminalRegExprSpec, 
      foldr(consTerminalMod, nilTerminalMod(), t.terminalModifiers ++ tm.terminalModifiers))];
}

concrete production terminalDclKwdModifiers
top::AGDcl ::= t::TerminalKeywordModifier 'terminal' id::Name r::RegExpr ';'
{
  forwards to terminalDclDefault(t, id, r, terminalModifiersNone(location=$5.location), location=top.location);
}

concrete production terminalDclAllModifiers
top::AGDcl ::= t::TerminalKeywordModifier 'terminal' id::Name r::RegExpr tm::TerminalModifiers ';'
{
  forwards to terminalDclDefault(t, id, r, tm, location=top.location);
}

{--
 - This exists as a catch-all for representing regular expressions for terminals.
 - There's only one option here, but it's an extension point.
 -}
nonterminal RegExpr with config, location, grammarName, pp, terminalRegExprSpec;

synthesized attribute terminalRegExprSpec :: Regex_R;

concrete production regExpr
top::RegExpr ::= '/' r::Regex_R '/'
{
  top.pp = "/" ++ r.regString ++ "/";
  top.terminalRegExprSpec = r;
}


nonterminal TerminalKeywordModifier with pp, location, terminalModifiers;

concrete production terminalKeywordModifierIgnore
top::TerminalKeywordModifier ::= 'ignore'
{
  top.pp = "ignore ";

  top.terminalModifiers = [termIgnore()];
}

concrete production terminalKeywordModifierMarking
top::TerminalKeywordModifier ::= 'marking'
{
  top.pp = "marking ";

  top.terminalModifiers = [termMarking()];
}

concrete production terminalKeywordModifierNone
top::TerminalKeywordModifier ::= 
{
  top.pp = "";

  top.terminalModifiers = [];
}


nonterminal TerminalModifiers with config, location, pp, terminalModifiers, errors, env, grammarName, compiledGrammars, flowEnv;
nonterminal TerminalModifier with config, location, pp, terminalModifiers, errors, env, grammarName, compiledGrammars, flowEnv;

synthesized attribute terminalModifiers :: [SyntaxTerminalModifier];

abstract production terminalModifiersNone
top::TerminalModifiers ::= 
{
  top.pp = "";

  top.terminalModifiers = [];
  top.errors := [];
}
concrete production terminalModifierSingle
top::TerminalModifiers ::= tm::TerminalModifier
{
  top.pp = tm.pp;

  top.terminalModifiers = tm.terminalModifiers;
  top.errors := tm.errors; 
}
concrete production terminalModifiersCons
top::TerminalModifiers ::= h::TerminalModifier ',' t::TerminalModifiers
{
  top.pp = h.pp ++ ", " ++ t.pp;

  top.terminalModifiers = h.terminalModifiers ++ t.terminalModifiers;
  top.errors := h.errors ++ t.errors;
}

concrete production terminalModifierLeft
top::TerminalModifier ::= 'association' '=' 'left'
{
  top.pp = "association = left";

  top.terminalModifiers = [termAssociation("left")];
  top.errors := [];
}
concrete production terminalModifierRight
top::TerminalModifier ::= 'association' '=' 'right'
{
  top.pp = "association = right";

  top.terminalModifiers = [termAssociation("right")];
  top.errors := [];
}

concrete production terminalModifierPrecedence
top::TerminalModifier ::= 'precedence' '=' i::Int_t
{
  top.pp = "precedence = " ++ i.lexeme;

  top.terminalModifiers = [termPrecedence(toInt(i.lexeme))];
  top.errors := [];
}

