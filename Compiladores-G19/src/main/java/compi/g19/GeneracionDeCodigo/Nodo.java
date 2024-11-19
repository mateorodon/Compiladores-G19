package compi.g19.GeneracionDeCodigo;

import compi.g19.AnalisisLexico.Token;
import compi.g19.AnalisisSintactico.ParserVal;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;


public abstract class Nodo extends ParserVal {

    @Getter
    @Setter
    protected String nombre;
    protected Token token;

    protected static int numeroLabel = 0;
    protected static int numeroPrint = 0;
    public static String data = "";
    protected static Stack<String> pilaLabels = new Stack();
    protected static Stack<String> pilaVariablesAuxiliares = new Stack<String>();

    static int numeroVariableAuxiliar = 0;


    public Nodo(String nombre) {
        this.nombre = nombre;
        this.token = null;
    }

    public Nodo(String nombre, Token token){
        this.nombre = nombre;
        this.token = token;
    }

    public Token getToken() {
        return this.token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getTipo(){
        return token.getTipo();
    }

    public void setTipo(String tipo){
        token.setTipo(tipo);
    }

    public void setAmbito(String amb){
        token.setAmbito(amb);
    }

    public String getAmbito(){
        return token.getAmbito();
    }

    public void setLexema(String lex){
        token.setTipo(lex);
    }

    public String getLexema(){
        return token.getLexema().toString();
    }

    public String getUso(){
        return token.getUso();
    }

    public void setUso(String uso){
        token.setUso(uso);
    }

    public void setValor(String valor){
        token.setValor(valor);
    }

    public abstract void recorrerArbol(int nivel);

    public abstract String getAssembler();

    public abstract NodoHoja getUltimoNodo();

    public static String getVariableAuxiliar() {
        ++numeroVariableAuxiliar;
        return "@aux" + numeroVariableAuxiliar;
    }

    public static String getVariablePrint() {
        ++numeroPrint;
        return "@print" + numeroPrint;
    }

    public static String getLabel() {
        ++numeroLabel;
        return "label" + numeroLabel;
    }

    protected void imprimirNodo(String nombre, int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(nombre);
    }

}
