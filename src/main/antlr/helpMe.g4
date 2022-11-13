grammar helpMe;
start: variable ';' | expression ';';
expression: expression '*' expression | expression '+' expression | '('expression')' | DIGIT | VARNAME;
variable: VARNAME '=' expression;

DIGIT        : ('0'..'9')+;
VARNAME      : ( '_' | 'a'..'z' | 'A'..'Z')+ ('_' | 'a'..'z' | 'A'..'Z' | '0'..'9')*;
SPACESCLEANER: [ \t\n]+ -> skip;