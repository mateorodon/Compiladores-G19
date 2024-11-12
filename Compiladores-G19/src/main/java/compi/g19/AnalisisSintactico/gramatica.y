%{
package compi.g19.AnalisisSintactico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import compi.g19.AnalisisLexico.*;
import compi.g19.GeneracionDeCodigo.*;
%}
%token ID ASIGNACION MAYORIGUAL MENORIGUAL DISTINTO CONSTANTE CADENA IF THEN ELSE BEGIN END END_IF OUTF TYPEDEF FUN RET ULONGINT SINGLE FOR OR UP DOWN TRIPLE

%left ','

%%

%start programa;

programa: ID BEGIN list_sentencias END {AnalizadorLexico.agregarEstructura("Se reconocio el programa"); raiz = new NodoComun("PROGRAMA", (Nodo)$3.obj);}
    | BEGIN list_sentencias END {yyerror("El programa debe tener un nombre");}
    | ID BEGIN list_sentencias {yyerror("Falta delimitador END del programa");}
    | ID list_sentencias END {yyerror("Falta delimitador BEGIN del programa");}
    | ID list_sentencias {yyerror("Faltan los delimitadores del programa");}
    ;

list_sentencias: list_sentencias sentencia {$$.obj = new NodoComun("SENTENCIA", (Nodo)$1.obj, (Nodo)$2.obj);}
    | sentencia {$$.obj=$1.obj;}
    ;

sentencia:
    sentencia_declarativa ';' {$$.obj = new NodoHoja("Sentencia Declarativa");}
    | sentencia_ejecutable ';' {$$.obj=$1.obj;}
    | sentencia_ejecutable {yyerror("Las sentencias deben terminar con ;");}
    | sentencia_declarativa {yyerror("Las sentencias deben terminar con ;");}
    ;

sentencia_declarativa:
    tipo list_variables {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");
                         for (String var: varDeclaradas){
                            Token t = TablaSimbolos.getToken(var);
                            if (!TablaSimbolos.existeSimbolo(var + ":" + ambito)){
                                t.getLexema().setLength(0);
                                t.getLexema().append(var).append(":").append(ambito);
                                t.setAmbito(ambito);
                                t.setUso("variable");
                                t.setTipo(tipoActual);
                                TablaSimbolos.removeToken(var);
                                TablaSimbolos.addSimbolo(t.getLexema().toString(),t);

                            }
                            else {
                                TablaSimbolos.removeToken(var);
                                variableYaDeclarada(var);
                                }
                         }
                         varDeclaradas = new ArrayList<>();
                        }
    | declaracion_funcion {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de funcion");}
    | declaracion_tipo {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de tipo");}
    ;

sentencia_ejecutable:
    asignacion {AnalizadorLexico.agregarEstructura("Se reconocio una asignacion");}
    | invocacion_funcion {AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | bloque_if
    | salida_mensaje {$$=$1;} //FALTA HACER CON EXPRESION
    | sentencia_control
    ;

//tema 16
sentencia_control:
    FOR '(' encabezado_for ')' bloque_sentencias_ejecutables { $$ = new NodoComun("FOR",(Nodo)$3.obj,(Nodo)$5.obj);}
    |FOR '(' encabezado_for ')' error {yyerror("Falta cuerpo del FOR");}
    |FOR encabezado_for ')' bloque_sentencias_ejecutables {yyerror("Falta parentensis en el FOR");}
    |FOR '(' encabezado_for bloque_sentencias_ejecutables {yyerror("Falta parentensis en el FOR");}
    ;

encabezado_for:
    encabezado_for1 {$$=$1;}
    | encabezado_for2 {$$=$1;}
    ;

encabezado_for1:
    ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE {  String ambitoVar = buscarAmbito(ambito,$1.sval);
                                                                   NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                   if (ambitoVar.equals("")) {
                                                                       agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
                                                                       idAsignacion = new NodoHoja("error semantico"); //??
                                                                   }
                                                                   else {
                                                                       Token t = TablaSimbolos.getToken($1.sval + ":" + ambitoVar);
                                                                       if (!t.getTipo().equals("ENTERO")) {
                                                                           agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                           idAsignacion = new NodoHoja("error semantico"); //??
                                                                       }
                                                                       else {
                                                                           idAsignacion = new NodoHoja($1.sval + ":" + ambitoVar);
                                                                       }
                                                                   }

                                                                    Nodo asignacion = new NodoComun("ASIGNACION", idAsignacion, (Nodo)$3.obj); //Cambie sval x obj esto tiraba error el Parser
                                                                    Nodo incremento = new NodoComun("INCREMENTO", (Nodo)$7.obj, (Nodo)$8.obj); //Idem
                                                                    Nodo condicion = (Nodo)$5.obj;

                                                                    Nodo asgnacionIncremento = new NodoComun("ASIGNACION E INCREMENTO", asignacion, incremento);

                                                                    $$.obj = new NodoComun ("ENCABEZADO FOR", asgnacionIncremento, condicion);

                                                                    AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");
                                                                }
    | ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE {yyerror("Falta UP/DOWN en el FOR");}
    | ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion ';' up_down {yyerror("Falta constante después de UP/DOWN en el FOR");}
    ;

encabezado_for2:
    ID ASIGNACION CONSTANTE ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')' {String ambitoVar = buscarAmbito(ambito,$1.sval);
                                                                                       NodoHoja idAsignacion = new NodoHoja("error semantico");
                                                                                       if (ambitoVar.equals("")) {
                                                                                            agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
                                                                                            idAsignacion = new NodoHoja("error semantico"); //??
                                                                                       }
                                                                                       else {
                                                                                             Token t = TablaSimbolos.getToken($1.sval + ":" + ambitoVar);
                                                                                             if (!t.getTipo().equals("ENTERO")) {
                                                                                                    agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                                                    idAsignacion = new NodoHoja("error semantico"); //??
                                                                                             }
                                                                                             else {
                                                                                                    idAsignacion = new NodoHoja($1.sval + ":" + ambitoVar);
                                                                                             }
                                                                                       }

                                                                                       Nodo asignacion = new NodoComun("ASIGNACION", idAsignacion, (Nodo)$3.obj); //Cambie sval x obj
                                                                                       Nodo incremento = new NodoComun("INCREMENTO", (Nodo)$7.obj, (Nodo)$8.obj); //Idem
                                                                                       Nodo condicion = (Nodo)$5.obj;
                                                                                       Nodo iteradorCondicion = (Nodo)$11.obj;

                                                                                       Nodo asgnacionIncremento = new NodoComun("ASIGNACION E INCREMENTO", asignacion, incremento);
                                                                                       Nodo condiciones = new NodoComun("ASIGNACION E INCREMENTO", condicion, iteradorCondicion);

                                                                                       $$.obj = new NodoComun ("ENCABEZADO FOR", asgnacionIncremento, condiciones);

                                                                                       AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");
                                                                                       }

    | ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')' {yyerror("Falta UP/DOWN en el FOR");}
    | ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion ';' up_down '(' condicion ')' {yyerror("Falta constante después de UP/DOWN en el FOR");}
    ;

up_down:
    UP {$$.obj = new NodoHoja("UP");}
    |DOWN {$$.obj = new NodoHoja("DOWN");}
    ;

asignacion:
    ID ASIGNACION expresion { String ambitoVar = buscarAmbito(ambito,$1.sval);
                              if (ambitoVar.equals(""))
                                  agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
                              else {
                                  Token t = TablaSimbolos.getToken($1.sval + ":" + ambitoVar);
                                  if (!t.getUso().equals("variable"))
                                    agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")" );
                                    //new NodoHoja("error semantico"); ??
                                  else {
                                    NodoHoja id = new NodoHoja($1.sval + ":" + ambitoVar);

                                  }
                              }
                            }
    | ID '[' CONSTANTE ']' ASIGNACION expresion
    | ID ASIGNACION error {yyerror("Falta parte derecha de la asignacion");}
    ;

tipo:
    tipo_base
    | ID { String ambitoVar = buscarAmbito(ambito,$1.sval);
           if (ambitoVar.equals(""))
                agregarErrorSemantico("El tipo '" + $1.sval + "' no fue declarado");
           else {
            Token t = TablaSimbolos.getToken($1.sval + ":" + ambitoVar);
            if (t.getUso() == null || !t.getUso().equals("tipo"))
                yyerror("El identificador '" + $1.sval + "' no es un tipo definido");
            else {
                tipoActual = $1.sval;
            }
            }
         }
    ;

tipo_base:
    ULONGINT {tipoActual = $1.sval;}
    | SINGLE {tipoActual = $1.sval;}
    ;

list_variables:
    list_variables ',' ID {varDeclaradas.add($3.sval);}
    | list_variables ID {yyerror("Las variables deben estar separadas por comas");}
    | ID {varDeclaradas.add($1.sval);}
    ;

encabezado_funcion:
    tipo FUN ID {hasReturn = false;
                String idFuncion = $3.sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (!TablaSimbolos.existeSimbolo(idFuncion + ":" + ambito)){
                    t.getLexema().setLength(0);
                    t.getLexema().append(idFuncion).append(":").append(ambito);
                    t.setAmbito(ambito);
                    t.setUso("funcion");
                    t.setTipo(tipoActual);
                    TablaSimbolos.removeToken(idFuncion);
                    TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                    String funcion = $1.sval + $2.sval + $3.sval;
                    $$.obj = funcion;
                 }
                 else {
                    TablaSimbolos.removeToken(idFuncion);
                    variableYaDeclarada(idFuncion);
                 }
                 addAmbito(idFuncion);
                 }
    |tipo FUN {yyerror("La funcione debe tener nombre"); hasReturn = false;}
    ;

declaracion_funcion:
    encabezado_funcion '(' parametro ')' BEGIN cuerpo_funcion { if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         String parametro = $3.sval;
                                                         Token t = TablaSimbolos.getToken(parametro);
                                                         if (!TablaSimbolos.existeSimbolo(parametro + ":" + ambito)){
                                                             t.getLexema().setLength(0);
                                                             t.getLexema().append(parametro).append(":").append(ambito);
                                                             t.setAmbito(ambito);
                                                             t.setUso("parametro");
                                                             t.setTipo(tipoActual);
                                                             TablaSimbolos.removeToken(parametro);
                                                             TablaSimbolos.addSimbolo(t.getLexema().toString(),t);

                                                             //Agregar paremetro a lista de parametros, para luego chequear en la llamada a funcion si coincide con este

                                                             Nodo funcion = new NodoComun("FUNCION", (Nodo)$1.obj, (Nodo)$6.obj);
                                                             funcionesDeclaradas.add(funcion);
                                                             $$.obj = funcion;
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
    list_sentencias_funcion sentencia_return ';' {$$ = new NodoComun("SENTENCIA", (Nodo) $1.obj, (Nodo) $2.obj);}
    | list_sentencias_funcion {$$=$1;}
    | sentencia_return ';' {$$=$1;}
    |  {yyerror("El cuerpo de la funcion no puede ser vacio");}
    ;


list_sentencias_funcion:
    list_sentencias_funcion sentencia {$$ = new NodoComun("SENTENCIA", (Nodo) $1.obj, (Nodo) $2.obj);}
    | sentencia {$$=$1;}
    ;


sentencia_return:
    RET '(' expresion ')' {if (ambito.length() < 5){  //si es menor es que es main
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           if (!inIF){
                                hasReturn = true;
                                $$ = new NodoComun("RETURN", (Nodo)$3.obj);
                           }
                           //$$ = new NodoComun("RETURN", (Nodo)$3.obj);   DONDE VA?
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
    ;

expresion:
    expresion '+' termino { $$ = new NodoComun($2.sval, (Nodo)$1, (Nodo)$3);
                            if (!(((Nodo)$1).getLexema().contains("error") || ((Nodo)$1).getLexema().contains("error"))) {
                                if (!(((Nodo)$1).getTipo().equals(((Nodo)$3).getTipo())))
                                    agregarErrorSemantico("Incompatibilidad de tipos en la suma.");
                                else
                                    ((Nodo)$$).setTipo(((Nodo)$1).getTipo());
                            }
                            }
    | expresion '-' termino { $$ = new NodoComun($2.sval, (Nodo)$1, (Nodo)$3);
                              if (!(((Nodo)$1).getLexema().contains("error") || ((Nodo)$1).getLexema().contains("error"))) {
                                if (!(((Nodo)$1).getTipo().equals(((Nodo)$3).getTipo())))
                                    agregarErrorSemantico("Incompatibilidad de tipos en la resta.");
                                else
                                    ((Nodo)$$).setTipo(((Nodo)$1).getTipo());
                              }
                              }
    | termino {$$.obj = $1;}
    | expresion '+' error {yyerror("Se esperaba un termino");}
    | expresion '-' error {yyerror("Se esperaba un termino");}
    ;

termino:
    termino '*' factor { $$ = new NodoComun($2.sval, (Nodo)$1, (Nodo)$3);
                         if (!(((Nodo)$1).getLexema().contains("error") || ((Nodo)$1).getLexema().contains("error"))) {
                            if (!(((Nodo)$1).getTipo().equals(((Nodo)$3).getTipo())))
                                agregarErrorSemantico("Incompatibilidad de tipos en la multiplicacion.");
                            else
                                ((Nodo)$$).setTipo(((Nodo)$1).getTipo());
                         }
                         }
    | termino '/' factor { $$ = new NodoComun($2.sval, (Nodo)$1, (Nodo)$3);
                            if (!(((Nodo)$1).getLexema().contains("error") || ((Nodo)$1).getLexema().contains("error"))) {
                                if (!(((Nodo)$1).getTipo().equals(((Nodo)$3).getTipo())))
                                    agregarErrorSemantico("Incompatibilidad de tipos en la division.");
                                else
                                    ((Nodo)$$).setTipo(((Nodo)$1).getTipo());
                            }
                            }
    | factor {$$ = $1;}
    | termino '*' error {$$ = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
    | termino '/' error {$$ = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
    ;

factor:
    ID {String ambitoVar = buscarAmbito(ambito,$1.sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
            $$ = new NodoHoja("error");
        }
        else {
            Token t = TablaSimbolos.getToken($1.sval + ":" + ambitoVar);
            if (!t.getUso().equals("variable"))
                agregarErrorSemantico("'" + $1.sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                $$ = new NodoHoja($1.sval + ":" + ambitoVar,t);
                TablaSimbolos.removeToken($1.sval);
            }
        }
        }
    | CONSTANTE {Token t = TablaSimbolos.getToken($1.sval);
                if (t != null && (t.getTipo().equals(FLOTANTE))) {
                    String lexema = t.getLexema().toString();
                    chequeoFlotantesPositivos(lexema);
                    $$ = new NodoHoja($1.sval,t);
                }
                else
                    $$ = new NodoHoja("error");
                }
    | invocacion_funcion {AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | ID '[' CONSTANTE ']'
    | '-' ID {String ambitoVar = buscarAmbito(ambito,$2.sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + $2.sval + "' no fue declarada");
                         $$ = new NodoHoja("error");
                     }
                     else {
                         Token t = TablaSimbolos.getToken($2.sval + ":" + ambitoVar);
                         if (!t.getUso().equals("variable"))
                             agregarErrorSemantico("'" + $2.sval + "' no es una variable. Es un/a " + t.getUso());
                         else {
                             $$ = new NodoHoja($2.sval + ":" + ambitoVar,t);
                             TablaSimbolos.removeToken($2.sval);
                         }
                     }
                     }
    | '-' CONSTANTE {Token t = TablaSimbolos.getToken($2.sval);
                                        if (t != null && t.getTipo().equals(ENTERO))
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                    }
    | '-' ID '[' CONSTANTE ']'
    ;

declaracion_tipo:
    TYPEDEF TRIPLE '<' tipo_base '>' ID {String idTipo = $6.sval;
                                         Token t = TablaSimbolos.getToken(idTipo);
                                         if (!TablaSimbolos.existeSimbolo(idTipo + ":" + ambito)){
                                            t.getLexema().setLength(0);
                                            t.getLexema().append(idTipo).append(":").append(ambito);
                                            t.setAmbito(ambito);
                                            t.setUso("tipo");
                                            t.setTipo($4.sval);
                                            TablaSimbolos.removeToken(idTipo);
                                            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                            tiposDeclarados.put($6.sval, $4.sval);
                                            }
                                         else {
                                            TablaSimbolos.removeToken(idTipo);
                                            variableYaDeclarada(idTipo);
                                         }
                                         }
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
    sentencia_ejecutable ';' {$$=$1;}
    | BEGIN list_sentencias_ejecutables END {$$=$2;}
    | BEGIN error {yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo FOR");}
    ;

encabezado_if:
    IF {inIF=true; $$=$1;}
    ;

bloque_if:
    encabezado_if '(' condicion ')' THEN cuerpo_if_unico fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; $$.obj = new NodoComun("CUERPO",(Nodo)$6.obj);
                                                                                                                                              Nodo cuerpo = (Nodo)$$.obj;
                                                                                                                                              $$.obj = new NodoComun("IF", (Nodo)$3.obj, cuerpo);}
    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; $$.obj = new NodoComun("CUERPO", (Nodo)$6.obj);
                                                                                                                                          Nodo cuerpo = (Nodo)$$.obj;
                                                                                                                                          $$.obj = new NodoComun("IF", (Nodo)$3.obj, cuerpo);}


    | encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_unico fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; $$.obj = new NodoComun("CUERPO", (Nodo)$6.obj, (Nodo)$8.obj);
                                                                                                                                                                          Nodo cuerpo = (Nodo)$$.obj;
                                                                                                                                                                          $$.obj = new NodoComun("IF", (Nodo)$3.obj,(Nodo)$6.obj);}

    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; $$.obj = new NodoComun("CUERPO", (Nodo)$6.obj, (Nodo)$8.obj);
                                                                                                                                                                            Nodo cuerpo = (Nodo)$$.obj;
                                                                                                                                                                            $$.obj = new NodoComun("IF", (Nodo)$3.obj,(Nodo)$6.obj);}

    | encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; $$.obj = new NodoComun("CUERPO", (Nodo)$6.obj, (Nodo)$8.obj);
                                                                                                                                                                  Nodo cuerpo = (Nodo)$$.obj;
                                                                                                                                                                  $$.obj = new NodoComun("IF", (Nodo)$3.obj,(Nodo)$6.obj);}

    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_unico fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; $$.obj = new NodoComun("CUERPO", (Nodo)$6.obj, (Nodo)$8.obj);
                                                                                                                                                                   Nodo cuerpo = (Nodo)$$.obj;
                                                                                                                                                                   $$.obj = new NodoComun("IF", (Nodo)$3.obj,(Nodo)$6.obj); }
    | encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico fin_if {yyerror("Falta THEN en IF");}
    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque cuerpo_if_unico fin_if {yyerror("Falta ELSE en IF");}
    | encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico {yyerror("Falta END_IF en IF");}

    ;

cuerpo_if_unico:
    sentencia_ejecutable ';' {$$ = $1;}
    | sentencia_return ';' {$$ = $1;}
    ;

cuerpo_if_bloque:
    BEGIN list_sentencias_ejecutables END {$$ = $2;}
    | BEGIN error {yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
    | list_sentencias_ejecutables END  {yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
    | error {yyerror("Se esperaba BEGIN y END por sentencias multiples");}
    ;

list_sentencias_ejecutables:
    list_sentencias_ejecutables sentencia_ejecutable ';' {$$ = new NodoComun("SENTENCIA", (Nodo) $1.obj, (Nodo) $2.obj);}
    | sentencia_ejecutable ';' {$$ = $1;}
    ;


comparacion:
    MAYORIGUAL {$$ = new NodoHoja($1.sval);}
    | MENORIGUAL {$$ = new NodoHoja($1.sval);}
    | DISTINTO {$$ = new NodoHoja($1.sval);}
    | '=' {$$ = new NodoHoja($1.sval);}
    | '>' {$$ = new NodoHoja($1.sval);}
    | '<' {$$ = new NodoHoja($1.sval);}
    ;

condicion:
    expresion comparacion expresion {$$ = new NodoComun($2.sval, (Nodo)$1.obj, (Nodo)$3.obj);}
    | '(' bloque_list_expresiones ')' comparacion '(' bloque_list_expresiones ')' { $$ = new NodoComun($4.sval, (Nodo)$2.obj, (Nodo)$4.obj);
                                                                                    AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
                                                                                  }

    | error {yyerror("Falta comparador en la condicion");}
    ;

//tema 19
bloque_list_expresiones:
    list_expresiones ',' expresion {$$ = new NodoComun("SENTENCIA", (Nodo) $1.obj, (Nodo) $3.obj);}
    ;

list_expresiones:
    list_expresiones ',' expresion  {$$ = new NodoComun("SENTENCIA", (Nodo) $1.obj, (Nodo) $3.obj);}
    | expresion {$$=$1;}
    | error {yyerror("Falta expresion en pattern matching");}
    ;

salida_mensaje:
    OUTF '(' CADENA ')' {   $$ = new NodoComun("OUTF", new NodoHoja($3.sval));
                            Token t = TablaSimbolos.getToken($3.sval); //Obtenemos el token, faltaba esto
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
    | OUTF '(' expresion ')' {AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");}
    | OUTF '('')' {yyerror("Falta de parametro en funcion OUTF");}
    ;

%%
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;

static NodoComun raiz;
static String ambito = "main";
static boolean inIF = false;
static boolean hasReturn = false;
static List<String> varDeclaradas = new ArrayList<>();
static String tipoActual;
static List<String> erroresSemanticos = new ArrayList<>();
static Map<String,String> tiposDeclarados = new HashMap<>(); //clave: lexema del tipo ; valor: tipo del tipo
static List<Nodo> funcionesDeclaradas = new ArrayList<>();

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

public void addAmbito(String ambitoActual){
    ambito = ambito.concat(":" + ambitoActual);
}

public void removeAmbito(){
        int index = ambito.lastIndexOf(':');

        if (index != -1) {
            ambito = ambito.substring(0, index);
        }
}

private void chequeoFlotantesPositivos(String lexema){
    float valor = Float.parseFloat(lexema);
    if  ((valor != 0f) && (valor < AccionSemantica.SINGLE_POSITIVE_MIN || valor >= Float.POSITIVE_INFINITY)) {
        yyerror("Constante flotante fuera de rango");
    }
}

private boolean hayErrores(String lexema){
    return !erroresSemanticos.isEmpty();
}

public String buscarAmbito(String ambitoActual, String lexema) {
    String ambito = ambitoActual;

    while (!TablaSimbolos.existeSimbolo(lexema + ":" + ambito)) {
        if (ambito.equals("main")) {
            return "";
        }
        int index = ambito.lastIndexOf(':');
        if (index == -1) {
            return "";
        }

        ambito = ambito.substring(0, index); // Reduce el ámbito
    }
    
    return ambito;
}

public static void agregarErrorSemantico(String error){
    erroresSemanticos.add(error + " en la linea " + AnalizadorLexico.lineaAct);
}

public static void imprimirErroresSemanticos(){
    for (String e : erroresSemanticos)
        System.out.println(e);
}

private void variableYaDeclarada(String var){
    Token t1 = TablaSimbolos.getToken(var + ":" + ambito);
    switch (t1.getUso()) {
        case "variable":
            agregarErrorSemantico("Ya existe una variable con el nombre '" + var + "' definida en este ámbito");
            break;
        case "funcion":
            agregarErrorSemantico("Ya existe una función con el nombre '" + var + "' definida en este ámbito");
            break;
        case "tipo":
            agregarErrorSemantico("Ya existe un tipo con el nombre '" + var + "' definido en este ámbito");
            break;
        default:
            break;
    }
}

public NodoComun getRaiz(){
    return this.raiz;
}
