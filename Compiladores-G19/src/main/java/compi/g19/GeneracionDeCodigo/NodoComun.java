package compi.g19.GeneracionDeCodigo;

import compi.g19.AnalisisLexico.Token;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

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
                salida += getDer().getAssembler() + getIzq().getAssembler();
                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "MOV EAX , " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "MOV " + getIzq().getUltimoNodo().getNombre() + ", " + "EAX" + "\n";
                } else {
                    salida += "FLD " + getDer().getUltimoNodo().getNombre() + "\n";
                    salida += "FST " + getIzq().getUltimoNodo().getNombre() + "\n";
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
                    salida += "JO errorRestaEnteros\n";
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
                    label = pilaLabels.pop();

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "CMP EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JNE " + label + "\n";
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
                    label = pilaLabels.pop();

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "CMP EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JE " + label + "\n";
                    } else {
                        salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FCOM " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JE " + label + "\n";
                    }
                }
                break;

            case ">":
                    salida += getIzq().getAssembler() + getDer().getAssembler();
                if (!(getIzq().getNombre().contains(">") || getDer().getNombre().contains(">"))){

                    varAuxiliar = Nodo.getVariableAuxiliar();
                    label = pilaLabels.peek();

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "CMP EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JLE " + label + "\n";
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
                    label = pilaLabels.pop();

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "CMP EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JL " + label + "\n";
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
                    label = pilaLabels.pop();

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "CMP EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JGE " + label + "\n";
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
                    label = pilaLabels.pop();

                    this.ultimoNodo = new NodoHoja(varAuxiliar);
                    this.ultimoNodo.setTipo(this.getIzq().getTipo());
                    this.ultimoNodo.setUso("variableAuxiliar");

                    if (getIzq().getTipo().equals(ENTERO)) {
                        salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "CMP EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JG " + label + "\n";
                    } else {
                        salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                        salida += "FCOM " + getDer().getUltimoNodo().getNombre() + "\n";
                        salida += "JG " + label + "\n";
                    }
                }
                break;
            case "If":
                label = getLabel();
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
                salida += getIzq().getAssembler();
                if (getIzq().getTipo().equals(ENTERO)) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "MOV " + getVariableAuxiliar() + ", EAX" + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getNombre() + "\n";
                    salida += "FST " + pilaVariablesAuxiliares.pop() + "\n";
                }
                salida += "ret \n";
                break;
            case "Outf":
                String variablePrint = getVariablePrint();
                data = variablePrint + " db \"" + this.getIzq().getUltimoNodo().getNombre() + "\", 0 \n";
                salida += salida + "invoke MessageBox, NULL, addr " + variablePrint + ", addr printMensaje, MB_OK\n";
                break;
            case "Asignacion e Incremento":
            case "Condiciones":
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                break;
            case "For":
                label = getLabel();
                pilaLabels.push(label);
                if (getIzq() != null) {
                    salida += getIzq().getAssembler();
                }
                String end_loop = getLabel();
                salida += "JMP " + end_loop + ":" + "\n";
                salida += label + ":" + "\n";
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }
                labelFin = getLabel();
                pilaLabels.push(labelFin);
                salida += codigoIncremento;
                salida += "JMP " + label + "\n";
                salida += end_loop + ":" + "\n";

                break;
            case "Encabezado For":
                if (getIzq() != null) {
                    inFor = true;
                    salida += getIzq().getAssembler();
                    inFor = false;
                }
                if (getDer() != null) {
                    salida += getDer().getAssembler();
                }

                break;

            case "Incremento":
                varAuxiliar = Nodo.getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                String var = varFor.pop();

                if (getIzq().getNombre().equals("DOWN")) {
                    codigoIncremento += "MOV EAX, " + var + "\n";
                    codigoIncremento += "SUB EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                    codigoIncremento += "JO errorRestaEnteros\n";
                    codigoIncremento += "MOV " + varAuxiliar + ", EAX" + "\n";
                } else {
                    codigoIncremento += "MOV EAX, " + var + "\n";
                    codigoIncremento += "ADD EAX, " + getDer().getUltimoNodo().getNombre() + "\n";
                    codigoIncremento += "MOV " + varAuxiliar + ", EAX" + "\n";
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
                    salida += "JMP errorFun";
                } else if (getUso().equals("llamado")){
                    if (getIzq() != null) {
                        salida += salida + getDer().getAssembler();
                    }
                    //variable = "@aux@" + this.getDer().getNombre();
                    String varAux = getVariableAuxiliar();
                    this.ultimoNodo = new NodoHoja(varAux);
                    this.ultimoNodo.setUso("variableAuxiliar");
                    salida += salida + "call " + getNombre() + "\n";
                }
                break;
        }
        return salida;
    }
}
