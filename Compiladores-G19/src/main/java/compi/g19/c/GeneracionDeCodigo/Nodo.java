package compi.g19.c.GeneracionDeCodigo;

import compi.g19.a.AnalisisLexico.Token;
import compi.g19.b.AnalisisSintactico.ParserVal;
import lombok.Data;


public abstract class Nodo extends ParserVal {

    protected String nombre;
    protected Token token;

    public Nodo(String nombre){
        this.nombre = nombre;
        this.token = null;
    }

    public Nodo(String nombre, Token t){
        this.nombre = nombre;
        this.token = t;
    }

    public abstract void recorrerArbol();


}
