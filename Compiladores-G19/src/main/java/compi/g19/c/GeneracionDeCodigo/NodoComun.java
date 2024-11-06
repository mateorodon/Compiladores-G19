package compi.g19.c.GeneracionDeCodigo;

public class NodoComun extends Nodo{

    /*

    Dos usos claros

    1 Son nodos especiales que representan estructuras de control como IF, FOR, o WHILE.


    2 Representan operaciones aritméticas, asignaciones, o comparaciones.
        Estos nodos tienen hijos (generalmente dos) que corresponden a los operandos
    */

    private Nodo izq;
    private Nodo der; //Si tiene un solo hijo, der es null

    public NodoComun(String nombre){
        super(nombre);
        izq = null;
        der = null;
    }
    @Override
    public void recorrerArbol() {
        //
    }
}
