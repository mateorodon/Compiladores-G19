package compi.g19.GeneracionDeCodigo;

import compi.g19.AnalisisLexico.Token;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

import static compi.g19.AnalisisSintactico.Parser.getFuncionAutoinvocada;
import static compi.g19.AnalisisSintactico.Parser.tiposDeclarados;

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
        super(nodo.getNombre(), nodo.getToken());
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

                if (getIzq().getUso().equals("arreglo")) {
                    // Extraer el nombre del arreglo para obtener su indice
                    String nombreConIndice = getIzq().getNombre(); // Ejemplo: "arreglo[1]"
                    String arregloNombre = nombreConIndice.substring(0, nombreConIndice.indexOf('['));
                    int indice = Integer.parseInt(nombreConIndice.substring(nombreConIndice.indexOf('[') + 1, nombreConIndice.indexOf(']')));


                    // Calcular desplazamiento basado en el índice (índice - 1) * tamaño_elemento
                    int desplazamiento = (indice - 1) * (getIzq().getTipo().equals(ENTERO) ? 4 : 4); // Siempre 4 bytes

                    // Obtiene el tipo original del tipo declarado por el usuario
                    // e.g TRIPLE <ulongint> tint;
                    // tint t1; => el tipo de tint es ulongint/ENTERO
                    String tipoDelTipo = tiposDeclarados.get(getIzq().getTipo());

                    if (tipoDelTipo.equals(ENTERO)){
                        // Generar código para asignación a un entero en el arreglo
                        salida += "MOV EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "MOV [" + arregloNombre + " + " + desplazamiento + "], EAX\n";
                    } else {
                        // Generar código para asignación a un flotante en el arreglo
                        salida += "FLD " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "FSTP [" + arregloNombre + " + " + desplazamiento + "]\n";
                    }
                } else {
                    // Asignación estándar (no arreglo)
                    salida += getIzq().getAssembler();
                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += "MOV EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "MOV " + getIzq().getUltimoNodo().getNombre() + ", EAX\n";
                    } else {
                        salida += "FLD " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "FST " + getIzq().getUltimoNodo().getNombre() + "\n";
                    }
                }
                break;
            case "+":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "ADD EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "MOV " + varAuxiliar + ", EAX" + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "FADD " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "JO errorSumaDouble\n";
                    salida += "FST " + varAuxiliar + "\n";
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

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "SUB EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "JO OperacionEnteroNegativo\n";
                    salida += "MOV " + varAuxiliar + ", EAX" + "\n";

                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "FSUB " + getDer().getUltimoNodo().getNombre() + "\n";

                    salida += "FST " + varAuxiliar + "\n";
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

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "IMUL EAX, " + getDer().getUltimoNodo().getNombre() + "\n";

                    salida += "MOV " + varAuxiliar + ", EAX" + "\n";

                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "FMUL " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "FST " + varAuxiliar + "\n";
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

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "CMP " + getDer().getUltimoNodo().getNombre() + ", 0\n";

                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "IDIV " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "MOV " + varAuxiliar + ", EAX" + "\n";

                } else {
                    salida += "FLD " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "FSUB " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "FTST ";

                    salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "FDIV " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "FST " + varAuxiliar + "\n";
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

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JNE","JE");
                    } else {
                        salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FCOM " + getDer().getUltimoNodo().getNombre() + "\n";
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

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JE","JNE");
                    } else {
                        salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FCOM " + getDer().getUltimoNodo().getNombre() + "\n";
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

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JLE","JG");
                    } else {
                        salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FCOM " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JLE " + label + "\n";
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

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JL","JGE");
                    } else {
                        salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FCOM " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JL " + label + "\n";
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

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JGE ","JL ");
                    } else {
                        salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FCOM " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JGE " + label + "\n";
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

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += condiciones("JG","JLE");
                    } else {
                        salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FCOM " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JG " + label + "\n";
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
                break;

            case "Cuerpo":

                salida += getIzq().getAssembler();

                //Si es != null es porque tiene Else.
                if (getDer() != null) {
                    labelFin = getLabel();
                    salida += "JMP " + labelFin + "\n";
                    salida += pilaLabels.pop() + ":\n";
                    salida += getDer().getAssembler() + labelFin + ":\n";
                }

                break;
            case "Return":
                String ret = getVariableAuxiliar();
                salida += getIzq().getAssembler();
                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "MOV " + ret + ", EAX" + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "FST " + ret + "\n";
                }
                salida += "ret " + "\n";
                break;
            case "Outf":
                String variablePrint = getVariablePrint();
                data = variablePrint + " db \"" + this.getIzq().getUltimoNodo().getNombre() + "\", 0 \n";
                salida += salida + "invoke MessageBox, NULL, addr " + variablePrint + ", addr printMensaje, MB_OK\n";
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
                pilaLabels.push(label); //Condicion
                pilaLabels.push(label);
                label = getLabel();
                pilaLabels.push(label);
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                label = pilaLabels.pop();
                String end_loop = getLabel();
                salida += "JMP " + end_loop + ":" + "\n";
                salida += label + ":" + "\n";
                label = pilaLabels.pop();
                if (segundaCondicion){
                    salida += codCondicionFor;
                    salida += "JMP " + end_loop + ":" + "\n";
                    salida += labelSegundaCondicionFor + ":" + "\n";
                }
                segundaCondicion = false;
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                salida += codigoIncremento;
                salida += "JMP " + startFor + "\n";
                salida += end_loop + ":" + "\n";

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

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setUso("variableAuxiliar");

                String var = varFor.pop();

                if (getIzq().getNombre().equals("DOWN")) {
                    codigoIncremento += "MOV EAX, " + var + "\n";
                    codigoIncremento += "SUB EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                    codigoIncremento += "JO OperacionEnteroNegativo\n";
                    codigoIncremento += "MOV " + varAuxiliar + ", EAX" + "\n";
                    codigoIncremento += "MOV " + var + ", " + varAuxiliar;

                } else {
                    codigoIncremento += "MOV EAX, " + var + "\n";
                    codigoIncremento += "ADD EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                    codigoIncremento += "MOV " + varAuxiliar + ", EAX" + "\n";
                    codigoIncremento += "MOV " + var + ", " + varAuxiliar + "\n";
                }

                break;

            //Declaracion o invocacion a funcion
            default:
                String uso = this.getUso();
                if (uso.equals("funcion")) {
                    NodoHoja n = (new NodoHoja("@aux@" + getIzq().getNombre()));
                    n.setTipo(getIzq().getTipo());
                    n.setUso("variableAuxiliar");
                    pilaVariablesAuxiliares.push("@aux@" + getIzq().getNombre());
                    salida += getNombre() + ":\n";
                    salida += getDer().getAssembler();
                    pilaVariablesAuxiliares.pop();
                    if (getFuncionAutoinvocada())
                        salida += " JMP AutoinvocacionFunciones\n";
                    else
                        salida += "JMP errorFun";
                } else if (getUso().equals("llamado")) {

                    //String varAux = getVariableAuxiliar();
                    salida += "MOV " + "EAX" + ", " + getIzq().getNombre() + "\n";
                    //this.ultimoNodo = new NodoHoja(varAux);
                    //this.ultimoNodo.setUso("variableAuxiliar");
                    salida += salida + "call " + getNombre() + "\n";
                }
                break;
        }
        return salida;
    }


    private String condiciones(String real, String contrario){
        String salida = "";
        salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
        if (inFor) {
            if (!segundaCondicion) {
                salida += startFor + ":" + "\n";
                salida += "CMP EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                salida += contrario + label + "\n";
            } else {
                labelSegundaCondicionFor = getLabel();
                salida += "CMP EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                salida += contrario + labelSegundaCondicionFor + "\n";
            }
        }else{
            salida += "CMP EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
            salida += real + label + "\n";
        }

        return salida;
    }
}
