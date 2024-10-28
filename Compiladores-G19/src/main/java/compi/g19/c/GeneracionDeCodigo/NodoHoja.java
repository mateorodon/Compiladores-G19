package compi.g19.c.GeneracionDeCodigo;

import compi.g19.a.AnalisisLexico.Token;

public class NodoHoja extends Nodo {

    /*
    Representan constantes, identificadores (ID), o valores primitivos (por ejemplo, tipos ULONGINT, SINGLE)
    Son nodos terminales, sin hijos
    */

    public NodoHoja(Token t) {
        super(t);
    }

    @Override
    public void recorrerArbol() {
        //
    }
}
