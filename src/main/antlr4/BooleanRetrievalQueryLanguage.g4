grammar BooleanRetrievalQueryLanguage;

@header {
package com.smhumayun.datascience.ire.booleanretrieval.query.parser.antlr4.generated;
}

TRUE: 'true';
FALSE: 'false';
AND: 'and';
OR: 'or';
NOT: 'not';
LPAR: '(';
RPAR: ')';

parse: expr EOF;

expr:
    nestedExpr
    | unaryExpr
    | expr binaryOp expr
    | literalExpr
    | termExpr
;

nestedExpr: LPAR expr RPAR;

unaryExpr: unaryOp expr;

literalExpr: boolean_literal;

termExpr: TERM;

unaryOp: NOT;

binaryOp: AND | OR;

boolean_literal: TRUE | FALSE;

TERM: [a-zA-Z_] [a-zA-Z_0-9]*;

WS: ((' ' | '\r' | '\t' | '\u000C' | '\n')*  | EOF) -> skip;
