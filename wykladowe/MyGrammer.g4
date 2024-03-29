grammar MyGrammer;

commandx : commands;

commands : hello commands
     | command commands
     | bye
     |
     ;

hello : HELLO                                   # StartComm
      ;

bye : BYE                                       # EndComm
    ;

command :  id_ SBO i = value SBC ASSIGN val = expr #TableChangeComm
        | expr   #ExprComm
        | (id_ ASSIGN)? function=('write'|'read') BO arg = funct_value BC    # FunctExpr
        | id_ ASSIGN expr                       # AssignComm
        | id_ ASSIGN table #AssignTableComm
        | table #TableComm
        ;

table : SBO val = expr table_content SBC          # TableBody
   ;

table_content: COMMA val = expr table_content
             |
             ;

expr: left=expr op=('*'|'/') right=expr        # InfixExpr
    | left=expr op=('-'|'+') right=expr        # InfixExpr
    | value                                    # ValExpr
    | string #StrExpr
    ;

funct_value: expr
           |
           ;

value: table_val
     | id_
     | numbers
     ;

table_val: id_ SBO i = value SBC # TableValVal;

numbers: INT                                     # IntVal
       | REAL                                    # RealVal
       ;

id_: ID                                      # IdVal;

string: STRING #StrVal
      ;

HELLO: ('hello'|'bonjour')  ;
BYE  : ('bye'| 'tata') ;
ASSIGN: '=';
COMMA: ',';
BO: '(';
BC: ')';
SBO: '[';
SBC: ']';
INT  : '-'?[0-9]+;
REAL : '-'?[0-9]+[.][0-9]+;
STRING :  '"' ( ~('\\'|'"') )* '"';
ID: [A-Za-z0-9_]+;
WS : [ \n]+ -> skip ;