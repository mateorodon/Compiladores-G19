package compi.g19.c.GeneracionDeCodigo;

import compi.g19.a.AnalisisLexico.Token;
import compi.g19.b.AnalisisSintactico.ParserVal;

//@Data
public abstract class Nodo extends ParserVal {

    protected Token t;

    public Nodo (Token t){
        this.t = t;
    }


    public abstract void recorrerArbol();

    //Getters y setters del Token
    public String getTipo(){
        return t.getTipo();
    }

    public void setTipo(String tipo){
        t.setTipo(tipo);
    }

    public void setLexema(String lex){
        t.setTipo(lex);
    }

    public String getLexema(){
        return t.getLexema().toString();
    }

    public String getUso(){
        return t.getUso();
    }

    public void setUso(String uso){
        t.setUso(uso);
    }

}
