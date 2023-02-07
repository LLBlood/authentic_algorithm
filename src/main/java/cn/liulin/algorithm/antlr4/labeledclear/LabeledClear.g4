grammar LabeledClear;

prog : stat+ ;

stat : expr NEWLINE  # printExpr
     | ID '=' expr NEWLINE  # assign
     | 'clear' ID NEWLINE # clearMemory
     | NEWLINE  # blank
     ;

expr : expr op=('*'|'/') expr  # MulDiv
     | expr op=('+'|'-') expr  # AddSub
     | ID  # id
     | INT  # int
     | '(' expr ')' # parents
     ;

MUL : '*';
DIV : '/';
ADD : '+';
SUB : '-';

ID : [a-zA-Z]+;
INT : [0-9]+;
NEWLINE : '\r' ? '\n';
WS : [ \t] -> skip;
