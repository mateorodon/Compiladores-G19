%{
package compi.g19.AnalisisSintactico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import compi.g19.AnalisisLexico.*;
import compi.g19.GeneracionDeCodigo.*;
import static compi.g19.AnalisisLexico.AnalizadorLexico.errorLexico;
import static compi.g19.AnalisisLexico.AnalizadorLexico.errorSintactico;
%}
%token ID ASIGNACION MAYORIGUAL MENORIGUAL DISTINTO CONSTANTE CADENA IF THEN ELSE BEGIN END END_IF OUTF TYPEDEF FUN RET ULONGINT SINGLE FOR OR UP DOWN TRIPLE

%left ','

%%

%start programa;

programa: ID BEGIN list_sentencias END {AnalizadorLexico.agregarEstructura("Se reconocio el programa"); if (noHayErrores()){raiz = new NodoComun("PROGRAMA", (Nodo)$3.obj);}}
    | BEGIN list_sentencias END {yyerror("El programa debe tener un nombre");}
    | ID BEGIN list_sentencias {yyerror("Falta delimitador END del programa");}
    | ID list_sentencias END {yyerror("Falta delimitador BEGIN del programa");}
    | ID list_sentencias {yyerror("Faltan los delimitadores del programa");}
    ;

list_sentencias: list_sentencias sentencia {$$.obj = new NodoComun("Sentencia", (Nodo)$1.obj, (Nodo)$2.obj);}
    | sentencia {$$.obj=$1.obj;}
    ;

sentencia:
    sentencia_declarativa ';' {$$.obj = null;}
    | sentencia_ejecutable ';' {$$=$1;}
    | sentencia_ejecutable {yyerror("Las sentencias deben terminar con ;");}
    | sentencia_declarativa {yyerror("Las sentencias deben terminar con ;");}
    ;

sentencia_declarativa:
    tipo list_variables {AnalizadorLexico.agregarEstructura("Se reconocio declaracion de variable/s");
                         for (String var: varDeclaradas){
                            Token t = TablaSimbolos.getToken(var);
                            if (!TablaSimbolos.existeSimbolo(var + "@" + ambito)){
                                String tipo = t.getTipo();
                                if (tipo != null){
                                    if (tipo.toLowerCase().equals(tipoActual.toLowerCase()))
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya esta declarada");
                                    else
                                        AnalizadorLexico.agregarWarning("La variable '" + var + "' ya estaba declarada. Se cambio su tipo a " + tipoActual);
                                }
                                t.getLexema().setLength(0);
                                t.getLexema().append(var).append("@").append(ambito);
                                t.setAmbito(ambito);
                                if (tipoActual.equals(ENTERO) || tipoActual.equals(FLOTANTE)) {
                                    t.setUso("variable");
                                } else {
                                    t.setUso("arreglo");
                                }
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
    | invocacion_funcion {$$ = $1;AnalizadorLexico.agregarWarning("Se ha llamado a una función pero su valor no ha sido utilizado"); AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
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
    asignacion_for ';' condicion ';' up_down CONSTANTE {
                                                        NodoHoja constanteUpDown = new NodoHoja($6.sval,TablaSimbolos.getToken($6.sval));
                                                        Nodo incremento = new NodoComun("Incremento", (Nodo)$5.obj, constanteUpDown); //Idem
                                                        Nodo condicion = (Nodo)$3.obj;
                                                        Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento",(Nodo)$1.obj , incremento);
                                                        $$.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condicion);
                                                        AnalizadorLexico.agregarEstructura("Se reconoció un FOR de 3");
                                                        }
    | asignacion_for ';' condicion ';' CONSTANTE {yyerror("Falta UP/DOWN en el FOR");}
    | asignacion_for condicion ';' up_down CONSTANTE {yyerror("Falta ';' en el FOR");}
    | asignacion_for ';' condicion up_down CONSTANTE {yyerror("Falta ';' en el FOR");}
    | asignacion_for ';' condicion ';' up_down {yyerror("Falta constante después de UP/DOWN en el FOR");}
    ;

encabezado_for2:
    asignacion_for ';' condicion ';' up_down CONSTANTE ';' '(' condicion ')' {

                                                                                       NodoHoja constanteUpDown = new NodoHoja($6.sval,TablaSimbolos.getToken($6.sval));
                                                                                       Nodo asignacion = (Nodo)$1.obj;
                                                                                       Nodo incremento = new NodoComun("Incremento", (Nodo)$5.obj, constanteUpDown); //Idem
                                                                                       Nodo condicion = (Nodo)$3.obj;
                                                                                       Nodo iteradorCondicion = (Nodo)$9.obj;

                                                                                       Nodo asgnacionIncremento = new NodoComun("Asignacion e Incremento", asignacion, incremento);
                                                                                       Nodo condiciones = new NodoComun("Condiciones", condicion, iteradorCondicion);

                                                                                       $$.obj = new NodoComun ("Encabezado For", asgnacionIncremento, condiciones);

                                                                                       AnalizadorLexico.agregarEstructura("Se reconoció un FOR con condición");
                                                                                       TablaSimbolos.removeToken($1.sval);
                                                                                       }

    | asignacion_for ';' condicion ';' CONSTANTE ';' '(' condicion ')' {yyerror("Falta UP/DOWN en el FOR");}
    | asignacion_for condicion ';' up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ';' en el FOR");}
    | asignacion_for ';' condicion up_down CONSTANTE ';' '(' condicion ')' {yyerror("Falta ';' en el FOR");}
    | asignacion_for ';' condicion ';' up_down '(' condicion ')' {yyerror("Falta constante después de UP/DOWN en el FOR");}
    ;

asignacion_for: ID ASIGNACION CONSTANTE
                                        {String ambitoVar = buscarAmbito(ambito,$1.sval);
                                        NodoHoja idAsignacion = null;
                                        if (!ambitoVar.equals("")) {
                                            Token t = TablaSimbolos.getToken($1.sval + "@" + ambitoVar);
                                            idAsignacion = new NodoHoja($1.sval + "@" + ambitoVar, t);
                                        }
                                        else {
                                            Token t = new Token();
                                            t.setTipo(ENTERO);
                                            t.getLexema().setLength(0);
                                            t.getLexema().append($1.sval).append("@").append(ambito);
                                            t.setAmbito(ambito);
                                            t.setUso("variable");
                                            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                            idAsignacion = new NodoHoja($1.sval + "@" + ambito, t);
                                        }
                                        NodoHoja constante = new NodoHoja($3.sval, TablaSimbolos.getToken($3.sval));
                                        $$.obj = new NodoComun($2.sval, idAsignacion, constante);
                                        TablaSimbolos.removeToken($1.sval);
                                        }
                                        ;

up_down:
    UP {$$.obj = new NodoHoja("Up");}
    |DOWN {$$.obj = new NodoHoja("Down");}
    ;

asignacion:
    ID ASIGNACION expresion { String ambitoVar = buscarAmbito(ambito,$1.sval);
                              Nodo asignacion = new NodoHoja("error");
                              Token t = null;
                              if (ambitoVar.equals("")){
                                  t = TablaSimbolos.getToken($1.sval);
                                  if (t.getTipo() == null){
                                        agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
                                        $$.obj = new NodoHoja("error");
                                  }
                                  else {
                                        t.getLexema().setLength(0);
                                        t.getLexema().append($1.sval).append("@").append(ambito);
                                        t.setAmbito(ambito);
                                        t.setUso("variable");
                                        TablaSimbolos.removeToken($1.sval);
                                        TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                        NodoHoja id = new NodoHoja(t.getLexema().toString(),t);
                                        if (((Nodo)$3.obj).getTipo() != null){
                                            if (!(id.getTipo().equals(((Nodo)$3.obj).getTipo())))
                                                agregarErrorSemantico("Incompatibilidad de tipos");
                                        }
                                        $$.obj = new NodoComun($2.sval ,id, (Nodo)$3.obj);
                                  }
                              }
                              else {
                                  t = TablaSimbolos.getToken($1.sval + "@" + ambitoVar);

                                  if (!(t.getUso().equals("variable") || t.getUso().equals("parametro") || t.getUso().equals("arreglo"))) {
                                      agregarErrorSemantico("La expresion en la parte izquierda de la asignación debe ser una variable. Se encontró un elemento no asignable (" + t.getUso() + ")");
                                      $$.obj = new NodoHoja("error");
                                  } else {
                                      if (t.getUso().equals("arreglo")) {
                                          Token t2 = TablaSimbolos.getToken($3.sval + "@" + ambitoVar);
                                          if (t2 != null) {
                                              if (!(t2.getTipo().equals(t.getTipo()))) {
                                                  agregarErrorSemantico("Incompatibilidad de tipos");
                                              } else {
                                                  NodoHoja id = new NodoHoja(t.getLexema().toString(), t);
                                                  $$.obj = new NodoComun($2.sval, id, (Nodo) $3.obj);
                                              }
                                          } else {
                                              agregarErrorSemantico("La expresión en la parte derecha de la asignación no está definida.");
                                              $$.obj = new NodoHoja("error");
                                          }
                                      } else {
                                          NodoHoja id = new NodoHoja(t.getLexema().toString(), t);
                                          if (((Nodo)$3.obj).getTipo() != null){
                                          if (!(id.getTipo().equals(((Nodo)$3.obj).getTipo())))
                                            agregarErrorSemantico("Incompatibilidad de tipos");
                                          }
                                          $$.obj = new NodoComun($2.sval, id, (Nodo) $3.obj);
                                      }
                                  }
                                  TablaSimbolos.removeToken($1.sval);
                              }}
    | ID '[' CONSTANTE ']' ASIGNACION expresion {
                                                String ambitoVar = buscarAmbito(ambito,$1.sval);
                                                if (ambitoVar.equals("")){
                                                    agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
                                                    $$.obj = new NodoHoja("error");
                                                }
                                                else {
                                                    Token t = TablaSimbolos.getToken($1.sval + "@" + ambitoVar);
                                                    String tipo = t.getTipo();
                                                    if (tiposDeclarados.containsKey(tipo)){
                                                        String tipoTriple = tiposDeclarados.get(tipo);
                                                        NodoHoja nodo = new NodoHoja($1.sval + $2.sval + $3.sval + $4.sval, t);
                                                        nodo.setUso("arreglo");
                                                        if (((Nodo)$6.obj).getTipo() != null){
                                                            if (!(tipoTriple.equals(((Nodo)$6.obj).getTipo())))
                                                                agregarErrorSemantico("Incompatibilidad de tipos");
                                                        }
                                                        $$.obj = new NodoComun($5.sval,nodo,(Nodo)$6.obj);
                                                    }
                                                    else {
                                                        agregarErrorSemantico("La variable '" + $1.sval + "' no es de un tipo TRIPLE definido");
                                                        $$.obj = new NodoHoja("error");
                                                    }
                                                }
                                                String index = TablaSimbolos.getToken($3.sval).getLexema().toString();
                                                if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                                    agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                                    $$.obj = new NodoHoja("error");
                                                }
                                                TablaSimbolos.removeToken($1.sval);

                                                }
    | ID ASIGNACION error {if (yychar == ID || yychar == CONSTANTE) {
                            yyerror("Se esperaba un operador");
                           } else {
                            if (!(yychar == 91 || yychar == 40))
                                yyerror("Falta parte derecha de la asignación");
                           }
                           while (yychar != 59)
                                yychar = yylex();
                           }
    ;

tipo:
    tipo_base
    | ID { String ambitoVar = buscarAmbito(ambito,$1.sval);
           if (ambitoVar.equals(""))
                agregarErrorSemantico("El tipo '" + $1.sval + "' no fue declarado");
           else {
            Token t = TablaSimbolos.getToken($1.sval + "@" + ambitoVar);
            if (t.getUso() == null || !t.getUso().equals("tipo"))
                yyerror("El identificador '" + $1.sval + "' no es un tipo definido");
            else {
                tipoActual = $1.sval;
            }
            }
            TablaSimbolos.removeToken($1.sval);
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
                funcionActual = $3.sval + "@" + ambito;
                String idFuncion = $3.sval;
                 Token t = TablaSimbolos.getToken(idFuncion);
                 if (t.getTipo() == null){
                     if (!TablaSimbolos.existeSimbolo(idFuncion + "@" + ambito)){
                        t.getLexema().setLength(0);
                        t.getLexema().append(idFuncion).append("@").append(ambito); //aca agrega una vez el ambito
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
                     NodoComun encabezado = new NodoComun(idFuncion + "@" + ambito);
                     encabezado.setToken(t);
                     $$.obj = encabezado;
                 }
                 else {
                    agregarErrorSemantico("La variable '" + idFuncion + "' ya fue declarada");
                    $$.obj = new NodoComun("error");
                 }

                 addAmbito(idFuncion);
                 }
    |tipo FUN {yyerror("La funcione debe tener nombre"); hasReturn = false;}
    ;

declaracion_funcion:
    encabezado_funcion '(' parametro ')' BEGIN  {           Nodo parametro = (Nodo)$3.obj;
                                                             NodoComun funcion = (NodoComun)$1.obj; //Encabezado con nombre funcion, este tiene el tipo

                                                             funcion.setUso("funcion");
                                                             funcion.setIzq(parametro);

                                                             funcionesDeclaradas.put(funcion.getNombre(),funcion);
                                                             funcionYTipoParametro.put(funcion.getNombre(), funcion.getIzq().getTipo());
                                                         } cuerpo_funcion { if (!hasReturn) {
                                                                                yyerror("Falta sentencia RET en la función");
                                                                                }
                                                                            NodoComun funcion = funcionesDeclaradas.get(((Nodo)$1.obj).getNombre());
                                                                            NodoComun cuerpo = (NodoComun)$7.obj;
                                                                            funcion.setDer(cuerpo);
                                                                            removeAmbito();
                                                                            enFuncion = false;} END
    | encabezado_funcion '(' bloque_list_parametro ')' BEGIN cuerpo_funcion END {yyerror("La funciones no puede tener más de un parámetro");removeAmbito();}
    | encabezado_funcion '(' ')' BEGIN cuerpo_funcion END {yyerror("La función debe tener parámetro");removeAmbito();}
    ;

parametro:
    tipo ID {
               Token t = TablaSimbolos.getToken($2.sval);
               if (t != null){
                   t.getLexema().setLength(0);
                   t.getLexema().append($2.sval).append("@").append(ambito);
                   t.setAmbito(ambito);
                   t.setUso("parametro");
                   t.setTipo(tipoActual);
                   TablaSimbolos.removeToken($2.sval);
                   TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
               }
              Nodo param = new NodoHoja(t.getLexema().toString(), t);
              param.setTipo(tipoActual);
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
    |  {yyerror("El cuerpo de la funcion no puede ser vacio"); $$.obj = new NodoComun("Cuerpo vacio");}
    ;


list_sentencias_funcion:
    list_sentencias_funcion sentencia {$$.obj = new NodoComun("Sentencia", (Nodo) $1.obj, (Nodo) $2.obj);}
    | sentencia {$$=$1;}
    ;


sentencia_return:
    RET '(' expresion ')' {if (ambito.length() < 5){  //si es menor es que es main
                                yyerror("No puede haber una sentencia de retorno fuera de una funcion");
                           } else {
                                NodoComun funAct = funcionesDeclaradas.get(funcionActual);
                                String tipoFun = funAct.getTipo();
                                if (!(((Nodo)$3.obj).getTipo().equals(tipoFun))){
                                    agregarErrorSemantico("El tipo del retorno no coincide con el de la funcion");
                                } else {
                                    $$.obj = new NodoHoja("error");
                                }
                           }
                           $$.obj = new NodoComun("Return", (Nodo)$3.obj);
                           AnalizadorLexico.agregarEstructura("Se reconocio sentencia de retorno");}
    ;

expresion:
    expresion '+' termino {
                         String expresion = ((Nodo)$1.obj).getNombre();
                         String termino = ((Nodo)$3.obj).getNombre();
                         if (!(expresion.contains("error") || termino.contains("error"))){
                             Nodo nIzq = (Nodo)$1.obj;
                             Nodo nDer = (Nodo)$3.obj;
                             $$.obj = controlarTipos(nIzq,$2.sval,nDer);
                         }
                         else {
                            $$.obj = new NodoHoja("error");
                         }
                        }
    | expresion '-' termino {
                         String expresion = ((Nodo)$1.obj).getNombre();
                         String termino = ((Nodo)$3.obj).getNombre();
                         if (!(expresion.contains("error") || termino.contains("error"))){
                             Nodo nIzq = (Nodo)$1.obj;
                             Nodo nDer = (Nodo)$3.obj;
                             $$.obj = controlarTipos(nIzq,$2.sval,nDer);
                         }
                         else {
                            $$.obj = new NodoHoja("error");
                         }
                        }
    | termino {if (yychar == ID || yychar == CONSTANTE) {
                yyerror("Se esperaba un operador");
                yychar = yylex();
              }
              $$ = $1;}
    | expresion '+' error {yyerror("Se esperaba un termino");}
    | expresion '-' error {yyerror("Se esperaba un termino");}
    ;

termino:
    termino '*' factor {
                         String termino = ((Nodo)$1.obj).getNombre();
                         String factor = ((Nodo)$3.obj).getNombre();
                         if (!(termino.contains("error") || factor.contains("error"))){
                             Nodo nIzq = (Nodo)$1.obj;
                             Nodo nDer = (Nodo)$3.obj;
                             $$.obj = controlarTipos(nIzq,$2.sval,nDer);
                         }
                         else {
                            $$.obj = new NodoHoja("error");
                         }
                        }
    | termino '/' factor {
                         String termino = ((Nodo)$1.obj).getNombre();
                         String factor = ((Nodo)$3.obj).getNombre();
                         if (!(termino.contains("error") || factor.contains("error"))){
                             Nodo nIzq = (Nodo)$1.obj;
                             Nodo nDer = (Nodo)$3.obj;
                             $$.obj = controlarTipos(nIzq,$2.sval,nDer);
                         }
                         else {
                            $$.obj = new NodoHoja("error");
                         }
                        }
    | factor {if (yychar == ID || yychar == CONSTANTE) {
                                   yyerror("Se esperaba un operador");
                                   yychar = yylex();
                               }
                               $$ = $1;}
    | termino '*' error {$$.obj = new NodoHoja("error"); yyerror("Se esperaba un factor");}
    | termino '/' error {$$.obj = new NodoHoja("error"); yyerror("Se esperaba un factor");}
    ;

factor:
    ID {String ambitoVar = buscarAmbito(ambito,$1.sval);
        String idToString = $1.sval;
        if (ambitoVar.equals("") && (idToString.startsWith("x") || idToString.startsWith("z") || idToString.startsWith("s"))) {
            Token t = TablaSimbolos.getToken(idToString);
            t.getLexema().setLength(0);
            t.getLexema().append(idToString).append("@").append(ambito);
            t.setAmbito(ambito);
            t.setUso("variable");
            if (idToString.startsWith("s")) {
                t.setTipo(FLOTANTE);}
            else {
                t.setTipo(ENTERO);}
            TablaSimbolos.removeToken(idToString);
            TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
            Nodo aux = new NodoHoja($1.sval+"@"+ambito, t);
            $$.obj = aux;
        }
        else if (ambitoVar.equals("")) {
                    agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
                    Nodo aux = new NodoHoja("error");
                    $$.obj = aux;
        }
        else {
            Token t = TablaSimbolos.getToken($1.sval + "@" + ambitoVar);
            if (!(t.getUso().equals("variable") || t.getUso().equals("parametro") || t.getUso().equals("arreglo")))
                agregarErrorSemantico("'" + $1.sval + "' no es una variable. Es un/a " + t.getUso());
            else {
                Nodo aux = new NodoHoja($1.sval+"@"+ambitoVar, t);
                $$.obj = aux;
            }
        }
        TablaSimbolos.removeToken($1.sval);
        }
    | CONSTANTE {Token t = TablaSimbolos.getToken($1.sval);
                t.setValor($1.sval);
                t.setUso("constante");
                $$.obj = new NodoHoja($1.sval,t);
                }
    | invocacion_funcion {$$ = $1; AnalizadorLexico.agregarEstructura("Se reconocio una invocacion a funcion");}
    | ID '[' CONSTANTE ']' {    String ambitoVar = buscarAmbito(ambito,$1.sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + $1.sval + "' no fue declarada");
                                    $$.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken($1.sval + "@" + ambitoVar);
                                    String tipo = t.getTipo();
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja($1.sval + $2.sval + $3.sval + $4.sval, t);
                                        $$.obj = nodo;
                                    }
                                    else {
                                        agregarErrorSemantico("La variable '" + $1.sval + "' no es de un tipo TRIPLE definido");
                                        $$.obj = new NodoHoja("error");
                                    }
                                }
                             String index = TablaSimbolos.getToken($3.sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 $$.obj = new NodoHoja("error");
                             }
                             TablaSimbolos.removeToken($1.sval);
                            }
    | '-' ID {String ambitoVar = buscarAmbito(ambito,$2.sval);
                     if (ambitoVar.equals("")){
                         agregarErrorSemantico("La variable '" + $2.sval + "' no fue declarada");
                         $$.obj = new NodoHoja("error");
                     }
                     else {
                         Token t = TablaSimbolos.getToken($2.sval + "@" + ambitoVar);
                         if (!(t.getUso().equals("variable") || t.getUso().equals("parametro") || t.getUso().equals("arreglo"))){
                             agregarErrorSemantico("'" + $2.sval + "' no es una variable. Es un/a " + t.getUso());
                             $$.obj = new NodoHoja("error");
                         }
                         else {
                             $$.obj = new NodoHoja($1.sval + $2.sval + "@" + ambitoVar,t);
                         }
                     }
                     TablaSimbolos.removeToken($2.sval);
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
    | '-' ID '[' CONSTANTE ']' {String ambitoVar = buscarAmbito(ambito,$2.sval);
                                if (ambitoVar.equals("")){
                                    agregarErrorSemantico("La variable '" + $2.sval + "' no fue declarada");
                                    $$.obj = new NodoHoja("error");
                                }
                                else {
                                    Token t = TablaSimbolos.getToken($2.sval + "@" + ambitoVar);
                                    String tipo = $1.sval;
                                    if (tiposDeclarados.containsKey(tipo)){
                                        String tipoTriple = tiposDeclarados.get(tipo);
                                        NodoHoja nodo = new NodoHoja($1.sval + $2.sval + $3.sval + $4.sval + $5.sval, t);
                                        $$.obj = nodo;
                                    }
                                    else {
                                        agregarErrorSemantico("La variable '" + $2.sval + "' no es de un tipo TRIPLE definido");
                                        $$.obj = new NodoHoja("error");
                                    }
                                }
                             String index = TablaSimbolos.getToken($4.sval).getLexema().toString();
                             if (!(index != null && (index.equals("1") || index.equals("2") || index.equals("3")))){
                                 agregarErrorSemantico("El indice esta fuera de rango. Debe estar entre 1 y 3");
                                 $$.obj = new NodoHoja("error");
                             }
                             TablaSimbolos.removeToken($2.sval);
                            }
    ;

declaracion_tipo:
    TYPEDEF TRIPLE '<' tipo_base '>' ID {String idTipo = $6.sval;
                                         Token t = TablaSimbolos.getToken(idTipo);
                                         if (t.getTipo() == null){
                                             if (!TablaSimbolos.existeSimbolo(idTipo + "@" + ambito)){
                                                t.getLexema().setLength(0);
                                                t.getLexema().append(idTipo).append("@").append(ambito);
                                                t.setAmbito(ambito);
                                                t.setUso("tipo");
                                                t.setTipo($4.sval);
                                                TablaSimbolos.removeToken(idTipo);
                                                TablaSimbolos.addSimbolo(t.getLexema().toString(),t);
                                                tiposDeclarados.put($6.sval, $4.sval.toLowerCase());
                                             }
                                             else {
                                                TablaSimbolos.removeToken(idTipo);
                                                variableYaDeclarada(idTipo);
                                             }
                                         }
                                         else {
                                            agregarErrorSemantico("La variable '" + idTipo + "' ya fue declarada");
                                            $$.obj = new NodoComun("error");
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
        AnalizadorLexico.agregarEstructura("Se reconocio invocacion a funcion");
        String ambitoVar = buscarAmbito(ambito,$1.sval);
        if (ambitoVar.equals("")){
                    agregarErrorSemantico("La funcion '" + $1.sval + "' no fue declarada");
                    $$.obj = new NodoHoja("error");
                } else if (enFuncion && funcionActual.equals($1.sval)){
                        NodoComun nodoFunActual = funcionesDeclaradas.get($1.sval + "@" + ambito);
                        Nodo exp = (Nodo)$1.obj;
                        generarLlamadoFuncion(nodoFunActual,exp,null);
                }
        else {
            NodoComun funcion = funcionesDeclaradas.get($1.sval + "@" + ambitoVar);
            String tipoParametroFormal = funcion.getIzq().getTipo();
            if (((Nodo)$3.obj).getTipo().equals(tipoParametroFormal)){
                if (funcionesDeclaradas.containsKey($1.sval + "@" + ambitoVar)){
                        Nodo exp = (Nodo)$3.obj;
                        $$.obj = generarLlamadoFuncion(funcion,exp,null);
                    }
                    else {
                        agregarErrorSemantico("La funcion '" + $1.sval + "' no fue declarada");
                        $$.obj = new NodoHoja("error");
                    }
            } else {
                agregarErrorSemantico("El tipo del parametro real no coincide con el del real");
            }
        }
        TablaSimbolos.removeToken($1.sval);
    }
    | FUN '(' expresion ')' { yyerror("El identificador de una funcion no puede ser una palabra reservada");
    $$.obj = new NodoHoja("error");}
    | ID '(' bloque_list_expresiones ')' {yyerror("La funcion no puede tener mas de un parametro");}
    | ID '(' ')' {yyerror("La funcion debe tener un parametro");}
    | ID '(' tipo_base '(' expresion ')' ')' {
            AnalizadorLexico.agregarEstructura("Se reconocio conversion");
            String ambitoVar = buscarAmbito(ambito,$1.sval);
            if (ambitoVar.equals("")){
                agregarErrorSemantico("La funcion '" + $1.sval + "' no fue declarada");
                $$.obj = new NodoHoja("error");
            }
            else {
                if (funcionesDeclaradas.containsKey($1.sval + "@" + ambitoVar)){
                        Nodo exp = (Nodo)$5.obj;
                        //exp.setTipo($3.sval);
                        NodoComun funcion = funcionesDeclaradas.get($1.sval + "@" + ambitoVar);
                        $$.obj = generarLlamadoFuncion(funcion,exp, $3.sval);
                }
                else {
                        agregarErrorSemantico("La funcion '" + $1.sval + "' no fue declarada");
                        $$.obj = new NodoHoja("error");
                }
            }
            TablaSimbolos.removeToken($1.sval);
        }
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
     encabezado_if '(' condicion ')' THEN cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF"); inIF=false; Nodo cuerpo = new NodoComun("Cuerpo", (Nodo)$6.obj);
                                                                                                                                          $$.obj = new NodoComun("If", (Nodo)$3.obj, cuerpo);}



    | encabezado_if '(' condicion ')' THEN cuerpo_if_bloque ELSE cuerpo_if_bloque fin_if {AnalizadorLexico.agregarEstructura("Se reconocio un IF/ELSE");inIF=false; NodoComun nThen = new NodoComun("Then", (Nodo)$6.obj);
                                                                                                                                                                    NodoComun nElse = new NodoComun("Else", (Nodo)$8.obj);
                                                                                                                                                                    Nodo cuerpo  = new NodoComun("Cuerpo", nThen, nElse);
                                                                                                                                                                    $$.obj = new NodoComun("If", (Nodo)$3.obj,cuerpo);
                                                                                                                                                                    if ((cantReturns == 2) && (enFuncion)){
                                                                                                                                                                        hasReturn = true;
                                                                                                                                                                    }
                                                                                                                                                                    cantReturns = 0;
                                                                                                                                                                    }



    ;

end_cuerpo_if:
    END
   |END ';'
    ;

cuerpo_if_bloque:
    sentencia_ejecutable ';' {$$ = $1;}
    | sentencia_return ';' {$$ = $1; cantReturns++;}
    | sentencia_ejecutable  {yyerror("Falta ; en la sentencia");}
    | sentencia_return  {yyerror("Falta ; en la sentencia");}
    | BEGIN sentencia_return ';' end_cuerpo_if {$$ = $2;cantReturns++;}
    | BEGIN list_sentencias_ejecutables end_cuerpo_if {$$ = $2;}
    | BEGIN list_sentencias_ejecutables sentencia_return end_cuerpo_if {yyerror("Falta ; en la sentencia");}
    | BEGIN list_sentencias_ejecutables sentencia_return ';' end_cuerpo_if {$$ = $2; cantReturns++;}
    | list_sentencias_ejecutables END  {yyerror("Se encontró 'end_cuerpo_if' sin un bloque BEGIN correspondiente en el cuerpo IF/ELSE");}
    //| BEGIN error {yyerror("Se esperaba 'END' después del bloque BEGIN en el cuerpo IF/ELSE");}
    //| error {yyerror("Se esperaba BEGIN y END por sentencias multiples");}
    ;

list_sentencias_ejecutables:
    list_sentencias_ejecutables sentencia_ejecutable ';' {$$.obj = new NodoComun("Sentencia", (Nodo) $1.obj, (Nodo) $2.obj);}
    | sentencia_ejecutable ';' {$$ = $1;}
    | sentencia_ejecutable  {yyerror("Falta ; en la sentencia");}
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
    expresion comparacion expresion {   Nodo exp1 = (Nodo)$1.obj;
                                        Nodo exp2 = (Nodo)$3.obj;
                                        if (!(exp1.getNombre().contains("error") || exp2.getNombre().contains("error"))) {
                                            if (!((Nodo)$1.obj).getTipo().equals(((Nodo)$3.obj).getTipo())){
                                                agregarErrorSemantico("Los tipos son incompatibles en la condicion");
                                                $$.obj = new NodoHoja("error");
                                            }
                                            else
                                                $$.obj = new NodoComun($2.sval, (Nodo)$1.obj, (Nodo)$3.obj);
                                        }
                                        else {
                                            $$.obj = new NodoHoja("error");
                                        }
                                    }
    | '(' {inList1 = true;} bloque_list_expresiones {inList1 = false;} ')' comparacion '(' {inList2 = true;} bloque_list_expresiones {inList2 = false;} ')'
    { NodoComun salida = new NodoComun($6.sval);
      AnalizadorLexico.agregarEstructura("Se reconocio pattern matching");
      if (expresiones1.size() == expresiones2.size()){
            Nodo aux;
            for (int i = 0; i < expresiones1.size(); i++) {
                Nodo exp1 = expresiones1.get(i);
                Nodo exp2 = expresiones2.get(i);
                if (exp1.getNombre().contains("error") || exp2.getNombre().contains("error")){
                    salida = new NodoComun("error");
                    break;
                }
                if (!(exp1.getTipo().equals(exp2.getTipo()))){
                    agregarErrorSemantico("Las expresiones en la posicion " + i + " no tienen el mismo tipo");
                    aux = new NodoHoja("error");
                    }
                else {
                    aux = new NodoComun($6.sval, exp1, exp2);
                    aux.setUso("pattern_matching");
                }
                if (salida.getIzq() == null)
                    salida.setIzq(aux);
                else {
                    if (salida.getDer() == null)
                        salida.setDer(aux);
                    else {
                        salida = new NodoComun($6.sval,salida,aux);
                    }
                }
            }
      }
      else {
        agregarErrorSemantico("La cantidad de elementos a comparar en pattern matching no coincide");
      }
      expresiones1.clear();
      expresiones2.clear();
      $$.obj = salida;
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
    $$.obj = new NodoComun("Sentencia", (Nodo) $1.obj, (Nodo) $3.obj);
    }
    ;

list_expresiones:
    list_expresiones ',' expresion  {
    if (inList1)
        expresiones1.add((Nodo)$3.obj);
    if (inList2)
        expresiones2.add((Nodo)$3.obj);
    $$.obj = new NodoComun("Sentencia", (Nodo) $1.obj, (Nodo) $3.obj);
    }
    | expresion {
    if (inList1)
        expresiones1.add((Nodo)$1.obj);
    if (inList2)
        expresiones2.add((Nodo)$1.obj);
    $$ = $1;
    }
    | error {yyerror("Falta expresion en pattern matching");}
    ;

salida_mensaje:
    OUTF '(' CADENA ')' {   Token t = TablaSimbolos.getToken($3.sval);
                            t.setUso("mensaje");
                            t.setTipo("cadena");
                            $$.obj = new NodoComun("Outf", new NodoHoja($3.sval, t));
                            AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                        }
    | OUTF '(' expresion ')' {   Nodo exp = (Nodo)$3.obj;
                                 if (!exp.getNombre().contains("error")){
                                     Token t = new Token(exp.getToken());
                                     //t.setUso("mensaje");
                                     t.setTipo(exp.getTipo());
                                     $$.obj = new NodoComun("Outf", new NodoHoja(exp.getNombre(),t));
                                 }
                                 else {
                                    $$.obj = new NodoComun("error");
                                 }
                                 AnalizadorLexico.agregarEstructura("Se reconocio salida de mensaje por pantalla");
                              }

    | OUTF '(' error ')' {yyerror("Los print unicamente pueden contener expresiones o cadenas");}
    | OUTF '('')' {yyerror("Falta de parametro en funcion OUTF");};

%%
private static final String ENTERO = "ulongint";
private static final String FLOTANTE = "single";
private static final float NEGATIVE_MIN = 1.17549435e-38f;
private static final float NEGATIVE_MAX = 3.40282347e+38f;

static NodoComun raiz;
static String ambito = "main";
static boolean inIF = false;
static boolean hasReturn = false;
public static boolean enFuncion = false;
public static String funcionActual;
static int cantReturns = 0;
static List<String> varDeclaradas = new ArrayList<>();
static String tipoActual;
static List<String> erroresSemanticos = new ArrayList<>();
public static Map<String,String> tiposDeclarados = new HashMap<>();
public static Map<String,NodoComun> funcionesDeclaradas = new HashMap<>();
static List<Nodo> expresiones1 = new ArrayList<>();
static List<Nodo> expresiones2 = new ArrayList<>();
static HashMap<String,String> funcionYTipoParametro = new HashMap<>();
static boolean inList1 = false;
static boolean inList2 = false;
static boolean funcionAutoinvocada = false;

public int yylex() throws IOException {
    Token t = AnalizadorLexico.obtenerToken();
    if (t!= null){
      this.yylval = new ParserVal(t.getLexema().toString());
      return (int) t.getId();
    }
    return 0;
}

public static boolean getFuncionAutoinvocada(){
    return funcionAutoinvocada;
}

public static void yyerror(String error){
    if (!error.contains("syntax error"))
        AnalizadorLexico.agregarErrorSintactico(error);
}

public static void addAmbito(String ambitoActual){
    ambito = ambito.concat("@" + ambitoActual);
}

public void removeAmbito(){
        int index = ambito.lastIndexOf('@');

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

public static boolean noHayErrores(){
    return erroresSemanticos.isEmpty() && errorSintactico.isEmpty() && errorLexico.isEmpty();
}

public String buscarAmbito(String ambitoActual, String lexema) {
    String ambito = ambitoActual;

    while (!TablaSimbolos.existeSimbolo(lexema + "@" + ambito)) {
        if (ambito.equals("main")) {
            return "";
        }
        int index = ambito.lastIndexOf('@');
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
    Token t1 = TablaSimbolos.getToken(var + "@" + ambito);
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
    if (!(nodo1.getNombre().contains("error") || nodo3.getNombre().contains("error"))) {
    if (!(nodo1.getTipo().equals(nodo3.getTipo()))){
        agregarErrorSemantico("Incompatibilidad de tipos en la " + op);
        ret = new NodoComun("error");
    }
    else
        ret.setTipo(nodo1.getTipo());
    }

    return ret;
}

private Nodo generarLlamadoFuncion(NodoComun funcion, Nodo copia, String tipoCasteo) {
    NodoComun salida = null;
    if (funcion != null) {
        NodoHoja param = (NodoHoja)funcion.getIzq(); // Parámetro formal de la función
        String tipoFormal = param.getTipo(); // Tipo esperado por la función
        String tipoReal = copia.getTipo();   // Tipo de la expresión original

        if (tipoCasteo == null) {
            // Sin casteo: los tipos deben coincidir
            if (tipoFormal.equals(tipoReal)) {
                salida = new NodoComun(funcion, copia, null);
                salida.setUso("llamado");
            } else {
                agregarErrorSemantico("El tipo del parámetro real no coincide con el del parámetro formal");
                return new NodoHoja("error");
            }
        } else {
            // Con casteo: validar que sea permitido
            if (tipoCasteo.equals(tipoReal)) {
                // Intento de forzar un casteo al mismo tipo
                AnalizadorLexico.agregarWarning("El tipo del parámetro real ya es del tipo solicitado en el casteo");
                return new NodoHoja("error");
            } else if (tipoFormal.equals(tipoCasteo) && esCasteoValido(tipoReal, tipoCasteo)) {
                // Casteo válido
                //param.setNombre(copia.getNombre());
                NodoHoja newCopia = new NodoHoja(copia.getNombre(),param.getToken());
                NodoHoja nodoTipoReal = new NodoHoja(tipoReal, null);
                salida = new NodoComun(funcion, newCopia, nodoTipoReal);
                salida.setUso("llamadoConCasteo");
            } else {
                // Casteo inválido
                agregarErrorSemantico("El casteo de " + tipoReal + " a " + tipoCasteo + " no es válido");
                return new NodoHoja("error");
            }
        }
    }
    return salida;
}

// Método auxiliar para validar si un casteo es válido
private boolean esCasteoValido(String tipoOrigen, String tipoDestino) {
    // Regla: permitir solo ULONGINT ↔ SINGLE
    return (tipoOrigen.equals("ulongint") && tipoDestino.equals("single")) ||
           (tipoOrigen.equals("single") && tipoDestino.equals("ulongint"));
}

public NodoComun getRaiz(){
    return this.raiz;
}

public static List<Nodo> getFuncionesDeclaradas(){
    return new ArrayList<>(funcionesDeclaradas.values());
}

public static boolean esOperacion(String nombre){
    return nombre.equals("*") || nombre.equals("/") || nombre.equals("+") || nombre.equals("-");
}
