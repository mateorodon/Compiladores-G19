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
    | declaracion_tipo
    ;

sentencia_ejecutable:
    asignacion
    | invocacion_funcion
    | bloque_if
    | salida_mensaje
    | sentencia_control
    ;

//tema 16
sentencia_control:
    FOR '(' encabezado_for ')' sentencia_ejecutable ';'
    | FOR '(' encabezado_for ')' BEGIN bloque_sentencias_ejecutables END

encabezado_for:
    ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE
    | ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE
    | ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE ';' '(' condicion ')'
    | ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE ';' '(' condicion ')'
    ;

asignacion:
    ID ASIGNACION expresion
    | ID '[' CONSTANTE ']' ASIGNACION expresion
    ;

tipo:
    ULONGINT
    | SINGLE
    | ID
    ;

list_variables:
    list_variables ',' ID
    | ID
    ;

//tema 22
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
    | ID '[' CONSTANTE ']'
    ;

declaracion_tipo:
    | TYPEDEF TRIPLE '<' tipo '>' ID
    ;

invocacion_funcion:
    ID '(' expresion ')'
    | ID '(' tipo expresion ')'
    ;

bloque_if:
    IF '(' condicion ')' THEN sentencia_ejecutable ';' ELSE sentencia_ejecutable ';' END_IF
    | IF '(' condicion ')' THEN sentencia_ejecutable ';' END_IF
    | IF '(' condicion ')' THEN BEGIN bloque_sentencias_ejecutables END ELSE BEGIN bloque_sentencias_ejecutables END END_IF
    | IF '(' condicion ')' THEN BEGIN bloque_sentencias_ejecutables END END_IF
    ;

bloque_sentencias_ejecutables:
    | list_sentencias_ejecutables sentencia_ejecutable ';'
    ;

list_sentencias_ejecutables:
    list_sentencias_ejecutables sentencia_ejecutable ';'
    | sentencia_ejecutable ';'
    ;

comparacion:
    MAYORIGUAL
    | MENORIGUAL
    | DISTINTO
    | '='
    | '>'
    | '<'
    ;
condicion:
    expresion comparacion expresion
    | '(' bloque_list_expresiones ')' comparacion '(' bloque_list_expresiones ')'
    ;

//tema 19
bloque_list_expresiones:
    list_expresiones ',' expresion
    ;

list_expresiones:
    list_expresiones ',' expresion
    | expresion
    ;

salida_mensaje:
    OUTF '(' '{' CADENA '}' ')'  //nosotros a las cadenas le seteamos el lexema sin las llaves, se lo agrego aca.
                            //despues podemos ver si agregarselas en el Analisis Lexico
    | OUTF '(' expresion ')'
    ;

%%

// código C asociado
