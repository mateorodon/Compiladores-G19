package compi.g19.c.GeneracionDeCodigo;

import lombok.Data;

@Data
public class NodoHoja extends Nodo {

    /*
    Representan constantes, identificadores (ID), o valores primitivos (por ejemplo, tipos ULONGINT, SINGLE)
    Son nodos terminales, sin hijos
    */

    @Override
    public void recorrerArbol() {
        //
    }
}
