package compi.g19.GeneracionDeCodigo;

import compi.g19.AnalisisLexico.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodoComun extends Nodo{

    /*

    Dos usos claros

    1 Son nodos especiales que representan estructuras de control como IF, FOR, o WHILE.


    2 Representan operaciones aritméticas, asignaciones, o comparaciones.
        Estos nodos tienen hijos (generalmente dos) que corresponden a los operandos
    */

    private Nodo izq;
    private Nodo der; //Si tiene un solo hijo, der es null


    //ASSEMBLER
    private String varLabel;
    private String labelFin;
    private NodoHoja ultimoNodo;
    private String varAuxiliar;

    public NodoComun(String nombre){
        super(nombre, new Token());
        izq = null;
        der = null;
    }

    public NodoComun(String nombre, Nodo nodoIzq){
        super(nombre, new Token());
        izq = nodoIzq;
        der = null;
    }

    public NodoComun(String nombre, Nodo nodoIzq, Nodo nodoDer){
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

    /*
    CASOS A TRATAR EN ASSEMBLER:
    Sentencia
    For
    Encabezado For
    := (Asignacion)
    Incremento
    Asignacion e Incremento ?? no lo se
    Condicion
    Condiciones  ?? no lo se
    Funcion (viene dado por el nopmbre mas ambito de la funcion)
    Return
    +
    -
    *
    /
    >=
    <=
    !=
    =
    >
    <
    If
    Then
    Else
    Cuerpo
    Outf
     */

    @Override
    public String getAssembler() {
        String salida = "";
        switch(super.getNombre()) {

            case "Sentencia":
                if (getIzq() != null)
                    salida += getIzq().getAssembler();
                if (getDer() != null)
                    salida += getDer().getAssembler();
                break;
            case ":=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                if(getIzq().getTipo().equals("ULONGINT")){
                    salida+= "MOV EAX , " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida+= "MOV " + getIzq().getUltimoNodo().getLexema() + ", " + "EAX" + "\n";
                }else {
                    salida += "FLD " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FST " + getIzq().getUltimoNodo().getLexema() + "\n";
                }
                break;
            case "+":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if(getIzq().getTipo().equals("ULONGINT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "ADD EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "MOV " + varAuxiliar + ", EAX" + "\n";
                }
                else
                {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FADD " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JO errorSumaDouble\n";
                    salida += "FST "+ varAuxiliar + "\n";
                }
                break;
            case "-":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("ULONGINT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "SUB EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JO errorRestaEnteros\n";
                    salida += "MOV " + varAuxiliar + ", EAX" + "\n";

                } else
                {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FSUB " + getDer().getUltimoNodo().getLexema() + "\n";

                    salida += "FST " + varAuxiliar + "\n";
                }
                break;
            case "*":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("ULONGINT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "IMUL EAX, " + getDer().getUltimoNodo().getLexema() + "\n";

                    salida += "MOV " + varAuxiliar + ", EAX" + "\n";

                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FMUL " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FST " + varAuxiliar + "\n";
                }
                break;
            case "/":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("ULONGINT")) {
                    salida += "CMP " + getDer().getUltimoNodo().getLexema() + ", 0\n";

                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "IDIV " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "MOV " + varAuxiliar + ", EAX" + "\n";

                } else {
                    salida += "FLD " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FSUB " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FTST ";

                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FDIV " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FST " + varAuxiliar + "\n";
                }
                break;
            case "=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();
                varLabel = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("ULONGINT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JNE " + varLabel + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JNE " + varLabel + "\n";
                }
                break;

            case "!=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();
                varLabel = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("ULONGINT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JE " + varLabel + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JE " + varLabel + "\n";
                }
                break;

            case ">":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();
                varLabel = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("ULONGINT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JLE " + varLabel + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JLE " + varLabel + "\n";
                }
                break;

            case ">=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();
                varLabel = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("ULONGINT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JL " + varLabel + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JL " + varLabel + "\n";
                }
                break;

            case "<":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();
                varLabel = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("ULONGINT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JGE " + varLabel + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JGE " + varLabel + "\n";
                }
                break;

            case "<=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                varAuxiliar = Nodo.getVariableAuxiliar();
                varLabel = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(varAuxiliar);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("ULONGINT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JG " + varLabel + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JG " + varLabel + "\n";
                }
                break;
        }
        return salida;
    }
}
