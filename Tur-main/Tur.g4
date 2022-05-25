grammar Tur;

prog: block
;

block: ( (stat|function)? Newline )*
;

stat:	 IF statement Newline blockif ENDIF    #if
    | declarationExpression                 #declare
    | REPEAT repetitions block ENDREPEAT	#repeat
    | ID '=' expr		                    #assign
	| PRINT value   		                #print
    | READ ID                               #read
    | READF ID                              #readFloat
    | ID'()'                                #call
;

expr:  value			#expression
      | expr MULT expr  #mult
      |	expr DIV  expr  #div
      |	expr ADD expr   #add
      |	expr SUB expr   #sub
      | TOINT expr		#toint
      | TOREAL expr		#toreal
      | '(' expr ')'	#par
;

function: FUNCTION fparam fblock ENDFUNCTION
;

fparam: ID
;

fblock: ( stat? Newline )*
;

repetitions:
         ID
       | INT
;

value:   ID
       | INT
       | REAL
       | STRING
;

declarationExpression:
      typeSpecifier ID '=' expr
    | typeSpecifier ID
;

statement:
      ID '==' INT        #equality
    | ID '!=' INT        #nonequality
;

typeSpecifier:
         'int'
       | 'real'
;

blockif: block
;

PRINT:	'print'
    ;
READ:	'read'
   ;
READF:	'readr'
    ;

FUNCTION: 'fun'
;

ENDFUNCTION:    'nuf'
;

REPEAT:	'loop'
;
ENDREPEAT: 'pool'
;

IF:	'if'
;

ENDIF:	'fi'
;

STRING :  '"' ( ~('\\'|'"') )* '"'
    ;

TOINT: '(int)'
    ;

TOREAL: '(real)'
    ;

ID:   ('a'..'z'|'A'..'Z')+
   ;

REAL: '0'..'9'+'.''0'..'9'+
    ;

INT: '0'..'9'+
    ;

ADD: '+'
    ;

SUB: '-'
    ;

DIV: '/'
    ;

MULT: '*'
    ;

Whitespace
    :   (' '|'\t')+
        -> skip
    ;

Newline
    :   '\r'? '\n'
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;
