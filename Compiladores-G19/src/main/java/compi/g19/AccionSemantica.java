package compi.g19;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.Reader;

import static compi.g19.AnalizadorLexico.caracterEspecial;
import static compi.g19.AnalizadorLexico.lineaAct;

public abstract class AccionSemantica {

    public static Token token;
    protected static final int TAMANIO_VAR = 15;
    protected static final short ID = 256;
    protected static final short ASIGNACION = 257;
    protected static final short MAYORIGUAL = 258;
    protected static final short MENORIGUAL = 259;
    protected static final short DISTINTO = 260;
    protected static final short ULONGINT = 261;
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

    public abstract void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException;

    @AllArgsConstructor
    static class compuesta extends AccionSemantica {

        private AccionSemantica a1;
        private AccionSemantica a2;

        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
            a1.ejecutar(lexema, c, entrada);
            a2.ejecutar(lexema, c, entrada);
        }
    }

    @AllArgsConstructor
    static class compuestaTriple extends AccionSemantica {

        private AccionSemantica a1;
        private AccionSemantica a2;
        private AccionSemantica a3;

        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
            a1.ejecutar(lexema, c, entrada);
            a2.ejecutar(lexema, c, entrada);
            a3.ejecutar(lexema, c, entrada);
        }
    }



    static class generarASCII extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token = new Token();
            int ascii = (int) c;
            token.setId((short) ascii);
            token.setLexema(lexema);
        }
    }

    static class comentario extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            System.out.println("SE RECONOCIO UN COMENTARIO");
        }
    }

    static class ignorar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            if (c.equals('\n')){
                AnalizadorLexico.sumarLinea();
            }
        }
    }

    static class concatenar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            lexema.append(c);
        }
    }

    static class resetear extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
            /*if (caracterEspecial(c)){
                t.borrarUltimoCaracter();
            }*/
            entrada.reset();
        }
    }

    static class generarToken extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada){
            //token = new Token();
            setId(token);
            token.setLexema(lexema);
        }
    }

    static class error extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada){

        }
    }

    static class chequeoEntero extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token = new Token();
            long valueLong = Long.parseLong(lexema.toString());
            if (valueLong < 0) {
                token.setLexema(new StringBuilder("0"));
            } else if (valueLong > 231) {
                token.setLexema(new StringBuilder("231"));
            }
            token.setId(ULONGINT);
        }
    }


    static class truncar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada){
            token = new Token();
            Short idPR = token.esPR(lexema);
            if (idPR != null){
                token.setId(idPR);
                token.setLexema(lexema);
            }
            else {
                if (lexema.length() > TAMANIO_VAR) {
                    //ADD WARNING = ID MAYOR A 20 CARACTERES
                    token.setLexema(new StringBuilder(lexema.substring(0, TAMANIO_VAR)));
                }
                token.setId(ID);
            }
        }
    }

    static class chequeoFlotante extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token = new Token();
            // Valida rango de flotante
            try {
                float valueFloat = Float.parseFloat(lexema.toString());
                token.setLexema(lexema);
            } catch (NumberFormatException e) {
                // Manejar error si el número está fuera del rango permitido
                token.setLexema(new StringBuilder("0.0"));
            }
            token.setId(FLOTANTE);
        }
    }

}
