%{
package compi.g19.b.AnalisisSintactico;
import java.io.*;
import compi.g19.a.AnalisisLexico.*;
%}
%token ID ASIGNACION MAYORIGUAL MENORIGUAL DISTINTO CONSTANTE CADENA IF THEN ELSE BEGIN END END_IF OUTF TYPEDEF FUN RET ULONGINT SINGLE FOR OR UP DOWN TRIPLE
%%

%start programa;

programa: ID BEGIN list_sentencias END {AnalizadorLexico.agregarEstructura("Se reconocio el programa");}
    | BEGIN list_sentencias END {yyerror("El programa debe tener un nombre");}
    | ID BEGIN list_sentencias {yyerror("Falta delimitador END del programa");}
    | ID list_sentencias END {yyerror("Falta delimitador BEGIN del programa");}
    | ID list_sentencias {yyerror("Faltan los delimitadores del programa");}
    ;

list_sentencias: list_sentencias sentencia
    | sentencia
    ;

sentencia:
    sentencia_declarativa ';'
    | sentencia_ejecutable ';'
    | sentencia_ejecutable {yyerror("Las sentencias deben terminar con ;");}
    | sentencia_declarativa {yyerror("Las sentencias deben terminar con ;");}
    ;

sentencia_declarativa:
    tipo list_variables {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");}
    | declaracion_funcion {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
    | declaracion_tipo {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
    ;

sentencia_ejecutable:
    asignacion {AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
    | invocacion_funcion {AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | bloque_if
    | salida_mensaje
    | sentencia_control
    ;

//tema 16
sentencia_control:
    FOR '(' encabezado_for ')' bloque_sentencias_ejecutables
    |FOR '(' encabezado_for ')' error {yyerror("Falta cuerpo del FOR");}
    |FOR encabezado_for ')' bloque_sentencias_ejecutables {yyerror("Falta parentensis en el FOR");}
    |FOR '(' encabezado_for bloque_sentencias_ejecutables {yyerror("Falta parentensis en el FOR");}
    ;

encabezado_for:
    encabezado_for1
    | encabezado_for2
    ;

encabezado_for1:
    ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE {AnalizadorLexico.agregarEstructura("Se reconocio un FOR de 3");}
    | ID ASIGNACION CONSTANTE ';' condicion ';'  CONSTANTE {yyerror("Falta UP/DOWN en el FOR");}
    | ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE {yyerror("Falta ; en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE {yyerror("Falta ; en el FOR");}
    ;

encabezado_for2:
    ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')' {AnalizadorLexico.agregarEstructura("Se reconocio un FOR con condicion");}
    | ID ASIGNACION CONSTANTE ';' condicion ';'  CONSTANTE ';' '(' condicion ')' {yyerror("Falta UP/DOWN en el FOR");}
    | ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ; en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ; en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE  '(' condicion ')' {yyerror("Falta ; en el FOR");}
    ;

up_down:
    UP
    |DOWN
    ;

asignacion:
    ID ASIGNACION expresion
    | ID '[' CONSTANTE ']' ASIGNACION expresion
    | ID ASIGNACION error {yyerror("Falta parte derecha de la asignacion");}
    ;

tipo:
    tipo_base
    | ID
    ;

tipo_base:
    ULONGINT
    | SINGLE
    ;

list_variables:
    list_variables ',' ID //Podriamos probar precedencia en este
    | ID
    ;

declaracion_funcion:
    tipo FUN ID '(' parametro ')' BEGIN {inFunction = true; hasReturn = false;} cuerpo_funcion { if (!hasReturn) {
                                                                                                 	yyerror("Falta sentencia RET en la función");
                                                                                                 }
                                                                                                 inFunction = false;
                                                                                                 } END
    | tipo FUN ID '(' bloque_list_parametro ')' BEGIN cuerpo_funcion END {yyerror("La funcione no puede tener más de un parámetro");}
    | tipo FUN '(' parametro ')' BEGIN cuerpo_funcion END {yyerror("La funcione debe tener nombre");}
    | tipo FUN ID '(' ')' BEGIN cuerpo_funcion END {yyerror("La función debe tener parámetro");}
    ;

parametro:
    tipo ID
    | ID {yyerror("El parametro debe tener su tipo");}
    ;

bloque_list_parametro:
     list_parametro ',' parametro

list_parametro:
    parametro
    | list_parametro ',' parametro
    ;

cuerpo_funcion:
    list_sentencias_funcion sentencia_return ';'
    | list_sentencias_funcion
    | sentencia_return ';'
    ;

list_sentencias_funcion:
    list_sentencias_funcion sentencia
    | sentencia
    ;


sentencia_return:
    RET '(' expresion ')' {if (!inFunction) {
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           hasReturn = true;
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
    ;

expresion:
    expresion '+' termino
    | expresion '-' termino
    | termino
    | expresion '+' error {yyerror("Se esperaba un termino");}
    | expresion '-' error {yyerror("Se esperaba un termino");}
    ;

termino:
    termino '*' factor
    | termino '/' factor
    | factor
    | termino '*' error {yyerror("Se esperaba un factor");}
    | termino '/' error {yyerror("Se esperaba un factor");}
    ;

factor:
    ID
    | CONSTANTE {Token t = TablaSimbolos.getToken($1.sval);
                                 if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                     String lexema = t.getLexema().toString();
                                     chequeoFlotantesPositivos(lexema);

                                 }
                 }
    | invocacion_funcion {AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | ID '[' CONSTANTE ']'
    | '-' ID
    | '-' CONSTANTE {Token t = TablaSimbolos.getToken($1.sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
    | '-' ID '[' CONSTANTE ']'
    ;

declaracion_tipo:
    TYPEDEF TRIPLE '<' tipo_base '>' ID //ID ES TIPO (AS)
    | TYPEDEF TRIPLE '<' tipo_base '>' error {yyerror("Falta ID al final de la declaracion de tipo");}
    | TYPEDEF TRIPLE tipo_base '>' ID {yyerror("Falta diamante (<) en la declaracion de tipo");}
    | TYPEDEF TRIPLE '<' tipo_base ID {yyerror("Falta diamante (>) en la declaracion de tipo");}
    ;

invocacion_funcion:
    ID '(' expresion ')'
    | ID '(' bloque_list_expresiones ')' {yyerror("La funcion no puede tener mas de un parametro");}
    | ID '(' ')' {yyerror("La funcion debe tener un parametro");}
    | ID '(' tipo_base '(' expresion ')' ')' {AnalizadorLexico.agregarEstructura("Se reconocio conversion");}
    ;

fin_if:
    END_IF
    | error {yyerror("La sentencia IF deben terminar con END_IF");}
    ;

bloque_sentencias_ejecutables:
    sentencia_ejecutable ';'
    | sentencia_ejecutable error {yyerror("Las sentencias deben terminar con ;");}
    | BEGIN list_sentencias_ejecutables END
    ;

bloque_if:
    IF '(' condicion ')' THEN cuerpo_if ELSE cuerpo_if fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF_ELSE");}
    | IF '(' condicion ')' THEN cuerpo_if fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF");}
    | IF '(' condicion ')' THEN cuerpo_if ELSE error fin_if {yyerror("Falta contenido en el bloque ELSE");}
    | IF '(' condicion ')' THEN error fin_if {yyerror("Falta contenido en el bloque THEN");}
    | IF  condicion ')' THEN cuerpo_if fin_if {yyerror("Falta paréntesis '(' en la condición del IF");}
    | IF '(' condicion THEN cuerpo_if fin_if {yyerror("Falta paréntesis ')' en la condición del IF");}
    | IF  condicion ')' THEN cuerpo_if ELSE cuerpo_if fin_if {yyerror("Falta paréntesis '(' en la condición del IF");}
    | IF '(' condicion  THEN cuerpo_if ELSE cuerpo_if fin_if {yyerror("Falta paréntesis ')' en la condición del IF");}
    ;

cuerpo_if:
    bloque_sentencias_ejecutables
    | BEGIN list_sentencias_ejecutables sentencia_return ';' END
    | sentencia_return ';'
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
    | '(' bloque_list_expresiones ')' comparacion '(' bloque_list_expresiones ')' {AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");}
    | error {yyerror("Falta comparador en la condicion");}
    ;

//tema 19
bloque_list_expresiones:
    list_expresiones ',' expresion
    ;

list_expresiones:
    list_expresiones ',' expresion
    | expresion
    | error {yyerror("Falta expresion en pattern matching");}
    ;

salida_mensaje:
    OUTF '(' CADENA ')' {AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
    | OUTF '(' expresion ')' {AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
    | OUTF '('')' {yyerror("Falta de parametro en funcion OUTF");}
    ;

%%
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;
static boolean inFunction = false;
static boolean hasReturn = false;

public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
      System.out.println(t);
      this.yylval = new ParserVal(t.getLexema().toString());
      return (int) t.getId();
    }
    return 0;
}

public static void yyerror(String error){
    AnalizadorLexico.agregarErrorSintactico(error);
}

private void chequeoFlotantesPositivos(String lexema){
    float valor = Float.parseFloat(lexema);
    if  ((valor != 0f) && (valor < AccionSemantica.SINGLE_POSITIVE_MIN || valor >= Float.POSITIVE_INFINITY)) {
        yyerror("Constante flotante fuera de rango");
    }
}

