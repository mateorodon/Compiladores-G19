package compi.g19.GeneracionDeCodigo;

import compi.g19.AnalisisLexico.TablaSimbolos;
import compi.g19.AnalisisLexico.Token;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

import static compi.g19.AnalisisSintactico.Parser.*;

@Getter
@Setter
public class NodoComun extends Nodo {

    /*

    Dos usos claros

    1 Son nodos especiales que representan estructuras de control como IF, FOR, o WHILE.


    2 Representan operaciones aritméticas, asignaciones, o comparaciones.
        Estos nodos tienen hijos (generalmente dos) que corresponden a los operandos
    */

    private Nodo izq;
    private Nodo der; //Si tiene un solo hijo, der es null

    private String label;
    private String labelFin;
    private NodoHoja ultimoNodo;
    private String varAuxiliar;
    private static final String ENTERO = "ulongint";
    private static final String FLOTANTE = "single";

    private static Stack<String> varFor = new Stack<>();
    private static boolean inFor;
    private static String codigoIncremento = "";
    private static String startFor;
    private static boolean segundaCondicion;
    private static String codCondicionFor = "";
    private static String labelSegundaCondicionFor;
    private static String labelFor;
    private int contadorEtiqueta = 0;
    private static String funActual;

    private String generarEtiqueta(String prefijo) {
        return prefijo + "_" + (contadorEtiqueta++);
    }


    public static String getLabel() {
        return Nodo.getLabel();
    }

    public NodoComun(String nombre) {
        super(nombre, new Token());
        izq = null;
        der = null;
    }

    public NodoComun(String nombre, Nodo nodoIzq) {
        super(nombre, new Token());
        izq = nodoIzq;
        der = null;
    }

    public NodoComun(String nombre, Token t) {
        super(nombre, t);
        izq = null;
        der = null;
    }

    public NodoComun(String nombre, Nodo nodoIzq, Nodo nodoDer) {
        super(nombre, new Token());
        izq = nodoIzq;
        der = nodoDer;
    }

    public NodoComun(Nodo nodo, Nodo nodoIzq, Nodo nodoDer) {
        super(nodo.getNombre(), new Token(nodo.getToken()));
        izq = nodoIzq;
        der = nodoDer;
    }


    @Override
    public void recorrerArbol(int nivel) {
        imprimirNodo(nombre, nivel);
        if (izq != null) {
            izq.recorrerArbol(nivel + 1);
        }
        if (der != null) {
            der.recorrerArbol(nivel + 1);
        }
    }

    @Override
    public String getAssembler() {
        String salida = "";
        Token t;
        switch (super.getNombre()) {
            case "PROGRAMA":
                if (getIzq() != null) {
                    salida = getIzq().getAssembler();
                }
                break;
            case "Sentencia":
                if (getIzq() != null)
                    salida += getIzq().getAssembler();
                if (getDer() != null)
                    salida += getDer().getAssembler();
                break;
            case ":=":
                if (inFor)
                    varFor.add(getIzq().getNombre());

                salida += getDer().getAssembler();

                if (getIzq().getUso().equals("arreglo") && !getIzq().getNombre().contains("[")
                        && getDer().getUso() != null && getDer().getUso().equals("llamado")
                        && getIzq().getTipo().equals(getDer().getTipo()))
                {
                    String arregloDestino = getIzq().getNombre();
                    String tipoDelTipo = tiposDeclarados.get(getIzq().getTipo());

                    if (tipoDelTipo.equals(ENTERO)) {
                        // Para arreglos de enteros
                        salida += "MOV [_" + arregloDestino + " + 0], EAX\n";
                        salida += "MOV [_" + arregloDestino + " + 4], EBX\n";
                        salida += "MOV [_" + arregloDestino + " + 8], EDX\n";
                    } else {
                        // Para arreglos de flotantes
                        // Los valores ya están en la pila FPU en orden inverso (ST(2), ST(1), ST(0))
                        salida += "FSTP DWORD PTR [_" + arregloDestino + " + 8]\n";  // Tercer elemento
                        salida += "FSTP DWORD PTR [_" + arregloDestino + " + 4]\n";  // Segundo elemento
                        salida += "FSTP DWORD PTR [_" + arregloDestino + " + 0]\n";  // Primer elemento
                    }
                }
                else if (getIzq().getUso().equals("arreglo") && !getIzq().getNombre().contains("[")
                        && getDer().getUso() != null && getDer().getUso().equals("arreglo") && !getDer().getNombre().contains("["))
                {
                    // Asignación de un arreglo completo a otro
                    String arregloDestino = getIzq().getNombre(); // Nombre del arreglo destino
                    String arregloOrigen = getDer().getNombre(); // Nombre del arreglo origen

                    // Obtener el tamaño del arreglo (en elementos)
                    int tamañoArreglo = 3; // Este valor debería ser dinámico según el contexto

                    // Registro base para índices
                    salida += "MOV ECX, " + tamañoArreglo + "\n";
                    salida += "MOV ESI, OFFSET _" + arregloOrigen + "\n";
                    salida += "MOV EDI, OFFSET _" + arregloDestino + "\n";

                    // Etiqueta para el bucle
                    String etiquetaInicio = generarEtiqueta("COPIA_INICIO");
                    String etiquetaFin = generarEtiqueta("COPIA_FIN");

                    salida += etiquetaInicio + ":\n";

                    String tipoDelTipo = tiposDeclarados.get(getIzq().getTipo());
                    if (tipoDelTipo.equals(ENTERO)) {
                        // Copiar un entero (4 bytes)
                        salida += "MOV EAX, [ESI]\n";
                        salida += "MOV [EDI], EAX\n";
                    } else {
                        // Copiar un flotante (8 bytes)
                        salida += "FLD QWORD PTR [ESI]\n";
                        salida += "FSTP QWORD PTR [EDI]\n";
                    }

                    // Incrementar punteros
                    salida += "ADD ESI, 4\n"; // Desplazamiento para 4 bytes (tamaño de un entero)
                    salida += "ADD EDI, 4\n";

                    // Decrementar contador y bucle
                    salida += "LOOP " + etiquetaInicio + "\n";

                    salida += etiquetaFin + ":\n";
                }
                else if (getIzq().getUso().equals("arreglo") && getIzq().getNombre().contains("[")) {
                    // Extraer el nombre del arreglo para obtener su índice
                    String nombreConIndice = getIzq().getNombre(); // Ejemplo: "arreglo[1]"
                    int indice = Integer.parseInt(nombreConIndice.substring(nombreConIndice.indexOf('[') + 1, nombreConIndice.indexOf(']')));

                    // Calcular desplazamiento basado en el índice (índice - 1) * tamaño_elemento
                    int desplazamiento = (indice - 1) * (4); // Siempre 4 bytes

                    // Obtiene el tipo original del tipo declarado por el usuario
                    String tipoDelTipo = tiposDeclarados.get(getIzq().getTipo());
                    String arregloNombreTS = getIzq().getLexema().toString();
                    String prefijo = "_";

                    if (tipoDelTipo.equals(ENTERO)) {
                        // Asignación de un valor a un arreglo
                        if (getDer().getUso() != null && !(getDer().getUso().equals("llamado") || getDer().getUso().equals("llamadoConCasteo"))) {
                            String nombreDer = getDer().getUltimoNodo().getNombre();
                            if (nombreDer.startsWith("-")) {
                                nombreDer = nombreDer.substring(1); // Remover el signo negativo si está presente
                            }
                            salida += "MOV EAX, " + prefijo + nombreDer + "\n";
                        }
                        salida += "MOV [_" + arregloNombreTS + " + " + desplazamiento + "], EAX\n";
                    } else {
                        // Asignación de un flotante a un arreglo
                        if (getDer().getUso() != null && !(getDer().getUso().equals("llamado") || getDer().getUso().equals("llamadoConCasteo"))) {
                            String nombreDer = getDer().getUltimoNodo().getNombre();
                            if (nombreDer.startsWith("-")) {
                                nombreDer = nombreDer.substring(1); // Remover el signo negativo si está presente
                            }
                            salida += "FLD " + prefijo + nombreDer.replace('.', '_') + "\n";
                        }
                        salida += "FSTP [_" + arregloNombreTS + " + " + desplazamiento + "]\n";
                    }
                } else if (getDer().getUso() != null && getDer().getUso().equals("arreglo")) {
                    // Asignación de un arreglo a una variable (lo que se necesita para a := t1[1])
                    String nombreConIndice = getDer().getNombre(); // Ejemplo: "t1[1]"
                    int indice = Integer.parseInt(nombreConIndice.substring(nombreConIndice.indexOf('[') + 1, nombreConIndice.indexOf(']')));

                    // Calcular el desplazamiento del índice
                    int desplazamiento = (indice - 1) * (4); // Siempre 4 bytes
                    String arregloNombreTS = getDer().getLexema().toString();

                    // Generar el código para acceder al arreglo y asignarlo a la variable
                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += "MOV EAX, [_" + arregloNombreTS + " + " + desplazamiento + "]\n";
                        salida += "MOV _" + getIzq().getUltimoNodo().getNombre() + ", EAX\n"; // Asignación a la variable
                    } else {
                        salida += "FLD [_" + arregloNombreTS + " + " + desplazamiento + "]\n";
                        salida += "FST _" + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FSTP ST(0)" + "\n";
                    }
                } else {
                    // Asignación estándar (no arreglo)
                    salida += getIzq().getAssembler();
                    if (getIzq().getTipo().equals(ENTERO)) {
                        if (getDer().getUso() != null && !(getDer().getUso().equals("llamado") || getDer().getUso().equals("llamadoConCasteo"))) {
                            String nombreDer = getDer().getUltimoNodo().getNombre();
                            if (nombreDer.startsWith("-")) {
                                nombreDer = nombreDer.substring(1); // Remover el signo negativo si está presente
                            }
                            salida += "MOV EAX, _" + nombreDer + "\n";
                        }
                        salida += "MOV _" + getIzq().getUltimoNodo().getNombre() + ", EAX\n";
                    } else {
                        if (getDer().getUso() != null && !(getDer().getUso().equals("llamado") || getDer().getUso().equals("llamadoConCasteo"))) {
                            String nombreDer = getDer().getUltimoNodo().getNombre();
                            if (nombreDer.startsWith("-")) {
                                nombreDer = nombreDer.substring(1); // Remover el signo negativo si está presente
                            }
                            salida += "FLD _" + nombreDer.replace('.', '_') + "\n";
                        }
                        salida += "FST _" + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FSTP ST(0)" + "\n";
                    }
                }
                break;

            case "+":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();

                t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                TablaSimbolos.addSimbolo(varAuxiliar,t);

                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "MOV EAX, _" + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "ADD EAX, _" + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "MOV _" + varAuxiliar + ", EAX" + "\n";
                } else {
                    salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    salida += "FADD _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    salida += "FLD limite_float\n";
                    salida += "FCOM ST(1)\n";
                    salida += "FSTSW AX\n";
                    salida += "SAHF \n";
                    salida += "JBE handle_overflow\n";
                    salida += "FSTP ST(0)\n";
                    salida += "FST _" + varAuxiliar + "\n";
                }
                break;
            case "-":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                varAuxiliar = Nodo.getVariableAuxiliar();

                t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                TablaSimbolos.addSimbolo(varAuxiliar,t);

                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "MOV EAX, _" + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "SUB EAX, _" + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "MOV _" + varAuxiliar + ", EAX" + "\n";
                    salida += "JS handle_negativos\n";

                } else {
                    salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    salida += "FSUB _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    salida += "FST _" + varAuxiliar + "\n";
                }
                break;
            case "*":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                varAuxiliar = Nodo.getVariableAuxiliar();

                t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                TablaSimbolos.addSimbolo(varAuxiliar,t);

                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "MOV EAX, _" + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "IMUL EAX, _" + getDer().getUltimoNodo().getNombre() + "\n";

                    salida += "MOV _" + varAuxiliar + ", EAX" + "\n";

                } else {
                    salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    salida += "FMUL _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    salida += "FST _" + varAuxiliar + "\n";
                }
                break;
            case "/":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                varAuxiliar = Nodo.getVariableAuxiliar();

                t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                TablaSimbolos.addSimbolo(varAuxiliar,t);

                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "CMP _" + getDer().getUltimoNodo().getNombre() + ", 0\n";

                    salida += "MOV EAX, _" + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "IDIV _" + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "MOV _" + varAuxiliar + ", EAX" + "\n";

                } else {
                    //salida += "FLD _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    //salida += "FSUB _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    //salida += "FTST " + "\n";;

                    salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    salida += "FDIV _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    salida += "FST _" + varAuxiliar + "\n";
                }
                break;
            case "=":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                if (!(getIzq().getNombre().contains("=") || getDer().getNombre().contains("="))) {
                    varAuxiliar = Nodo.getVariableAuxiliar();
                    if  (!segundaCondicion && inFor)
                        startFor = pilaLabels.pop();

                    if (getUso() != null && getUso().equals("pattern_matching"))
                        label = pilaLabels.peek();
                    else
                        label = pilaLabels.pop();

                    t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                    this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                    TablaSimbolos.addSimbolo(varAuxiliar,t);

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JNE ","JE ");
                    } else {
                        salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FCOM _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FSTSW AX \n" + "SAHF \n";
                        salida += "JNE " + label + "\n";
                    }
                }
                break;

            case "!=":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                if (!(getIzq().getNombre().contains("!=") || getDer().getNombre().contains("!="))) {
                    varAuxiliar = Nodo.getVariableAuxiliar();
                    if  (!segundaCondicion && inFor)
                        startFor = pilaLabels.pop();

                    if (getUso() != null && getUso().equals("pattern_matching"))
                        label = pilaLabels.peek();
                    else
                        label = pilaLabels.pop();

                    t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                    this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                    TablaSimbolos.addSimbolo(varAuxiliar,t);

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JE ","JNE ");
                    } else {
                        salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FCOM _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FSTSW AX \n" + "SAHF \n";
                        salida += "JE " + label + "\n";
                    }
                }
                break;

            case ">":
                salida += getIzq().getAssembler() + getDer().getAssembler();
                if (!(getIzq().getNombre().contains(">") || getDer().getNombre().contains(">"))) {
                    varAuxiliar = Nodo.getVariableAuxiliar();
                    if  (!segundaCondicion && inFor)
                        startFor = pilaLabels.pop();

                    if (getUso() != null && getUso().equals("pattern_matching"))
                        label = pilaLabels.peek();
                    else
                        label = pilaLabels.pop();

                    t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                    this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                    TablaSimbolos.addSimbolo(varAuxiliar,t);

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JLE ","JG ");
                    } else {
                        salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FCOM _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FSTSW AX \n" + "SAHF \n";
                        salida += "JBE " + label + "\n";
                    }
                }
                break;

            case ">=":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                if (!(getIzq().getNombre().contains(">=") || getDer().getNombre().contains(">="))) {
                    varAuxiliar = Nodo.getVariableAuxiliar();
                    if  (!segundaCondicion && inFor)
                        startFor = pilaLabels.pop();

                    if (getUso() != null && getUso().equals("pattern_matching"))
                        label = pilaLabels.peek();
                    else
                        label = pilaLabels.pop();

                    t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                    this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                    TablaSimbolos.addSimbolo(varAuxiliar,t);

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JL ","JGE ");
                    } else {
                        salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FCOM _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FSTSW AX \n" + "SAHF \n";
                        salida += "JB " + label + "\n";
                    }
                }
                break;

            case "<":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                if (!(getIzq().getNombre().contains("<") || getDer().getNombre().contains("<"))) {
                    varAuxiliar = Nodo.getVariableAuxiliar();
                    if  (!segundaCondicion && inFor)
                        startFor = pilaLabels.pop();

                    if (getUso() != null && getUso().equals("pattern_matching"))
                        label = pilaLabels.peek();
                    else
                        label = pilaLabels.pop();

                    t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                    this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                    TablaSimbolos.addSimbolo(varAuxiliar,t);

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JGE ","JL ");
                    } else {
                        salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FCOM _" + getDer().getUltimoNodo().getNombre().replace('.', '_')+ "\n";
                        salida += "FSTSW AX \n" + "SAHF \n";
                        salida += "JAE " + label + "\n";
                    }
                }
                break;

            case "<=":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                if (!(getIzq().getNombre().contains("<=") || getDer().getNombre().contains("<="))) {
                    varAuxiliar = Nodo.getVariableAuxiliar();
                    if  (!segundaCondicion && inFor)
                        startFor = pilaLabels.pop();

                    if (getUso() != null && getUso().equals("pattern_matching"))
                        label = pilaLabels.peek();
                    else
                        label = pilaLabels.pop();

                    t = new Token(varAuxiliar,this.getIzq().getTipo(),"variableAuxiliar");
                    this.ultimoNodo = new NodoHoja(varAuxiliar,t);
                    TablaSimbolos.addSimbolo(varAuxiliar,t);

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JG ","JLE ");
                    } else {
                        salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FCOM _" + getDer().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                        salida += "FSTSW AX \n" + "SAHF \n";
                        salida += "JA " + label + "\n";
                    }
                }
                break;
            case "If":
                label = getLabel();
                pilaLabels.push(label); //Condicion
                pilaLabels.push(label);
                salida += getIzq().getAssembler() + getDer().getAssembler() + "\n";
                break;
            case "Then":
            case "Else":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                break;

            case "Cuerpo":

                salida += getIzq().getAssembler();

                //Si es != null es porque tiene Else.
                if (getDer() != null) {
                    labelFin = getLabel();
                    salida += "JMP " + labelFin + "\n";
                    salida += pilaLabels.pop() + ":\n";
                    salida += getDer().getAssembler() + labelFin + ":";
                }
                else {
                    salida += pilaLabels.pop() + ":\n";
                }

                break;
            case "Return":
                if (getIzq().getUso().equals("arreglo") && !getIzq().getNombre().contains("[")) {
                    String arregloOrigen = "_" + getIzq().getNombre();
                    String tipoDelTipo = tiposDeclarados.get(getIzq().getTipo());

                    if (tipoDelTipo.equals(ENTERO)) {
                        // Para arreglos de enteros
                        salida += "MOV EAX, [" + arregloOrigen + " + 0]\n";
                        salida += "MOV EBX, [" + arregloOrigen + " + 4]\n";
                        salida += "MOV EDX, [" + arregloOrigen + " + 8]\n";
                    } else {
                        // Para arreglos de flotantes
                        salida += "FLD DWORD PTR [" + arregloOrigen + " + 0]\n";
                        salida += "FLD DWORD PTR [" + arregloOrigen + " + 4]\n";
                        salida += "FLD DWORD PTR [" + arregloOrigen + " + 8]\n";
                    }
                } else {
                    // Código original para valores no-arreglo
                    salida += getIzq().getAssembler();
                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += "MOV EAX, _" + getIzq().getUltimoNodo().getNombre() + "\n";
                    } else {
                        salida += "FLD _" + getIzq().getUltimoNodo().getNombre().replace('.', '_') + "\n";
                    }
                }
                salida += "POP EBP \n";
                salida += "ret \n";
                break;
            case "Outf":
                String variablePrint = getVariablePrint();

                // Caso de cadena
                if (this.getIzq().getUltimoNodo().getTipo().equals("cadena")) {
                    data += variablePrint + " db \"" + this.getIzq().getUltimoNodo().getNombre() + "\", 10, 0 \n";
                    salida += "invoke printf, addr " + variablePrint + "\n";
                }
                // Caso de invocación de función que retorna un entero
                else if (this.getIzq().getUltimoNodo().getUso() != null
                    && this.getIzq().getUltimoNodo().getUso().equals("llamado")
                    && this.getIzq().getUltimoNodo().getTipo().equals(ENTERO))
                {
                    // La función ha retornado un valor entero, que se encuentra en EAX
                    salida += "invoke printf, cfm$(\"%d\\n\"), eax\n";
                }

                // Caso de invocación de función que retorna un entero
                else if (this.getIzq().getUltimoNodo().getUso() != null
                        && this.getIzq().getUltimoNodo().getUso().equals("llamado")
                        && this.getIzq().getUltimoNodo().getTipo().equals(FLOTANTE)) {
                    // La función ha retornado un valor flotante, que se encuentra en ST(0)
                    salida += "sub esp, 8\n"; // Reservar espacio en la pila
                    salida += "FSTP qword ptr [esp]\n"; // Almacenar el valor flotante en la pila
                    salida += "invoke printf, cfm$(\"%.20Lf\\n\"), qword ptr [esp]\n"; // Pasar el valor flotante a printf
                    salida += "add esp, 8\n"; // Liberar el espacio reservado en la pila
                }
                else if (this.getIzq().getUltimoNodo().getUso() != null
                        && this.getIzq().getUltimoNodo().getUso().equals("llamado")
                        && this.getIzq().getUltimoNodo().getTipo().equals(ENTERO))
                {
                    // La función ha retornado un valor entero, que se encuentra en EAX
                    salida += "invoke printf, cfm$(\"%d\\n\"), eax\n";
                }
                // Caso de arreglo o variable de tipo entero
                else if (this.getIzq().getUltimoNodo().getUso() != null
                        && this.getIzq().getUltimoNodo().getUso().equals("arreglo")
                        && tiposDeclarados.get(getIzq().getTipo()).equals(ENTERO)
                        && getIzq().getNombre().contains("[")) {
                    // Extraer el nombre del arreglo y el índice
                    String nombreConIndice = this.getIzq().getUltimoNodo().getNombre(); // Ejemplo: "t1[1]"
                    int indice = Integer.parseInt(nombreConIndice.substring(nombreConIndice.indexOf('[') + 1, nombreConIndice.indexOf(']')));

                    // Calcular desplazamiento del índice
                    int desplazamiento = (indice - 1) * 4; // Para enteros, 4 bytes de tamaño por elemento

                    // Generar código de impresión para un entero en el arreglo
                    salida += "invoke printf, cfm$(\"%d\\n\"), [_" + this.getIzq().getLexema() + " + " + desplazamiento + "]\n";
                }
                // Caso de variable de tipo entero
                else if (this.getIzq().getUltimoNodo().getTipo().equals(ENTERO)) {
                    salida += salida + "invoke printf, cfm$(\"%d\\n\"), " + "[_" + this.getIzq().getUltimoNodo().getNombre() + "]" + "\n" ;
                }
                // Caso de arreglo o variable de tipo flotante
                else if (this.getIzq().getUltimoNodo().getUso() != null
                        && this.getIzq().getUltimoNodo().getUso().equals("arreglo")
                        && tiposDeclarados.get(getIzq().getTipo()).equals(FLOTANTE)
                        && getIzq().getNombre().contains("[")) {
                    // Extraer el nombre del arreglo y el índice
                    String nombreConIndice = this.getIzq().getUltimoNodo().getNombre(); // Ejemplo: "t1[1]"
                    int indice = Integer.parseInt(nombreConIndice.substring(nombreConIndice.indexOf('[') + 1, nombreConIndice.indexOf(']')));

                    // Calcular desplazamiento del índice
                    int desplazamiento = (indice - 1) * 4; // Para flotantes, 4 bytes de tamaño por elemento

                    // Generar código de impresión para un flotante en el arreglo
                    salida += "FLD [_" + this.getIzq().getLexema() + " + " + desplazamiento + "]\n"; // Cargar el valor del arreglo en ST(0)
                    salida += "sub esp, 8\n"; // Reservar espacio en la pila para el argumento
                    salida += "FSTP qword ptr [esp]\n"; // Almacenar el valor flotante en la pila
                    salida += "invoke printf, cfm$(\"%.20Lf\\n\"), qword ptr [esp]\n"; // Pasar el valor flotante a printf
                    salida += "add esp, 8\n"; // Liberar el espacio reservado en la pila
                }
                // Caso de arreglo completo
                else if (this.getIzq().getUltimoNodo().getUso() != null
                        && this.getIzq().getUltimoNodo().getUso().equals("arreglo")
                        && !getIzq().getNombre().contains("[")) {
                    // Obtener información del arreglo
                    String nombreArreglo = this.getIzq().getUltimoNodo().getNombre();
                    String tipoArreglo = tiposDeclarados.get(getIzq().getTipo());
                    int tamanoArreglo = 3;

                    // Generar código para iterar e imprimir cada elemento
                    for (int i = 0; i < tamanoArreglo; i++) {
                        int desplazamiento = i * 4; // Asumimos 4 bytes por elemento (para enteros o flotantes)
                        if (tipoArreglo.equals(ENTERO)) {
                            salida += "invoke printf, cfm$(\"%d\\n\"), [_" + nombreArreglo + " + " + desplazamiento + "]\n";
                        } else if (tipoArreglo.equals(FLOTANTE)) {
                            salida += "FLD [_" + nombreArreglo + " + " + desplazamiento + "]\n";
                            salida += "sub esp, 8\n";
                            salida += "FSTP qword ptr [esp]\n";
                            salida += "invoke printf, cfm$(\"%.20Lf\\n\"), qword ptr [esp]\n";
                            salida += "add esp, 8\n";
                        }
                    }
                }
                // Caso de variable de tipo flotante
                else if (this.getIzq().getUltimoNodo().getTipo().equals(FLOTANTE)) {
                    salida += salida + "invoke printf, cfm$(\"%.20Lf\\n\"), " + "[_" + this.getIzq().getUltimoNodo().getNombre() + "]" + "\n" ;
                }

                break;
            case "Asignacion e Incremento":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                //Segunda condicion
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                break;
            case "Condiciones":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                //Segunda condicion
                if (getDer() != null) {
                    segundaCondicion = true;
                    codCondicionFor += getDer().getAssembler();
                }
                break;
            case "For":
                label = getLabel();
                pilaLabels.push(label); // Condición de entrada al bucle
                pilaLabels.push(label);
                label = getLabel();
                pilaLabels.push(label);

                if (getIzq() != null) {
                    salida += getIzq().getAssembler();  // Obtener el primer valor para la condición
                }

                String end_loop = getLabel();
                salida += "JMP " + end_loop + "\n";  // Salto al final si no se cumple la condición
                salida += labelFor + ":" + "\n";  // Etiqueta de inicio del bucle

                if (segundaCondicion) {
                    salida += codCondicionFor;  // Condición principal
                    salida += "JMP " + end_loop + "\n";  // Si no cumple la condición, saltar al final
                    salida += labelSegundaCondicionFor + ":" + "\n";  // Etiqueta de la segunda condición
                }

                segundaCondicion = false;

                if (getDer() != null) {
                    salida += getDer().getAssembler();  // Ejecutar lo que se realiza dentro del bucle
                }


                salida += codigoIncremento;

                // Asegurarse de que el salto al inicio del bucle no tenga condiciones adicionales
                salida += "JMP " + startFor + "\n";  // Volver a la etiqueta de inicio del bucle

                salida += end_loop + ":" + "\n";  // Etiqueta de salida del bucle
                pilaLabels.clear();
                break;
            case "Encabezado For":
                if (getIzq() != null) {
                    inFor = true;
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                inFor = false;
                break;

            case "Incremento":
                varAuxiliar = Nodo.getVariableAuxiliar();

                t = new Token(varAuxiliar, this.getDer().getTipo(), "variableAuxiliar");
                this.ultimoNodo = new NodoHoja(varAuxiliar, t);
                TablaSimbolos.addSimbolo(varAuxiliar, t);

                String var = varFor.pop();

                if (getIzq().getNombre().equals("Down")) {  // Control de dirección Down
                    codigoIncremento += "MOV EAX, _" + var + "\n";
                    codigoIncremento += "SUB EAX, _" + getDer().getUltimoNodo().getNombre() + "\n";  // Decremento
                    codigoIncremento += "JS handle_negativos\n";  // Manejo de valores negativos
                    codigoIncremento += "MOV _" + var + ", EAX" + "\n";  // Asignación con decremento

                } else {  // Control de incremento
                    codigoIncremento += "MOV EAX, _" + var + "\n";
                    codigoIncremento += "ADD EAX, _" + getDer().getUltimoNodo().getNombre() + "\n";  // Incremento
                    codigoIncremento += "MOV _" + var + ", EAX" + "\n";  // Asignación con incremento
                }

                break;

            // Declaración o invocación a función
            default:
                String uso = this.getUso();
                if (uso != null) {
                    if (uso.equals("funcion")) {
                        varAuxiliar = Nodo.getVariableAuxiliar();
                        t = new Token(varAuxiliar, this.getTipo(), "variableAuxiliar");
                        this.ultimoNodo = new NodoHoja(varAuxiliar, t);
                        TablaSimbolos.addSimbolo(varAuxiliar, t);
                        salida += getNombre() + ":\n";
                        salida += "PUSH EBP\n"; // Guardar EBP actual en la pila
                        salida += "MOV EBP, ESP\n"; // Actualizar EBP al puntero actual de la pila
                        if (getIzq().getTipo().equals(ENTERO)) {
                            String nombreParametro = getIzq().getNombre().replace('.', '_'); // Reemplazar punto por guion bajo
                            salida += "MOV EAX, [EBP + 8]\n"; // Cargar el valor del parámetro real
                            salida += "MOV _" + nombreParametro + ", EAX\n";
                        }
                        if (getIzq().getTipo().equals(FLOTANTE)) {
                            String nombreParametro = getIzq().getNombre().replace('.', '_'); // Reemplazar punto por guion bajo
                            salida += "FLD QWORD PTR [EBP + 8]\n"; // Cargar el valor del parámetro real
                            salida += "FSTP _" + nombreParametro + "\n";
                        }
                        // No se aplica conversión en la definición de la función
                        funActual = getNombre();
                        salida += getDer().getAssembler();
                        funActual = null;
                    } else if (uso.equals("llamado") || uso.equals("llamadoConCasteo")) {
                        varAuxiliar = Nodo.getVariableAuxiliar();
                        t = new Token(varAuxiliar, this.getTipo(), "variableAuxiliar");
                        this.ultimoNodo = new NodoHoja(varAuxiliar, t);
                        TablaSimbolos.addSimbolo(varAuxiliar, t);

                        String lexemaFuncion = getNombre();
                        String lexemaVariableQueInvoca = getIzq().getNombre();

                        // Comparar lexemas para verificar autoinvocación (usando name mangling)
                        if (funActual != null && funActual.equals(getNombre())) {
                            salida += "JMP handle_autoinvocacion\n";
                        } else {
                            if (uso.equals("llamado")) {
                                String nombreParametro = getIzq().getNombre();
                                if (nombreParametro.equals("+") || nombreParametro.equals("-") || nombreParametro.equals("*") || nombreParametro.equals("/")) {
                                    salida += getIzq().getAssembler();
                                    nombreParametro = getIzq().getUltimoNodo().getNombre();
                                }
                                if (getIzq().getTipo().equals(ENTERO)) {
                                    nombreParametro = nombreParametro.replace('.', '_'); // Reemplazar punto por guion bajo
                                    salida += "MOV EAX, _" + nombreParametro + "\n"; // Cargar el valor del parámetro real
                                    salida += "PUSH EAX\n"; // Colocar en la pila el valor del parámetro
                                }
                                if (getIzq().getTipo().equals(FLOTANTE)) {
                                    nombreParametro = nombreParametro.replace('.', '_'); // Reemplazar punto por guion bajo
                                    salida += "FLD _" + nombreParametro + "\n";
                                    salida += "SUB ESP, 8\n";
                                    salida += "FSTP QWORD PTR [ESP]\n";
                                }
                            }
                            if (uso.equals("llamadoConCasteo")) {
                                String tipoReal = getDer().getNombre(); // Nombre del nodo tipo (tipoReal)
                                String tipoFormal = getIzq().getTipo(); // Tipo esperado por la función
                                String nombreParametro = getIzq().getNombre();
                                if (nombreParametro.equals("+") || nombreParametro.equals("-") || nombreParametro.equals("*") || nombreParametro.equals("/")) {
                                    salida += getIzq().getAssembler();
                                    nombreParametro = getIzq().getUltimoNodo().getNombre();
                                }
                                if (tipoReal.equals(ENTERO) && tipoFormal.equals(FLOTANTE)) {
                                    nombreParametro = nombreParametro.replace('.', '_'); // Reemplazar punto por guion bajo
                                    salida += "MOV EAX, _" + nombreParametro + "\n"; // Cargar el valor del parámetro real
                                    salida += "PUSH EAX\n"; // Colocar en la pila el valor del parámetro
                                    salida += "FILD DWORD PTR [ESP]\n";  // Cargar el entero como flotante en la FPU
                                    salida += "FSTP QWORD PTR [ESP]\n";  // Guardar el resultado como flotante en la pila
                                } else if (tipoReal.equals(FLOTANTE) && tipoFormal.equals(ENTERO)) {
                                    nombreParametro = nombreParametro.replace('.', '_'); // Reemplazar punto por guion bajo
                                    salida += "FLD _" + nombreParametro + "\n";
                                    salida += "SUB ESP, 8\n";
                                    salida += "FSTP QWORD PTR [ESP]\n";
                                    salida += "FLD QWORD PTR [ESP]\n";   // Cargar el flotante en la FPU
                                    salida += "FISTP DWORD PTR [ESP]\n"; // Convertir a entero y guardar en la pila
                                }
                            }

                            salida += "CALL " + getNombre() + "\n"; // Llamar a la función
                            if (getTipo().equals(ENTERO))
                                salida += "ADD ESP, 4\n"; // Restaurar el puntero de la pila
                            if (getTipo().equals(FLOTANTE))
                                salida += "ADD ESP, 8\n"; // Restaurar el puntero de la pila
                        }
                    }
                }
                break;

        }
        return salida;
    }

    private String condiciones(String real, String contrario){
        String salida = "";
        String prefijo = "_";
        salida += "MOV EAX, " + prefijo + getIzq().getUltimoNodo().getNombre() + "\n";
        labelFor = label;
        if (inFor) {
            if (!segundaCondicion) {
                salida += startFor + ":" + "\n";
                salida += "CMP EAX, _" + getDer().getUltimoNodo().getNombre() + "\n";
                salida += contrario+ " " + labelFor + "\n";
            } else {
                labelSegundaCondicionFor = getLabel();
                salida += "CMP EAX, _" + getDer().getUltimoNodo().getNombre() + "\n";
                salida += contrario+ " " + labelSegundaCondicionFor + "\n";
            }
        }else{
            salida += "CMP EAX, _" + getDer().getUltimoNodo().getNombre() + "\n";
            salida += real+ " " + labelFor + "\n";
        }

        return salida;
    }

}
