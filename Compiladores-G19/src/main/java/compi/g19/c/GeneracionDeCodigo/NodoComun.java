package compi.g19.c.GeneracionDeCodigo;

import compi.g19.a.AnalisisLexico.Token;

public class NodoComun extends Nodo{

    /*

    Dos usos claros

    1 Son nodos especiales que representan estructuras de control como IF, FOR, o WHILE.


    2 Representan operaciones aritméticas, asignaciones, o comparaciones.
        Estos nodos tienen hijos (generalmente dos) que corresponden a los operandos
    */

    private Nodo izq;
    private Nodo der;

    public NodoComun(Token t, Nodo izq, Nodo der) {
        super(t);
        this.izq = izq;
        this.der = der;
    }

    @Override
    public void recorrerArbol() {
        //
    }
}
