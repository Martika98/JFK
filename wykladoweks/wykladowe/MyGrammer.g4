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
        | IF statement CBO expr CBC    #If
        | LOOP numbers CBO expr CBC    #Loop
        ;
        
statement:
      id_ '==' if_val       #Equal
    | id_ '<>' if_val       #NotEqual
;

ifbody:
      expr
    | command
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

id_: ID                                          # IdVal;

if_val: INT					   # IfVal;

string: STRING #StrVal
      ;

EQ: 'eq';
NEQ: 'noteq';
HELLO: ('hello'|'bonjour')  ;
BYE  : ('bye'| 'tata') ;
ASSIGN: '=';
COMMA: ',';
BO: '(';
BC: ')';
SBO: '[';
SBC: ']';
CBO: '{';
CBC: '}';
IF: 'if';
LOOP: 'loop';
INT  : '-'?[0-9]+;
REAL : '-'?[0-9]+[.][0-9]+;
STRING :  '"' ( ~('\\'|'"') )* '"';
ID: [A-Za-z0-9_]+;
WS : [ \n]+ -> skip ;
