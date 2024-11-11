package compi.g19.GeneracionDeCodigo;

import compi.g19.AnalisisLexico.Token;
import compi.g19.AnalisisSintactico.ParserVal;


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

    public abstract void recorrerArbol(int nivel);


    protected void imprimirNodo(String nombre, int nivel) {
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println(nombre);
    }

}
