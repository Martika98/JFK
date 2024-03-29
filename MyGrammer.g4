grammar MyGrammer;

expr: left=expr op=('*'|'/') right=expr        # InfixExpr
    | left=expr op=('+'|'-') right=expr        # InfixExpr
    | atom=INT                                 # NumberExpr
    | '(' expr ')'                             # ParenExpr 
    | atom=HELLO                               # HelloExpr
    | atom=BYE                                 # ByeExpr
    ;

HELLO: ('hello'|'bonjour')  ;
BYE  : ('bye'| 'tata') ;
INT  : [0-9]+         ;
WS   : [\n \t]+ -> skip ;
