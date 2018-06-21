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
start   : (block)+
        ;

block   : type MAIN LPAR RPAR CLPAR prog CRPAR       #mainDeclaration
        | decclass    #classDeclaration
        ;

prog    : exp       #singleExp
        | let exp   #letInExp
        ;

decclass   : CLASS ID ( EXTENDS ID )? LPAR ( vardec ( COMMA vardec)* )? RPAR CLPAR (fun)+ CRPAR
        ;

let     : LET (dec)+ IN
        ;

vardec  : type ID
        ;

varasm  : vardec ASM exp SEMIC      #expDecAsignment
        |  vardec ASM stms          #stmDecAsignment
        ;

fun     : type ID LPAR ( vardec ( COMMA vardec)* )? RPAR CLPAR prog (ret)? CRPAR
        ;

ret     : RETURN exp SEMIC                                      #returnFunExp
        | RETURN stms                                           #returnFunStms
        ;

dec     : varasm           #varAssignment
        | fun              #funDeclaration
        ;

type    : INT
        | BOOL
        | VOID
        | ID
        ;

exp     : (MINUS)? left=term ((PLUS | MINUS) right=exp)?
        ;

term    : left=factor ((TIMES | DIV) right=term)?
        ;

factor  : (NOT)? left=value ((EQ|GTEQ|LTEQ|AND|OR) (NOT)? right=value)?
        ;

stm     : IF cond=exp THEN CLPAR thenBranch=stms CRPAR (ELSE CLPAR elseBranch=stms CRPAR)?       #stmIf
        | PRINT exp SEMIC                                       #stmPrint
        | funExp SEMIC                   #callFunExp
        | ID (DOT funExp)+ SEMIC    #callMethod
        //|ID ASM exp SEMIC                                     #stmExpAsignment
        | ID ASM stms                                            #stmAsignment
        | ID ASM value SEMIC                                    #stmValAsignment
        ;

funExp: ID LPAR (exp (COMMA exp)* )? RPAR  ;

stms    : (stm)+
        ;

value   : INTEGER                               #intVal
        | ( TRUE | FALSE )                      #boolVal
        | LPAR exp RPAR                         #baseExp
        | IF cond=exp THEN CLPAR thenBranch=exp CRPAR (ELSE CLPAR elseBranch=exp CRPAR)?       #ifExp
        | stms                                  #stmsExp
        | ID                                    #varExp
        | NULL                                  #nullVal
        | NEW ID LPAR (exp (COMMA exp)* )? RPAR #newClass
        ;


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
DOT     : '.';
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
QLPAR   : '[' ;
QRPAR   : ']' ;
IF      : 'if' ;
THEN    : 'then' ;
ELSE    : 'else' ;
PRINT   : 'print' ;
LET     : 'let' ;
IN      : 'in' ;
INT     : 'int' ;
BOOL    : 'bool' ;
VOID    : 'void' ;
RETURN  : 'return' ;
CLASS   : 'class';
EXTENDS : 'extends';
NEW     : 'new';
NULL    : 'null';
MAIN    : 'main';

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