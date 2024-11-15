package compi.g19.GeneracionDeCodigo;

import compi.g19.AnalisisLexico.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
        super(nombre, new Token());
        izq = null;
        der = null;
    }

    public NodoComun(String nombre, Nodo nodoIzq){
        super(nombre, new Token());
        izq = nodoIzq;
        der = null;
    }

    public NodoComun(String nombre, Nodo nodoIzq, Nodo nodoDer){
        super(nombre, new Token());
        izq = nodoIzq;
        der = nodoDer;
    }

    @Override
    public void recorrerArbol(int nivel) {
        imprimirNodo(nombre, nivel);
        if (izq != null) {
            izq.recorrerArbol(nivel + 1);
        }
        if (der != null) {
            der.recorrerArbol(nivel + 1);
        }
    }

    /*
    CASOS A TRATAR EN ASSEMBLER:
    Sentencia
    For
    Encabezado For
    := (Asignacion)
    Incremento
    Asignacion e Incremento ?? no lo se
    Condicion
    Condiciones  ?? no lo se
    Funcion (viene dado por el nopmbre mas ambito de la funcion)
    Return
    +
    -
    *
    /
    >=
    <=
    !=
    =
    >
    <
    If
    Then
    Else
    Cuerpo
    Outf
     */

    @Override
    public String getAssembler() {
        String salida = "";
        switch(super.getLexema()) {

            case "Sentencia":
                if (getIzq() != null)
                    salida += getIzq().getAssembler();
                if (getDer() != null)
                    salida += getDer().getAssembler();
                break;
            case ":=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                if(getIzq().getTipo().equals("ULONGINT")){
                    salida+= "MOV EAX , " + getDer().getLexema() + "\n";
                    salida+= "MOV " + getIzq().getLexema() + ", " + "EAX" + "\n";
                }else { //flotante ?
                    salida += "FLD " + getDer().getLexema() + "\n";
                    salida += "FST " + getIzq().getLexema() + "\n";
                }
                break;
        }
        return salida;
    }
}
