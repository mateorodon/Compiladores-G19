package compi.g19.GeneracionDeCodigo;

import compi.g19.AnalisisLexico.Token;
import compi.g19.AnalisisSintactico.ParserVal;
import lombok.Getter;
import lombok.Setter;


public abstract class Nodo extends ParserVal {

    @Getter @Setter
    protected String nombre;
    protected Token token;

    public Nodo(String nombre){
        this.nombre = nombre;
        this.token = null;
    }

    public Nodo(String nombre, Token token){
        this.nombre = nombre;
        this.token = token;
    }

    public Token getToken(){return this.token;}
    public void setToken(Token token){this.token = token;}

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


    protected void imprimirNodo(String nombre, int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(nombre);
    }

}
