package compi.g19;

import lombok.AllArgsConstructor;

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

    @AllArgsConstructor
    static class compuesta extends AccionSemantica {

        private AccionSemantica a1;
        private AccionSemantica a2;

        @Override
        public void ejecutar(Token t, Character c, Reader entrada) throws IOException {
            a1.ejecutar(t, c, entrada);
            a2.ejecutar(t, c, entrada);
        }
    }

    @AllArgsConstructor
    static class compuestaTriple extends AccionSemantica {

        private AccionSemantica a1;
        private AccionSemantica a2;
        private AccionSemantica a3;

        @Override
        public void ejecutar(Token t, Character c, Reader entrada) throws IOException {
            a1.ejecutar(t, c, entrada);
            a2.ejecutar(t, c, entrada);
            a3.ejecutar(t, c, entrada);
        }
    }



    static class generarASCII extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada) {

        }
    }

    static class comentario extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada) {
            System.out.println("SE RECONOCIO UN COMENTARIO");
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
            //t.borrarUltimoCaracter();
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
            if (0 > valueInt)  {
                t.setLexema(new StringBuilder(String.valueOf(0)));
            }
            if (valueInt > 256){
                t.setLexema(new StringBuilder(String.valueOf(256)));
            }
            t.setId(ENTERO);
        }
    }

    //falta ver si es PR
    static class truncar extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada){
            if (t.getLexema().length()>TAMANIO_VAR){
                t.setLexema(new StringBuilder(t.getLexema().substring(0, TAMANIO_VAR)));
                t.setId(ID);
            }
        }
    }

    static class chequeoFlotante extends AccionSemantica {
        @Override
        public void ejecutar(Token t, Character c, Reader entrada){
            String flotante = t.getLexema().toString().replace('D', 'e').replace('d','e');
            double valueFloat = Double.parseDouble(flotante);
            if (valueFloat < 1.17549435e-38) {
                //FUERA DE RANGO, LE ASIGNO VALOR VALIDO
                t.setLexema(new StringBuilder(String.valueOf(1.17549435e-38).replace('e','s')));
            }
            if (valueFloat > 3.40282347e+38 ){
                t.setLexema(new StringBuilder(String.valueOf(3.40282347e+38).replace('e','s')));
            }
            t.setId(FLOTANTE);
        }
    }
}
