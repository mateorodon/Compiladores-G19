package compi.g19;

import java.io.IOException;
import java.io.Reader;

public abstract class AccionSemantica {

    protected static final int TAMANIO_VAR = 15;
    protected static final short ID = 256;
    protected static final short ASIGNACION = 257;
    protected static final short MAYORIGUAL = 258;
    protected static final short MENORIGUAL = 259;
    protected static final short DISTINTO = 260;
    protected static final short ENTERO = 261;
    protected static final short FLOTANTE = 262;
    protected static final short HEXA = 263;
    protected static final short CADENA = 264;

    private static void setId(Token t){
        String lexema = t.getLexema().toString();
        switch(lexema) {
            case ">=":
                t.setId(MAYORIGUAL);
                break;
            case "<=":
                t.setId(MENORIGUAL);
                break;
            case ":=":
                t.setId(ASIGNACION);
                break;
            case "!=":
                t.setId(DISTINTO);
                break;
            //hay que ver el caso de las cadenas y los identificadore. Porque van a llegar Strings de la misma manera
            //Habria que hacer una AS distinta para generar el Token de las cadenas
        }

    }

    public abstract void ejecutar(Token t, Character c, Reader entrada) throws IOException;

    static class generarASCII extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada) {

        }
    }

    static class ignorar extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada) {
            if (c.equals('\n')){
                AnalizadorLexico.sumarLinea();
            }
        }
    }

    static class concatenar extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada) {
            t.agregarCaracter(c);
        }
    }

    static class resetear extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada) throws IOException {
            t.borrarUltimoCaracter();
            entrada.reset();
        }
    }

    static class generarToken extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada){
            t.setLinea(AnalizadorLexico.lineaAct);
            setId(t);
        }
    }

    static class error extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada){

        }
    }

    static class chequeoEntero extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada){
            int valueInt = Integer.parseInt(t.getLexema().toString());
            if ((0 <= valueInt) && (valueInt < 256)){
                t.setId(ENTERO);
                //falta resetear
            }
        }
    }

    static class chequeoFlotante extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada){
            String flotante = t.getLexema().toString().replace('D', 'e').replace('d','e');
            double valueFloat = Double.parseDouble(flotante);
            if ((valueFloat >= 1.17549435e-38) && (valueFloat <= 3.40282347e+38)){
                t.setId(FLOTANTE);
                //falta resetear
            }
        }
    }
}
