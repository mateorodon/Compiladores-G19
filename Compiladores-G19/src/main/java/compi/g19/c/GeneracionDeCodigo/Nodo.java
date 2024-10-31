package compi.g19.c.GeneracionDeCodigo;

import compi.g19.b.AnalisisSintactico.ParserVal;
import lombok.Data;


@Data
public abstract class Nodo extends ParserVal {

    protected String lexema;

    public abstract void recorrerArbol();


}
