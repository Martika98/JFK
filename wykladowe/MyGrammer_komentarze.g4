grammar MyGrammer;

start: 'bonjour'                               # StartExpr
     ;
     
end: 'au revoir'                               # EndExpr
   ;
   
commands : start commands                      # StartComm
         | command commands                    # CommComm
         | end                                 # EndComm
         ; 
         
command : 'print' BO expr BC                   # PrintComm print i input zamienić na funkvje
        | ID ASSIGN 'input' BO BC              # InputComm
        | SBO value table_content SBC          # TableComm
        | expr                                 # ExprComm
        | ID ASSIGN expr                       # AssignComm
        ;
        
table_content: COMMA value table_content
             | eps
             ;

expr: left=expr op=('*'|'/') right=expr        # InfixExpr rozbić na produkcje
    | left=expr op=('+'|'-') right=expr        # InfixExpr
    | BO expr BC                               # ParenExpr 
    | value                                    # ValExpr
    ;
    
value: INT                                     # IntVal
     | REAL                                    # RealVal
     | ID                                      # IdVal
     ;
     
ASSIGN: '=';
COMMA: ',';
BO: '(';
BC: ')';
SBO: '[';
SBC: ']';
INT  : [0-9]+;
REAL : [0-9]+[.][0-9]+;
ID: [A-Za-z0-9_-]+;
WS : [ \t\r\n]+ -> skip ;
