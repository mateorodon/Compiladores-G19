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

list_sentencias: list_sentencias sentencia {$$.obj = new NodoComun("Sentencia", (Nodo)$1.obj, (Nodo)$2.obj);}
    | sentencia {$$.obj=$1.obj;}
    ;

sentencia:
    sentencia_declarativa ';' {$$.obj = new NodoHoja("Sentencia Declarativa");}
    | sentencia_ejecutable ';' {$$=$1;}
    | sentencia_ejecutable {yyerror("Las sentencias deben terminar con ;");}
    | sentencia_declarativa {yyerror("Las sentencias deben terminar con ;");}
    ;

sentencia_declarativa:
    tipo list_variables {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");
                         for (String var: varDeclaradas){
                            Token t = TablaSimbolos.getToken(var);
                            if (!TablaSimbolos.existeSimbolo(var + ":" + ambito)){
                                String tipo = t.getTipo();
                                if (tipo != null){
                                    if (tipo.toLowerCase().equals(tipoActual.toLowerCase()))
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya esta declarada");
                                    else
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya estaba declarada. Se cambio su tipo a " + tipoActual);
                                }
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
    asignacion {AnalizadorLexico.agregarEstructura("Se reconocio una asignacion"); $$=$1;}
    | invocacion_funcion {$$ = $1; AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | bloque_if {$$=$1;}
    | salida_mensaje {$$=$1;}
    | sentencia_control {$$=$1;}
    ;

//tema 16
sentencia_control:
    FOR '(' encabezado_for ')' bloque_sentencias_ejecutables { $$.obj = new NodoComun("For",(Nodo)$3.obj,(Nodo)$5.obj);}
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
                                                                       if (!t.getTipo().equals(ENTERO)) {
                                                                           agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                           idAsignacion = new NodoHoja("error semantico"); //??
                                                                       }
                                                                       else {
                                                                           idAsignacion = new NodoHoja($1.sval + ":" + ambitoVar);
                                                                       }
                                                                   }

                                                                    NodoHoja constante = new NodoHoja($3.sval);
                                                                    Nodo asignacion = new NodoComun($2.sval, idAsignacion, constante); //Cambie sval x obj esto tiraba error el Parser

                                                                    NodoHoja constanteUpDown = new NodoHoja($8.sval);
                                                                    Nodo incremento = new NodoComun("Incremento", (Nodo)$7.obj, constanteUpDown); //Idem
                                                                    Nodo condicion = (Nodo)$5.obj;

                                                                    Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento", asignacion, incremento);

                                                                    $$.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condicion);

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
                                                                                             if (!t.getTipo().equals(ENTERO)) {
                                                                                                    agregarErrorSemantico("La variable de la asignacion debe ser de tipo ENTERO");
                                                                                                    idAsignacion = new NodoHoja("error semantico"); //??
                                                                                             }
                                                                                             else {
                                                                                                    idAsignacion = new NodoHoja($1.sval + ":" + ambitoVar);
                                                                                             }
                                                                                       }

                                                                                       Nodo asignacion = new NodoComun("Asignacion", idAsignacion, (Nodo)$3.obj); //Cambie sval x obj
                                                                                       Nodo incremento = new NodoComun("Incremento", (Nodo)$7.obj, (Nodo)$8.obj); //Idem
                                                                                       Nodo condicion = (Nodo)$5.obj;
                                                                                       Nodo iteradorCondicion = (Nodo)$11.obj;

                                                                                       Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento", asignacion, incremento);
                                                                                       Nodo condiciones = new NodoComun("Condiciones", condicion, iteradorCondicion);

                                                                                       $$.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condiciones);

                                                                                       AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");
                                                                                       }

    | ID ASIGNACION CONSTANTE ';' condicion ';' CONSTANTE ';' '(' condicion ')' {yyerror("Falta UP/DOWN en el FOR");}
    | ID ASIGNACION CONSTANTE condicion ';' up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ';' en el FOR");}
    | ID ASIGNACION CONSTANTE ';' condicion ';' up_down '(' condicion ')' {yyerror("Falta constante después de UP/DOWN en el FOR");}
    ;

up_down:
    UP {$$.obj = new NodoHoja("Up");}
    |DOWN {$$.obj = new NodoHoja("Down");}
    ;

asignacion:
    ID ASIGNACION expresion { String ambitoVar = buscarAmbito(ambito,$1.sval);
                              Nodo asignacion = null;
                              if (ambitoVar.equals("")){
                                  Token t = TablaSimbolos.getToken($1.sval);
                                  if (t == null)
                                        agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
                                  else {
                                        String var = $1.sval;
                                        if (var.charAt(0) == 's' || var.charAt(0) == 'S')
                                            t.setTipo(FLOTANTE);
                                        if (var.charAt(0) == 'x' || var.charAt(0) == 'X' || var.charAt(0) == 'y'
                                        || var.charAt(0) == 'Y' || var.charAt(0) == 'z' || var.charAt(0) == 'Z')
                                            t.setTipo(ENTERO);
                                        t.getLexema().setLength(0);
                                        t.getLexema().append(var).append(":").append(ambito);
                                        t.setAmbito(ambito);
                                        t.setUso("variable");
                                        TablaSimbolos.removeToken(var);
                                        TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                  }
                              }
                              else {
                                  Token t = TablaSimbolos.getToken($1.sval + ":" + ambitoVar);
                                  if (!(t.getUso().equals("variable") || t.getUso().equals("parametro"))){
                                    agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")" );
                                    asignacion = new NodoHoja("error semantico");
                                  }else {
                                    NodoHoja id = new NodoHoja($1.sval +":"+ambitoVar);
                                    asignacion= new NodoComun($2.sval ,id, (Nodo)$3.obj);
                                  }
                              }
                              $$.obj = asignacion;
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
                enFuncion = true;
                String idFuncion = $3.sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (!TablaSimbolos.existeSimbolo(idFuncion + ":" + ambito)){
                    t.getLexema().setLength(0);
                    t.getLexema().append(idFuncion).append(":").append(ambito); //aca agrega una vez el ambito
                    t.setAmbito(ambito);
                    t.setUso("funcion");
                    t.setTipo(tipoActual);
                    TablaSimbolos.removeToken(idFuncion);
                    TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                 }
                 else {
                    TablaSimbolos.removeToken(idFuncion);
                    variableYaDeclarada(idFuncion);
                 }
                 NodoComun encabezado = new NodoComun(idFuncion + ":" + ambito);
                 encabezado.setTipo(tipoActual);
                 addAmbito(idFuncion);
                 $$.obj = encabezado;
                 }
    |tipo FUN {yyerror("La funcione debe tener nombre"); hasReturn = false;}
    ;

declaracion_funcion:
    encabezado_funcion '(' parametro ')' BEGIN cuerpo_funcion { if (!hasReturn) {
                                                            yyerror("Falta sentencia RET en la función");
                                                         }
                                                         Nodo parametro = (Nodo)$3.obj;
                                                         Token t = TablaSimbolos.getToken(parametro.getNombre());
                                                         if (!TablaSimbolos.existeSimbolo(parametro.getNombre() + ":" + ambito)){
                                                             String tipo = t.getTipo();
                                                             if (tipo != null)
                                                                AnalizadorLexico.agregarWarning("La variable '" + parametro.getNombre() + "' ya esta declarada");
                                                             t.getLexema().setLength(0);
                                                             t.getLexema().append(parametro.getNombre()).append(":").append(ambito);
                                                             t.setAmbito(ambito);
                                                             t.setUso("parametro");
                                                             t.setTipo(tipoActual);
                                                             TablaSimbolos.removeToken(parametro.getNombre());
                                                             TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                                         }
                                                         NodoComun funcion = (NodoComun)$1.obj; //Encabezado con nombre funcion, este tiene el tipo

                                                         funcion.setIzq(parametro); //Parametro
                                                         funcion.setDer((Nodo)$6.obj); //Cuerpo funcion

                                                         funcionesDeclaradas.put(funcion.getNombre(),funcion);
                                                         removeAmbito();
                                                         enFuncion = false;
                                                         } END
    | encabezado_funcion '(' bloque_list_parametro ')' BEGIN cuerpo_funcion END {yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
    | encabezado_funcion '(' ')' BEGIN cuerpo_funcion END {yyerror("La función debe tener parámetro");removeAmbito();}
    ;

parametro:
    tipo ID {
               Token t = TablaSimbolos.getToken($2.sval);
               if (t != null){
                   t.getLexema().setLength(0);
                   t.getLexema().append($2.sval).append(":").append(ambito);
                   t.setAmbito(ambito);
                   t.setUso("parametro");
                   t.setTipo(tipoActual);
                   TablaSimbolos.removeToken($2.sval);
                   TablaSimbolos.addSimbolo(String.valueOf(t.getLexema()),t);
               }
              Nodo param = new NodoHoja($2.sval);
              param.setTipo($1.sval);
              $$.obj = param;
            }
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
    list_sentencias_funcion sentencia_return ';' {  $$.obj = new NodoComun("Sentencia", (Nodo) $1.obj, (Nodo) $2.obj);
                                                    hasReturn = true;}
    | list_sentencias_funcion {$$=$1;}
    | sentencia_return ';' {$$=$1; hasReturn = true;}
    |  {yyerror("El cuerpo de la funcion no puede ser vacio");}
    ;


list_sentencias_funcion:
    list_sentencias_funcion sentencia {$$.obj = new NodoComun("Sentencia", (Nodo) $1.obj, (Nodo) $2.obj);}
    | sentencia {$$=$1;}
    ;


sentencia_return:
    RET '(' expresion ')' {if (ambito.length() < 5){  //si es menor es que es main
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           }
                           $$.obj = new NodoComun("Return", (Nodo)$3.obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
    ;

expresion:
    expresion '+' termino { Token tIzq = TablaSimbolos.getToken($1.sval);
                            Nodo nIzq = new NodoHoja($1.sval, tIzq);

                            Token tDer = TablaSimbolos.getToken($3.sval);
                            Nodo nDer = new NodoHoja($3.sval, tIzq);

                            $$.obj = controlarTipos(nIzq,$2.sval,nDer);
                          }

    | expresion '-' termino { Token tIzq = TablaSimbolos.getToken($1.sval);
                              Nodo nIzq = new NodoHoja($1.sval, tIzq);

                              Token tDer = TablaSimbolos.getToken($3.sval);
                              Nodo nDer = new NodoHoja($3.sval, tIzq);

                              $$.obj = controlarTipos(nIzq,$2.sval,nDer);
                             }
    | termino {$$ = $1;}
    | expresion '+' error {yyerror("Se esperaba un termino");}
    | expresion '-' error {yyerror("Se esperaba un termino");}
    ;

termino:
    termino '*' factor { Token tIzq = TablaSimbolos.getToken($1.sval);
                         Nodo nIzq = new NodoHoja($1.sval, tIzq);

                         Token tDer = TablaSimbolos.getToken($3.sval);
                         Nodo nDer = new NodoHoja($3.sval, tIzq);

                         $$.obj = controlarTipos(nIzq,$2.sval,nDer);
                        }
    | termino '/' factor { Token tIzq = TablaSimbolos.getToken($1.sval);
                           Nodo nIzq = new NodoHoja($1.sval, tIzq);

                           Token tDer = TablaSimbolos.getToken($3.sval);
                           Nodo nDer = new NodoHoja($3.sval, tIzq);

                           $$.obj = controlarTipos(nIzq,$2.sval,nDer);
                          }
    | factor {$$ = $1;}
    | termino '*' error {$$.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
    | termino '/' error {$$.obj = new NodoHoja("error sintactico"); yyerror("Se esperaba un factor");}
    ;

factor:
    ID {String ambitoVar = buscarAmbito(ambito,$1.sval);
        if (ambitoVar.equals("")){
            agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
            Nodo aux = new NodoHoja($1.sval);
            $$.obj = aux;
        }
        else {
            Token t = TablaSimbolos.getToken($1.sval + ":" + ambitoVar);
            if (!(t.getUso().equals("variable") || t.getUso().equals("parametro")))
                agregarErrorSemantico("'" + $1.sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                Nodo aux = new NodoHoja($1.sval+":"+ambitoVar, t);
                $$.obj = aux;
                TablaSimbolos.removeToken($1.sval);
            }
        }
        }
    | CONSTANTE {Token t = TablaSimbolos.getToken($1.sval);
                t.setValor($1.sval);
                t.setUso("constante");
                $$.obj = new NodoHoja($1.sval,t);
                }
    | invocacion_funcion {AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | ID '[' CONSTANTE ']' {    String ambitoVar = buscarAmbito(ambito,$1.sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
                                    $$.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken($1.sval + ":" + ambitoVar);
                                    String tipo = t.getTipo();
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja($1.sval + $2.sval + $3.sval + $4.sval);
                                        nodo.setTipo(tipoTriple);
                                        $$.obj = nodo;
                                    }
                                    else {
                                        agregarErrorSemantico("La variable '" + $1.sval + "' no es de un tipo TRIPLE definido");
                                        $$.obj = new NodoHoja("error");
                                    }
                                }
                             String index = TablaSimbolos.getToken($3.sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3"))))
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 $$.obj = new NodoHoja("error");
                            }
    | '-' ID {String ambitoVar = buscarAmbito(ambito,$2.sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + $2.sval + "' no fue declarada");
                         $$.obj = new NodoHoja("error");
                     }
                     else {
                         Token t = TablaSimbolos.getToken($2.sval + ":" + ambitoVar);
                         if (!t.getUso().equals("variable"))
                             agregarErrorSemantico("'" + $2.sval + "' no es una variable. Es un/a " + t.getUso());
                         else {
                             $$.obj = new NodoHoja($2.sval + ":" + ambitoVar,t);
                             TablaSimbolos.removeToken($2.sval);
                         }
                     }
                     }
    | '-' CONSTANTE {Token t = TablaSimbolos.getToken($2.sval);
                                        if (t != null && t.getTipo().equals(ENTERO)) {
                                            yyerror("Las constantes de tipo ulongint no pueden ser negativas");
                                            $$.obj = new NodoHoja("error");
                                        }
                                        else if (t != null && (t.getTipo().equals(FLOTANTE))) {
                                            String lexema = t.getLexema().toString();
                                            chequeoFlotantesPositivos(lexema);
                                            t.setUso("constante");
                                            t.setValor($1.sval + $2.sval);
                                            $$.obj = new NodoHoja($1.sval + $2.sval,t);
                                        }

                    }
    | '-' ID '[' CONSTANTE ']' {$$.obj = new NodoHoja("hola");}
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
    ID '(' expresion ')' {
        String ambitoVar = buscarAmbito(ambito,$1.sval);
        if (ambitoVar.equals(""))
            agregarErrorSemantico("La funcion '" + $1.sval + "' no fue declarada");
        else {
        if (funcionesDeclaradas.containsKey($1.sval + ":" + ambitoVar)){
            Nodo exp = (Nodo)$3.obj;
            Token copiaValor = new Token(exp.getToken());
            NodoComun funcion = funcionesDeclaradas.get($1.sval + ":" + ambitoVar);
            $$.obj = generarLlamadoFuncion(funcion,copiaValor);
        }
        else {
            agregarErrorSemantico("La funcion '" + $1.sval + "' no fue declarada");
        }
     }
        }
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
    encabezado_if '(' condicion ')' THEN cuerpo_if_unico fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF");inIF=false; Nodo cuerpo = new NodoComun("Cuerpo",(Nodo)$6.obj);
                                                                                                                                              $$.obj = new NodoComun("If", (Nodo)$3.obj, cuerpo);}
    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)$6.obj);
                                                                                                                                          $$.obj = new NodoComun("If", (Nodo)$3.obj, cuerpo);}


    | encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_unico fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false;  NodoComun nThen = new NodoComun("Then", (Nodo)$6.obj);
                                                                                                                                                                          NodoComun nElse = new NodoComun("Else", (Nodo)$8.obj);
                                                                                                                                                                          Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                          $$.obj = new NodoComun("If", (Nodo)$3.obj,cuerpo);
                                                                                                                                                                          if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                               hasReturn = true;
                                                                                                                                                                          }
                                                                                                                                                                          cantReturns = 0;
                                                                                                                                                                          }

    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)$6.obj);
                                                                                                                                                                    NodoComun nElse = new NodoComun("Else", (Nodo)$8.obj);
                                                                                                                                                                    Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                    $$.obj = new NodoComun("If", (Nodo)$3.obj,cuerpo);
                                                                                                                                                                    if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                    }
                                                                                                                                                                    cantReturns = 0;
                                                                                                                                                                    }

    | encabezado_if '(' condicion ')' THEN cuerpo_if_unico ELSE cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)$6.obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("Else", (Nodo)$8.obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                   $$.obj = new NodoComun("If", (Nodo)$3.obj,cuerpo);

                                                                                                                                                                   if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                   }
                                                                                                                                                                   cantReturns = 0;
                                                                                                                                                                   }

    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_unico fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)$6.obj);
                                                                                                                                                                   NodoComun nElse = new NodoComun("Else", (Nodo)$8.obj);
                                                                                                                                                                   Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                   $$.obj = new NodoComun("If", (Nodo)$3.obj,cuerpo);

                                                                                                                                                                   if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                   }
                                                                                                                                                                   cantReturns = 0;
                                                                                                                                                                   }
    | encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico fin_if {yyerror("Falta THEN en IF");}
    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque cuerpo_if_unico fin_if {yyerror("Falta ELSE en IF");}
    | encabezado_if '(' condicion ')' cuerpo_if_bloque ELSE cuerpo_if_unico {yyerror("Falta END_IF en IF");}

    ;

cuerpo_if_unico:
    sentencia_ejecutable ';' {$$ = $1;}
    | sentencia_return ';' {$$ = $1; cantReturns++;}
    ;

cuerpo_if_bloque:
    BEGIN list_sentencias_ejecutables END {$$ = $2;}
    | BEGIN list_sentencias_ejecutables sentencia_return END {$$ = $2; cantReturns++;}
    | BEGIN error {yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
    | list_sentencias_ejecutables END  {yyerror("Se encontró 'END' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
    | error {yyerror("Se esperaba BEGIN y END por sentencias multiples");}
    ;

list_sentencias_ejecutables:
    list_sentencias_ejecutables sentencia_ejecutable ';' {$$ = new NodoComun("Sentencia", (Nodo) $1.obj, (Nodo) $2.obj);}
    | sentencia_ejecutable ';' {$$ = $1;}
    ;


comparacion:
    MAYORIGUAL {$$.obj = new NodoHoja($1.sval);}
    | MENORIGUAL {$$.obj = new NodoHoja($1.sval);}
    | DISTINTO {$$.obj = new NodoHoja($1.sval);}
    | '=' {$$.obj = new NodoHoja($1.sval);}
    | '>' {$$.obj = new NodoHoja($1.sval);}
    | '<' {$$.obj = new NodoHoja($1.sval);}
    ;

condicion:
    expresion comparacion expresion {$$.obj = new NodoComun($2.sval, (Nodo)$1.obj, (Nodo)$3.obj);}
    | '(' {inList1 = true;} bloque_list_expresiones {inList1 = false;} ')' comparacion '(' {inList2 = true;} bloque_list_expresiones {inList2 = false;} ')'
    { $$.obj = new NodoComun($4.sval, (Nodo)$2.obj, (Nodo)$4.obj);
      AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
      if (expresiones1.size() == expresiones2.size()){
        for (int i = 0; i < expresiones1.size(); i++) {
            Nodo exp1 = expresiones1.get(i);
            Nodo exp2 = expresiones2.get(i);
            if (!(exp1.getTipo().equals(exp2.getTipo())))
                agregarErrorSemantico("Las expresiones en la posicion " + i + " no tienen el mismo tipo");
        }
      }
      else {
        agregarErrorSemantico("La cantidad de elementos a comparar en pattern matching no coincide");
      }
      expresiones1.clear();
      expresiones2.clear();
    }

    | error {yyerror("Falta comparador en la condicion");}
    ;

//tema 19
bloque_list_expresiones:
    list_expresiones ',' expresion {
    if (inList1)
            expresiones1.add((Nodo)$3.obj);
        if (inList2)
            expresiones2.add((Nodo)$3.obj);
    $$ = new NodoComun("Sentencia", (Nodo) $1.obj, (Nodo) $3.obj);
    }
    ;

list_expresiones:
    list_expresiones ',' expresion  {
    if (inList1)
        expresiones1.add((Nodo)$3.obj);
    if (inList2)
        expresiones2.add((Nodo)$3.obj);
    $$ = new NodoComun("Sentencia", (Nodo) $1.obj, (Nodo) $3.obj);
    }
    | expresion {
    if (inList1)
        expresiones1.add((Nodo)$1.obj);
    if (inList2)
        expresiones2.add((Nodo)$1.obj);
    $$=$1;
    }
    | error {yyerror("Falta expresion en pattern matching");}
    ;

salida_mensaje:
    OUTF '(' CADENA ')' {   $$.obj = new NodoComun("Outf", new NodoHoja($3.sval));
                            Token t = TablaSimbolos.getToken($3.sval); //Obtenemos el token, faltaba esto
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
    | OUTF '(' expresion ')' {   $$.obj = new NodoComun("Outf", new NodoHoja($3.sval));
                                 Token t = TablaSimbolos.getToken($3.sval); //Obtenemos el token, faltaba esto
                                 t.setUso("mensaje");
                                 t.setTipo("cadena");
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }
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
static boolean enFuncion = false;
static int cantReturns = 0;
static List<String> varDeclaradas = new ArrayList<>();
static String tipoActual;
static List<String> erroresSemanticos = new ArrayList<>();
static Map<String,String> tiposDeclarados = new HashMap<>(); //clave: lexema del tipo ; valor: tipo del tipo
public static Map<String,NodoComun> funcionesDeclaradas = new HashMap<>();
static List<Nodo> expresiones1 = new ArrayList<>();
static List<Nodo> expresiones2 = new ArrayList<>();
static boolean inList1 = false;
static boolean inList2 = false;

public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
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

private NodoComun controlarTipos(Nodo nodo1, String op, Nodo nodo3){
    NodoComun ret = new NodoComun(op, nodo1, nodo3);
    if (!(nodo1.getLexema().contains("error") || nodo1.getLexema().contains("error"))) {
    if (!(nodo1.getTipo().equals(nodo3.getTipo())))
        agregarErrorSemantico("Incompatibilidad de tipos en la "+op);
    else
        ret.setTipo(nodo1.getTipo());
    }

    return ret;
}

private Nodo generarLlamadoFuncion(NodoComun funcion, Token copia){
    if (funcion != null){
        Nodo param = funcion.getIzq();
        if (param.getTipo().equals(copia.getTipo())){
            param.setValor(copia.getValor());
        }
        else {
            agregarErrorSemantico("El tipo del parametro real no coincide con el del parametro formal");
        }
    }
    return funcion;
}

public NodoComun getRaiz(){
    return this.raiz;
}

public static List<Nodo> getFuncionesDeclaradas(){
    return new ArrayList<>(funcionesDeclaradas.values());
}
