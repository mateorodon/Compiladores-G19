%token ID ASIGNACION MAYORIGUAL MENORIGUAL DISTINTO CONSTANTE CADENA IF THEN ELSE BEGIN END END_IF OUTF TYPEDEF FUN RET ULONGINT SINGLE FOR OR UP DOWN TRIPLE
%%

%start programa

programa: ID BEGIN list_sentencias END
    ;

list_sentencias:
    list_sentencias sentencia ';'
    | sentencia ';'
    ;

sentencia:
    sentencia_declarativa
    | sentencia_ejecutable
    ;

sentencia_declarativa:
    tipo list_variables
    | declaracion_funcion
    ;

sentencia_ejecutable:
    asignacion
    | invocacion_funcion ';'
    | bloque_if
    | salida_mensaje
    ;

asignacion:
    ID ASIGNACION expresion ';'
    ;

tipo:
    ULONGINT
    | SINGLE
    ;

list_variables:
    list_variables ',' ID
    | ID
    ;

declaracion_funcion:
    tipo FUN ID '(' parametro ')' BEGIN cuerpo_funcion END
    ;

parametro:
    tipo ID
    ;

cuerpo_funcion:
    list_sentencias
    | list_sentencias RET '(' expresion ')'
    | RET '(' expresion ')'
    ;

expresion:
    expresion '+' termino
    | expresion '-' termino
    | termino
    ;

termino:
    termino '*' factor
    | termino '/' factor
    | factor
    ;

factor:
    ID
    | CONSTANTE
    | invocacion_funcion
    ;

invocacion_funcion:
    ID '(' expresion ')'
    ;

bloque_if:
    IF '(' condicion ')' THEN bloque_sentencias ELSE bloque_sentencias END_IF
    | IF '(' condicion ')' THEN bloque_sentencias END_IF
    ;

bloque_sentencias:
    list_sentencias
    | sentencia_ejecutable
    | BEGIN list_sentencias END
    ;

condicion:
    expresion MAYORIGUAL expresion
    | expresion MENORIGUAL expresion
    | expresion DISTINTO expresion
    | expresion '=' expresion
    | expresion '>' expresion
    | expresion '<' expresion
    ;

salida_mensaje:
    OUTF '(' CADENA ')' ';'
    | OUTF '(' expresion ')' ';'
    ;

%%

// código C asociado
