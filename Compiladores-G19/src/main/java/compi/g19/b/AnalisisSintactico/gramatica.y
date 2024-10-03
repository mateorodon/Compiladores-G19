%token ID ASIGNACION MAYORIGUAL MENORIGUAL DISTINTO CONSTANTE CADENA IF THEN ELSE BEGIN END END_IF OUTF TYPEDEF FUN RET ULONGINT SINGLE FOR OR UP DOWN TRIPLE
%%

%start programa

programa: ID BEGIN list_sentencias END {AnalisisLexico.agregarEstructura("Se reconocio el programa");}
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
    FOR '(' encabezado_for ')' sentencia_ejecutable ';' {AnalisisLexico.agregarEstructura("Se reconocio un FOR");}
    | FOR '(' encabezado_for ')' BEGIN list_sentencias_ejecutables END {AnalisisLexico.agregarEstructura("Se reconocio un FOR");}

/*
nera: Modifique aca bloque_sentencias_ejecutables => list_sentencias_ejecutables
porque tuve que tocar lo de los IFs
*/

encabezado_for:
    ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE
    | ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE
    | ID ASIGNACION CONSTANTE ';' condicion ';' UP CONSTANTE ';' '(' condicion ')'
    | ID ASIGNACION CONSTANTE ';' condicion ';' DOWN CONSTANTE ';' '(' condicion ')'
    ;

asignacion:
    ID ASIGNACION expresion {AnalisisLexico.agregarEstructura("Se reconocio una asignacion");}
    | ID '[' CONSTANTE ']' ASIGNACION expresion {AnalisisLexico.agregarEstructura("Se reconocio una asignacion ");}
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
    tipo FUN ID '(' parametro ')' BEGIN cuerpo_funcion END {AnalisisLexico.agregarEstructura("Se reconocio una declaracion de funcion");}
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
    | invocacion_funcion {AnalisisLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | ID '[' CONSTANTE ']' //nera: Si esto se utiliza en una expresion, no hace falta reconocerla, no? e daa; pero la invocacion a funcion si, porque es una invocacion pues
    ;

declaracion_tipo:
    | TYPEDEF TRIPLE '<' tipo '>' ID {AnalisisLexico.agregarEstructura("Se reconocio una declaracion de TRIPLE");}
    ;

invocacion_funcion:
    ID '(' expresion ')' {AnalisisLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | ID '(' tipo expresion ')' {AnalisisLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    ;


bloque_if:
    IF '(' condicion ')' THEN bloque_sentencias ELSE bloque_sentencias END_IF {AnalisisLexico.agregarEstructura("Se reconocio un IF_ELSE");}
    | IF '(' condicion ')' THEN bloque_sentencias END_IF {AnalisisLexico.agregarEstructura("Se reconocio un IF");}
    ;

bloque_sentencias:
    sentencia_ejecutable ';'
    | BEGIN list_sentencias_ejecutables END
    ;

list_sentencias_ejecutables:
    list_sentencias_ejecutables sentencia_ejecutable ';'
    | sentencia_ejecutable ';'
    ;

//nera: Modifique estas tres ultimas reglas para que una sola sentencia ejecutable pueda estar dentro de BEGIN..END

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

//putiney: nosotros a las cadenas le seteamos el lexema sin las llaves, se lo agrego aca.
//despues podemos ver si agregarselas en el Analisis Lexico
salida_mensaje:
    OUTF '(' '{' CADENA '}' ')' {AnalisisLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
    | OUTF '(' expresion ')' {AnalisisLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
    ;

%%

// código C asociado
