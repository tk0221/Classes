grammar edu:umn:cs:melt:exts:ableC:matrix:matrixScalarAddition:mda ;

import edu:umn:cs:melt:ableC:concretesyntax only Root ;

parser theParser :: Root {
  edu:umn:cs:melt:ableC:concretesyntax ;
} 

copper_mda test(theParser) {
  edu:umn:cs:melt:exts:ableC:matrix:matrixScalarAddition ;
}

