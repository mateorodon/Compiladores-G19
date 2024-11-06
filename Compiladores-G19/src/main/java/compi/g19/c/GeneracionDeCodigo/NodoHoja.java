package compi.g19.c.GeneracionDeCodigo;

public class NodoHoja extends Nodo {

    /*
    Representan constantes, identificadores (ID), o valores primitivos (por ejemplo, tipos ULONGINT, SINGLE)
    Son nodos terminales, sin hijos
    */

    public NodoHoja(String nombre){
        super(nombre);
    }

    @Override
    public void recorrerArbol() {
        //
    }
}
