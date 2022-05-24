// Demo for basic function
// Bartosz Sawicki, 2014-05-25

grammar Demo;

prog: ( (stat|function)? NEWLINE )*
;

stat:	WRITE value				#write
	| ID '=' value				#assign
	| READ ID   				#read
	| ID    				#call
;

function: FUNCTION fparam fblock ENDFUNCTION
;

fparam: ID
;

fblock: ( stat? NEWLINE )* 
; 

value: INT
	| ID
;

WRITE:	'write' 
;

READ:	'read' 
;

FUNCTION: 'function'
;

ENDFUNCTION:	'endfunction'
;

ID:   ('a'..'z'|'A'..'Z')+
;

INT:   '0'..'9'+
;

NEWLINE:	'\r'? '\n'
;

WS:   (' '|'\t')+ { skip(); }
;
