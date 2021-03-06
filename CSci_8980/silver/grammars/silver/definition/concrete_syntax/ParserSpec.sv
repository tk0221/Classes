grammar silver:definition:concrete_syntax;

import silver:driver:util only computeDependencies; -- TODO this is a bad dependency!!

{--
 - An abstract representation of a parser declaration.
 -}
nonterminal ParserSpec with 
  sourceGrammar, sourceLocation, fullName,
  compiledGrammars,
  cstAst, startNT, moduleNames, unparse;

{--
 - Given compiledGrammars, gives back the SyntaxRoot representing this parser.
 -}
synthesized attribute cstAst :: SyntaxRoot;

{--
 - The full name of the start nonterminal of this parser spec.
 -}
synthesized attribute startNT :: String;

abstract production parserSpec
top::ParserSpec ::= sl::Location  sg::String  fn::String  snt::String  grams::[String]
{
  top.sourceLocation = sl;
  top.sourceGrammar = sg;
  top.fullName = fn;
  top.startNT = snt;
  top.moduleNames = grams;

  -- TODO: consider this: because we're using only the grammar in this parser to compute 
  -- dependencies, it may be possible that some different triggers are... triggered here
  -- than in the grammar.  Perhaps this is okay, perhaps this is a bug. Consider?
  production attribute med :: ModuleExportedDefs;
  med = moduleExportedDefs(sl, top.compiledGrammars, computeDependencies(grams, top.compiledGrammars), grams, []);

  top.cstAst = cstRoot(fn, snt, foldr(consSyntax, nilSyntax(), med.syntaxAst));
  
  top.unparse = "parser(" ++ sl.unparse ++ "," ++ quoteString(sg) ++ "," ++ quoteString(fn) ++ "," ++ quoteString(snt) ++ "," ++ unparseStrings(grams) ++ ")";
}

