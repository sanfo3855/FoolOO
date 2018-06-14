grammar FoolOO;

@lexer::members {
   //there is a much better way to do this, check the ANTLR guide
   //I will leave it like this for now just becasue it is quick
   //but it doesn't work well
   public int lexicalErrors=0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog   : exp SEMIC                 #singleExp
       | let exp SEMIC             #letInExp
       ;

let     : LET (dec SEMIC)+ IN ;

vardec  : type ID ;

varasm     : vardec ASM exp ;

fun    : type ID LPAR ( vardec ( COMMA vardec)* )? RPAR CLPAR (let)? exp CRPAR ;

dec   : varasm           #varAssignment
      | fun              #funDeclaration
      ;


type    : INT
        | BOOL
        | VOID
        ;

exp     : (MINUS)? left=term ((PLUS | MINUS) right=exp)?
        ;

term    : left=factor ((TIMES | DIV) right=term)?
        ;

factor  : (NOT)? left=value ((EQ|GTEQ|LTEQ|AND|OR) (NOT)? right=value)?
        ;

stm     : ID ASM exp SEMIC    #stmAsignment
        | IF cond=exp THEN CLPAR thenBranch=stms CRPAR ELSE CLPAR elseBranch=stms CRPAR       #stmIf
        | PRINT exp SEMIC   #stmPrint
        ;

stms    :  ( stm ) +
        ;

value   : INTEGER                           #intVal
        | ( TRUE | FALSE )                   #boolVal
        | RETURN exp                        #returnFun
        | LPAR exp RPAR                      #baseExp
        | IF cond=exp THEN CLPAR thenBranch=exp CRPAR ELSE CLPAR elseBranch=exp CRPAR       #ifExp
        | stms             #stmsExp
        | ID                                             #varExp
        | ID ( LPAR (exp (COMMA exp)* )? RPAR )?         #funExp
        ;


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
SEMIC   : ';' ;
COLON   : ':' ;
COMMA   : ',' ;
EQ      : '==' ;
ASM     : '=' ;
PLUS    : '+' ;
MINUS   : '-' ;
TIMES   : '*' ;
DIV     : '/' ;
AND     : '&&' ;
OR      : '||' ;
GTEQ    : '>=' ;
LTEQ    : '<=' ;
NOT     : '!' ;
TRUE    : 'true' ;
FALSE   : 'false' ;
LPAR    : '(' ;
RPAR    : ')' ;
CLPAR   : '{' ;
CRPAR   : '}' ;
IF      : 'if' ;
THEN    : 'then' ;
ELSE    : 'else' ;
PRINT   : 'print' ;
LET     : 'let' ;
IN      : 'in' ;
//VAR     : 'var' ;
//FUN     : 'fun' ;
INT     : 'int' ;
BOOL    : 'bool' ;
VOID    : 'void' ;
RETURN  : 'return' ;





//Numbers
fragment DIGIT : '0'..'9';
INTEGER       : DIGIT+;

//IDs
fragment CHAR  : 'a'..'z' |'A'..'Z' ;
ID              : CHAR (CHAR | DIGIT)* ;

//ESCAPED SEQUENCES
WS              : (' '|'\t'|'\n'|'\r') -> skip;
LINECOMENTS    : '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;




 //VERY SIMPLISTIC ERROR CHECK FOR THE LEXING PROCESS, THE OUTPUT GOES DIRECTLY TO THE TERMINAL
 //THIS IS WRONG!!!!
ERR     : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN);