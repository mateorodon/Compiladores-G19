%{
package compi.g19.b.AnalisisSintactico;
import java.io.*;
import compi.g19.a.AnalisisLexico.*;
%}
%token ID ASIGNACION MAYORIGUAL MENORIGUAL DISTINTO CONSTANTE CADENA IF THEN ELSE BEGIN END END_IF OUTF TYPEDEF FUN RET ULONGINT SINGLE FOR OR UP DOWN TRIPLE

%left ','

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
    ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE {AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");}
    | ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE {yyerror("Falta UP/DOWN en el FOR");}
    | ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion ';' up_down {yyerror("Falta constante después de UP/DOWN en el FOR");}
    ;

encabezado_for2:
    ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')' {AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");}
    | ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')' {yyerror("Falta UP/DOWN en el FOR");}
    | ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion ';' up_down '(' condicion ')' {yyerror("Falta constante después de UP/DOWN en el FOR");}
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
    | ID {Token t = TablaSimbolos.getToken($1.sval);
            if (t!= null){
                if (t.getUso() == null || !t.getUso().equals("tipo"))
                    yyerror("El identificador '" + $1.sval + "' no es un tipo definido");
            }
            else {
                yyerror("El identificador '" + $1.sval + "' no es un tipo definido");}
            }
    ;

tipo_base:
    ULONGINT
    | SINGLE
    ;

list_variables:
    list_variables ',' ID //Podriamos probar precedencia en este
    | list_variables ID {yyerror("Las variables deben estar separadas por comas");}
    | ID
    ;

encabezado_funcion:
    tipo FUN ID {addAmbito($3.sval); hasReturn = false;}
    |tipo FUN {yyerror("La funcione debe tener nombre"); hasReturn = false;}
    ;

declaracion_funcion:
    encabezado_funcion '(' parametro ')' BEGIN cuerpo_funcion { if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         removeAmbito();
                                                         } END
    | encabezado_funcion '(' bloque_list_parametro ')' BEGIN cuerpo_funcion END {yyerror("La funcione no puede tener más de un parámetro");removeAmbito();}
    | encabezado_funcion '(' ')' BEGIN cuerpo_funcion END {yyerror("La función debe tener parámetro");removeAmbito();}
    ;

parametro:
    tipo ID
    | ID {yyerror("El parametro debe tener su tipo");}
    ;

bloque_list_parametro:
     list_parametro ',' parametro
     ;

list_parametro:
    parametro
    | list_parametro ',' parametro
    ;

cuerpo_funcion:
    list_sentencias_funcion sentencia_return ';'
    | list_sentencias_funcion
    | sentencia_return ';'
    |  {yyerror("El cuerpo de la funcion no puede ser vacio");}
    ;


list_sentencias_funcion:
    list_sentencias_funcion sentencia
    | sentencia
    ;


sentencia_return:
    RET '(' expresion ')' {if (ambito.length() < 5){  //si es menor es que es main
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           if (!inIF){
                                hasReturn = true;
                           }
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
    TYPEDEF TRIPLE '<' tipo_base '>' ID {Token t = TablaSimbolos.getToken($6.sval);
                                          t.setUso("tipo");}
    | TYPEDEF TRIPLE '<' tipo_base '>' error {yyerror("Falta ID al final de la declaracion de tipo");}
    | TYPEDEF TRIPLE tipo_base '>' ID {yyerror("Falta diamante (<) en la declaracion de tipo");}
    | TYPEDEF TRIPLE '<' tipo_base ID {yyerror("Falta diamante (>) en la declaracion de tipo");}
    | TYPEDEF TRIPLE tipo_base ID {yyerror("Faltan diamantes (</>) en la declaracion de tipo");}
    | TYPEDEF '<' tipo_base '>' ID {yyerror("Falta TRIPLE en la declaracion de tipo");}
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
    | BEGIN list_sentencias_ejecutables END
    | BEGIN error {yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
    ;

encabezado_if:
    IF {inIF=true;}
    ;

bloque_if:
    encabezado_if '(' condicion ')' THEN cuerpo_if_unico fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false;}
    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false;}
    | encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_unico fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false;}
    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false;}
    | encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false;}
    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_unico fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false;}
    ;

cuerpo_if_unico:
    sentencia_ejecutable ';'
    | sentencia_return ';'
    ;

cuerpo_if_bloque:
    BEGIN list_sentencias_ejecutables END {inIF=true;}
    | BEGIN error {yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE"); inIF=true;}
    | list_sentencias_ejecutables END  {yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");inIF=true; }
    | error {yyerror("Se esperaba BEGIN y END por sentencias multiples");}
    ;

list_sentencias_ejecutables:
    list_sentencias_ejecutables sentencia_ejecutable ';' {inIF=true;}
    | sentencia_ejecutable ';'{inIF=true;}
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

static String ambito = "main";
static boolean inIF = false;
static boolean hasReturn = false;

public void addAmbito(String ambitoActual){
    ambito = ambito.concat(":" + ambitoActual);
}

public void removeAmbito(){
        int index = ambito.lastIndexOf(':');

        if (index != -1) {
            ambito = ambito.substring(0, index);
        }
}

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

