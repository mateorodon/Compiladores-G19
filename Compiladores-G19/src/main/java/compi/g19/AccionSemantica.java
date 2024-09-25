package compi.g19;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.Reader;

import static compi.g19.AnalizadorLexico.caracterEspecial;
import static compi.g19.AnalizadorLexico.lineaAct;

public abstract class AccionSemantica {

    public static Token token = new Token();

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

    private static void setId(StringBuilder lexema){
        if (lexema.charAt(0) == '{') {
            token.setId(CADENA);
            lexema.deleteCharAt(0);
        }
        else {
            switch (lexema.toString()) {
                case ">=":
                    token.setId(MAYORIGUAL);
                    break;
                case "<=":
                    token.setId(MENORIGUAL);
                    break;
                case ":=":
                    token.setId(ASIGNACION);
                    break;
                case "!=":
                    token.setId(DISTINTO);
                    break;
                    //hay que ver el caso de las cadenas y los identificadore. Porque van a llegar Strings de la misma manera
                    //Habria que hacer una AS distinta para generar el Token de las cadenas
            }
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

    static class generarToken extends AccionSemantica { //VER CUANDO VAMOS A USAR ESTO, CAPAZ NI ES NECESARIO
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada){
            //token = new Token();
            //LAS CADENAS DEL ESTILO {CADENA} SOLO CONCATENAN LLEGAN ACA CON LEXEMA = "CADENA",
            // HABRIA QUE HACER UN AS QUE SEA reconocerCadena() O ALGO ASI
            token.setLexema(lexema);
            setId(lexema); //SOLO SE USA EN generarToken()
            token.setLinea(lineaAct);
        }
    }

    static class error extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
            System.out.println("ERRORRRRRRRRR");
            entrada.reset();

        }
    }

    static class chequeoEntero extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token = new Token();
            long valueLong;
            if( lexema.length() > 1 && lexema.charAt(1)=='x'){
                valueLong = Long.parseLong(lexema.substring(2,lexema.length()-1), 16);
                token.setId(HEXA);
            }else{
                valueLong = Long.parseLong(lexema.toString());
                token.setId(ULONGINT);
            }
            if (valueLong < 0) {
                token.setLexema(new StringBuilder("0"));
            } else if (valueLong > Math.pow(2,31)-1) {
                token.setLexema(new StringBuilder(String.valueOf((Math.pow(2,31)-1))));
            }else {
                token.setLexema(lexema);
            }
        }
    }




    static class truncar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada){
            token = new Token();
            Integer idPR = token.esPR(lexema);
            if (idPR != null){
                token.setId(idPR);
                token.setLexema(lexema);
            }
            else {
                if (lexema.length() > TAMANIO_VAR) {
                    //ADD WARNING = ID MAYOR A 20 CARACTERES
                    lexema = new StringBuilder(lexema.substring(0, TAMANIO_VAR));
                    token.setLexema(lexema);
                } else {
                    token.setLexema(lexema);
                }
                token.setId(ID);
            }
        }
    }

    static class chequeoFlotante extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token = new Token();
            try {
                String[] partes = lexema.toString().split("s");

                float base = Float.parseFloat(partes[0]);

                float exponente = 0;
                if (partes.length > 1) {
                    exponente = Float.parseFloat(partes[1]);
                }

                float resultado = (float) Math.pow(base, exponente);
                if (resultado > Float.MAX_VALUE)
                    resultado = Float.MAX_VALUE;
                lexema.setLength(0);
                lexema.append(resultado);

                token.setLexema(lexema);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                // Si ocurre un error (como un formato no válido o falta de "s"), manejamos el error
                lexema.setLength(0);
                lexema.append("0.0");
                token.setLexema(lexema); // Asignamos un valor por defecto en caso de error
            }
            token.setId(FLOTANTE);
        }
    }

}
