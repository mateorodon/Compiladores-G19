%token ID ASIGNACION MAYORIGUAL MENORIGUAL DISTINTO CONSTANTE CADENA IF THEN ELSE BEGIN END END_IF OUTF TYPEDEF FUN RET ULONGINT SINGLE FOR OR UP DOWN TRIPLE
%%

%start programa

programa: ID BEGIN list_sentencias END

list_sentencias:
    list_sentencias sentencia ';'
    | sentencia ';'
    ;

sentencia : sentencia_declarativa
    | sentencia_ejecutable
    ;

sentencia_declarativa : tipo list_variables
    | declaracion_funcion
    ;

sentencia_ejecutable : //ver sentencias ejecutables: asignaciones, invocacion a funcion, ifs, mensajes por pantalla
    ;

tipo : ULONGINT
    | SINGLE
    ;

list_variables : list_variables ',' ID
    | ID
    ;

declaracion_funcion : tipo FUN ID '(' parametro ')' BEGIN cuerpo_funcion END
    ;

parametro : tipo ID
    ;

cuerpo_funcion : list_sentencias
    | list_sentencias RET '(' expresion ')'
    | RET '(' expresion ')'
    ;

expresion: expresion '+' termino
    | expresion '-' termino
    | termino
    ;

termino: termino '*' factor
    | termino '/' factor
    | factor
    ;

factor: ID
    | CONSTANTE
    ;

%%

//codigo