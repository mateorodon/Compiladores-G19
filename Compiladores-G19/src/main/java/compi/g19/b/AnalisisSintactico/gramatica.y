%{
package compi.g19.b.AnalisisSintactico;
import java.io.*;
import compi.g19.a.AnalisisLexico.*;
%}
%token ID ASIGNACION MAYORIGUAL MENORIGUAL DISTINTO CONSTANTE CADENA IF THEN ELSE BEGIN END END_IF OUTF TYPEDEF FUN RET ULONGINT SINGLE FOR OR UP DOWN TRIPLE
%%

%start programa

programa: ID BEGIN list_sentencias END {AnalizadorLexico.agregarEstructura("Se reconocio el programa");}
    | ID BEGIN END {yyerror("Programa sin cuerpo");}
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
    tipo list_variables {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
    | declaracion_funcion {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
    | declaracion_tipo {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
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
    FOR '(' encabezado_for ')' bloque_sentencias_ejecutables ';' {AnalizadorLexico.agregarEstructura("Se reconocio un FOR");}

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
    ID ASIGNACION expresion {AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
    | ID '[' CONSTANTE ']' ASIGNACION expresion {AnalizadorLexico.agregarEstructura("Se reconocio una asignacion ");}
    ;

tipo:
    ULONGINT
    | SINGLE
    | ID
    ;

tipo_base:
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
    | invocacion_funcion {AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | ID '[' CONSTANTE ']' //nera: Si esto se utiliza en una expresion, no hace falta reconocerla, no? e daa; pero la invocacion a funcion si, porque es una invocacion pues
    ;

declaracion_tipo:
    | TYPEDEF TRIPLE '<' tipo_base '>' ID
    ;

invocacion_funcion:
    ID '(' expresion ')' {AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | ID '(' tipo_base '(' expresion ')' ')' {AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    ;


bloque_if:
    IF '(' condicion ')' THEN bloque_sentencias_ejecutables ELSE bloque_sentencias_ejecutables END_IF {AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
    | IF '(' condicion ')' THEN bloque_sentencias_ejecutables END_IF {AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
    ;

bloque_sentencias_ejecutables:
    sentencia_ejecutable ';'
    | BEGIN list_sentencias_ejecutables END
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

//putiney: nosotros a las cadenas le seteamos el lexema sin las llaves, se lo agrego aca.
//despues podemos ver si agregarselas en el Analisis Lexico
salida_mensaje:
    OUTF '(' '{' CADENA '}' ')' {AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
    | OUTF '(' expresion ')' {AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
    ;

%%
public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
      this.yylval = new ParserVal(t.getLexema());
      return (int) t.getId();
    }
    return 0;
}

public static void yyerror(String error){
    System.out.println(error);
}