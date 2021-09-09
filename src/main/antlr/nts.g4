//header
/*
  @myVar =

*/

grammar nts;

script : statement_list EOF;

statement_list : statement terminator
               | statement_list statement terminator
               | terminator
               ;

statement : assignment_statement
          | function_call
          | return_statement
          | if_statement
          | foreach_statement
          ;

condition_expression : function_call
                     | type_bool
                     | variable_reference
                     | type_comparison
                     ;

type_comparison : left=comparable_expr op=( LESS | GREATER | LESS_EQUAL | GREATER_EQUAL ) right=comparable_expr
                | left=comparable_expr op=( EQUAL | NOT_EQUAL ) right=comparable_expr
                ;

op_less    : LESS ;
op_greater : GREATER ;
op_less_eq : LESS_EQUAL ;
op_greater_eq : GREATER_EQUAL ;
op_eq : EQUAL ;
op_neq : NOT_EQUAL;

comparable_expr : type_bool
                | type_integer
                | variable_reference
                ;

variable_reference : variable=VARIABLE_IDENTIFIER ;

assignment_statement : name=VARIABLE_IDENTIFIER '=' value=rval ;

return_statement	:	RETURN value=rval	;

rval : type_literal
     | type_integer
     | function_call
     | type_enum
     | type_bool
     | variable_reference
     ;

iterable :
         | function_call
         | variable_reference
         ;


type_enum : type=IDENTIFIER '.' value=IDENTIFIER ;

function_call : function_name=IDENTIFIER arguments='{'argument? (',' argument)* '}';

if_statement : IF condition_expression terminator statement_list END ;

foreach_statement : FOREACH variable=variable_reference IN collection=iterable terminator statement_list END ;


argument : name=IDENTIFIER '=' value=rval   ;

newline : CRLF;

type_literal : LITERAL;
type_integer : INT;

type_bool : TRUE
          | FALSE
          ;

terminator : terminator newline
           | newline
           ;

fragment ESCAPED_QUOTE : '\\"';
LITERAL : '"' ( ESCAPED_QUOTE | ~('\n'|'\r') )*? '"'
        | '\'' ( ESCAPED_QUOTE | ~('\n'|'\r') )*? '\'';

WS : (' '|'\t')+ -> skip;
SL_COMMENT : ('#' ~('\r' | '\n')* '\r'? '\n') -> skip;
ASSIGN : '=';

CRLF : '\r'? '\n';

RETURN : R E T U R N;

TRUE : (T R U E | T);
FALSE : (F A L S E | F);

PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';
MOD : '%';
EXP : '**';

EQUAL : '==';
NOT_EQUAL : '!=';
GREATER : '>';
LESS : '<';
LESS_EQUAL : '<=';
GREATER_EQUAL : '>=';

IF : I F;
ELSE : E L S E;
END : E N D;
FOREACH: F O R E A C H;
IN: I N;

IDENTIFIER : [a-zA-Z_][a-zA-Z0-9_]*;
VARIABLE_IDENTIFIER : '@' IDENTIFIER;
fragment DIGIT : ('0'..'9');
INT : [0-9]+;
fragment LETTER : ('a'..'z' | 'A'..'Z');


fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];