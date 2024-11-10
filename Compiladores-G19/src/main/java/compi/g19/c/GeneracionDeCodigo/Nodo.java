package compi.g19.c.GeneracionDeCodigo;

import compi.g19.a.AnalisisLexico.Token;
import compi.g19.b.AnalisisSintactico.ParserVal;
import lombok.Data;


public abstract class Nodo extends ParserVal {

    protected String nombre;
    protected Token token;
    protected Integer nivel = 0;

    public Nodo(String nombre){
        this.nombre = nombre;
        this.token = null;
    }

    public Nodo(String nombre, Token t){
        this.nombre = nombre;
        this.token = t;
    }

    public abstract void recorrerArbol();

    protected void imprimirNodo() {
        // Imprime el nodo con la cantidad de espacios en función de su nivel
        System.out.println("    ".repeat(nivel) + nombre);
    }

}
