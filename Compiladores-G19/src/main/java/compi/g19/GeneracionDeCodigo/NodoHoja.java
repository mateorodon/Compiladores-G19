package compi.g19.GeneracionDeCodigo;

import compi.g19.AnalisisLexico.Token;

public class NodoHoja extends Nodo {

    /*
    Representan constantes, identificadores (ID), o valores primitivos (por ejemplo, tipos ULONGINT, SINGLE)
    Son nodos terminales, sin hijos
    */

    public NodoHoja(String nombre){
        super(nombre);
    }

    public NodoHoja(String nombre, Token t){
        super(nombre,t);
    }

    @Override
    public void recorrerArbol(int nivel) {
        imprimirNodo(nombre, nivel);
    }
}
