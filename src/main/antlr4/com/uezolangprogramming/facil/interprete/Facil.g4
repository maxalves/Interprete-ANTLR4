grammar Facil;

start
:
	'hello' 'world'
;

WS
:
	[ \t\r\n]+ -> skip
;