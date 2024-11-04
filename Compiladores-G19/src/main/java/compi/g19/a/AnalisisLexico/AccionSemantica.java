package compi.g19.a.AnalisisLexico;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.Reader;

import static compi.g19.a.AnalisisLexico.AnalizadorLexico.lineaAct;

public abstract class AccionSemantica {

    public static Token token = new Token();
    protected static final int TAMANIO_VAR = 15;
    protected static final short ID = 257;
    protected static final short ASIGNACION = 258;
    protected static final short MAYORIGUAL = 259;
    protected static final short MENORIGUAL = 260;
    protected static final short DISTINTO = 261;
    protected static final short CONSTANTE = 262;
    protected static final short CADENA = 263;
    private static final String ENTERO = "ulongint";
    private static final String FLOTANTE = "single";
    public static final float SINGLE_POSITIVE_MIN = 1.17549435e-38f;
    public static final float SINGLE_POSITIVE_MAX = 3.40282347e+38f;

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
            //Este IF-ELSE es nuevo para devolver lexema vacio; antes era solo IF
            if (!perteneceAlLenguaje(c) && !AnalizadorLexico.caracterEspecial(c.toString())) {
                AnalizadorLexico.agregarErrorLexico("El caracter " + c + " no pertenece al lenguaje");
                token = new Token();
                token.setLexema(new StringBuilder());
            } else {

            //Caso 1: Estoy en e0 y viene un '+'. Ejecuto esta AS y seteo 'c' como lexema.
            token = new Token();
            if (lexema.length() == 0) {
                int ascii = c;
                token.setId((short) ascii);
                lexema.append(c);
            }
            //Caso 2: Estoy en e2 ('lexema' ya tiene '!', '>', '<', ':') y viene algo que no es '='.
            // Ejecuto esta AS y seteo 'lexema' como lexema y despues voy a resetaer.
            else {
                int ascii = lexema.charAt(0);
                token.setId((short) ascii);
            }
                token.setLexema(lexema);
            }
        }
    }

    static class comentario extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            System.out.println("SE RECONOCIO UN COMENTARIO EN LA LINEA " + lineaAct);
            lexema.setLength(0);
        }
    }

    static class ignorar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            if (!perteneceAlLenguaje(c) && !AnalizadorLexico.caracterEspecial(c.toString()))
                AnalizadorLexico.agregarErrorLexico("El caracter " + c + " no pertenece al lenguaje" );
            if (c.equals('\n')){
                AnalizadorLexico.sumarLinea();
            }
        }
    }

    static class concatenar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            if (!perteneceAlLenguaje(c) && !AnalizadorLexico.caracterEspecial(c.toString()))
                AnalizadorLexico.agregarErrorLexico("El caracter " + c + " no pertenece al lenguaje" );
            else
                lexema.append(c);
            if (c.equals('\n') || c.equals('\r'))
                AnalizadorLexico.agregarErrorLexico("Las cadenas deben ser de una unica linea");
        }
    }

    static class resetear extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
            entrada.reset();
        }
    }

    static class compararOAsignar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada){
            token.setLexema(lexema);
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
            }
            token.setLinea(lineaAct);
        }
    }

    static class error extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
            String errorLexema = "ERROR";
            lexema.setLength(0);
            lexema.append(errorLexema);
            token.setLexema(lexema);
            entrada.reset();
        }
    }

    static class chequeoHexa extends AccionSemantica {

        private AccionSemantica chequeoEntero = new chequeoEntero();

        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
            entrada.reset();
            StringBuilder valorEntero = new StringBuilder(); // Inicializamos el StringBuilder
            int index = 0;

            // Chequeamos que 'lexema' no tenga caracteres inválidos
            for (char caracter : lexema.toString().toCharArray()) {
                if (!((caracter >= '0' && caracter <= '9') || (caracter >= 'A' && caracter <= 'F'))) {
                    if (!(index == 1 && caracter == 'x')) {
                        AnalizadorLexico.agregarErrorLexico("Las constantes hexadecimales no pueden contener caracteres inválidos: " + caracter);
                        lexema.deleteCharAt(index);// Eliminar carácter inválido
                        index++;
                    }
                    else {index++;}
                } else {
                    index++; // Solo incrementamos el índice si el carácter es válido
                }
            }

            // Intentamos parsear a entero
            Long parseado=0L;
            try {
                String lex = lexema.toString();
                if (lex.startsWith("0x")) {
                    lex = lex.substring(2); // Elimina el "0x"
                }
                parseado = Long.parseLong(lex, 16); // Usamos base 16 para parsear hexadecimales

            } catch (NumberFormatException e) {
                AnalizadorLexico.agregarErrorLexico("La constante hexadecimal no se pudo parsear correctamente");
            }

            valorEntero.append(parseado.toString());
            this.chequeoEntero.ejecutar(valorEntero, c, entrada);
        }
    }

    static class chequeoEntero extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {

            token = new Token();
            long valueLong;
            try {
                valueLong = Long.parseLong(lexema.toString());
            }catch (NumberFormatException e){
                valueLong = Long.MAX_VALUE;
            }

            String newLexema;
            if (valueLong < 0) {
                AnalizadorLexico.agregarErrorLexico("Constante entera fuera de rango");
                newLexema = "0";
                lexema.setLength(0);
                lexema.append(newLexema);
                token.setLexema(lexema);
            } else if (valueLong > Math.pow(2,32)-1) {
                AnalizadorLexico.agregarErrorLexico("Constante entera fuera de rango");
                newLexema = String.valueOf(Math.pow(2,32)-1);
                lexema.setLength(0);
                lexema.append(newLexema);
                token.setLexema(lexema);
            }else {
                token.setLexema(lexema);
            }

            token.setId(CONSTANTE);
            token.setTipo(ENTERO);
            if (!TablaSimbolos.existeSimbolo(token.getLexema().toString())) {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                Token t = TablaSimbolos.getToken(token.getLexema().toString());
                TablaSimbolos.addSimbolo(token.getLexema().toString(), t);
            }
        }
    }

    static class chequeoFlotante extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token = new Token();

            float resultado = parsearLexema(lexema.toString());

            if ((resultado != 0f) && ((resultado <= SINGLE_POSITIVE_MIN) || (resultado >= SINGLE_POSITIVE_MAX))) {
                AnalizadorLexico.agregarErrorLexico("Constante flotante fuera de rango");
                resultado = Float.MAX_VALUE;
            }

            lexema.setLength(0);
            lexema.append(resultado);
            token.setLexema(lexema);
            token.setId(CONSTANTE);
            token.setTipo(FLOTANTE);

            if (!TablaSimbolos.existeSimbolo(token.getLexema().toString())) {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                Token t = TablaSimbolos.getToken(token.getLexema().toString());
                TablaSimbolos.addSimbolo(token.getLexema().toString(), t);
            }
        }

        private static float parsearLexema(String lexema) {
            if (lexema.contains("s")) {
                String[] partes = lexema.split("s");

                if (partes.length != 2) {
                    AnalizadorLexico.agregarErrorLexico("Falta el exponente de la constante flotante");
                    return 0f;
                }
                String base = partes[0];
                String exponente = partes[1];

                if (!base.contains(".")) {
                    AnalizadorLexico.agregarErrorLexico("Falta el punto decimal en la base de la constante flotante");
                }

                String[] basePartes = base.split("\\.");
                if (basePartes[0].isEmpty()) {
                    AnalizadorLexico.agregarErrorLexico("Parte entera del flotante ausente");
                    return 0f;
                }
                if (basePartes.length < 2 || basePartes[1].isEmpty()) {
                    AnalizadorLexico.agregarErrorLexico("Parte decimal del flotante ausente");
                    return 0f;
                }

                float baseNumero = Float.parseFloat(base);
                int exponenteNumero = Integer.parseInt(exponente);

                return (float) (baseNumero * Math.pow(10, exponenteNumero));
            } else
                return Float.parseFloat(lexema);
        }
    }

    static class truncar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada){

            //TIENE QUE:
            //1. VER SI ES PR O NO
            //  SI NO ES PR:
            //      1. CHEQUEAR QUE NO ARRANQUE CON '_' -> ERROR LEXICO
            //      2. CHEQUEAR QUE lexema.LENGTH() <= 15 -> WARNING
            //      3. CREAR UN TOKEN CON ID: Identificador
            //      4. AGREGAR A TS SI NO EXISTE, SI NO DEVOLVER PUNTERO A LA TS

            token = new Token();
            Integer idPR = token.esPR(lexema);
            if (idPR != null){
                token.setId(idPR);
                token.setLexema(lexema);
            }
            else {
                int i = 0;
                if (lexema.charAt(i) == '_') {
                    AnalizadorLexico.agregarErrorLexico("Variable mal definida, no puede comenzar con \"_\"");
                    i++;
                }
                if (lexema.charAt(i) == 's' || lexema.charAt(i) == 'S')
                    token.setTipo(FLOTANTE);
                if (lexema.charAt(i) == 'x' || lexema.charAt(i) == 'X' ||
                        lexema.charAt(i) == 'y' || lexema.charAt(i) == 'Y' ||
                        lexema.charAt(i) == 'z' || lexema.charAt(i) == 'Z')
                    token.setTipo(ENTERO);

                if (lexema.length() > TAMANIO_VAR) {
                    String newLexema = lexema.substring(0, TAMANIO_VAR);
                    AnalizadorLexico.agregarWarning("El identificador '" + lexema + "' fue truncado a '" + newLexema + "'" );
                    lexema.setLength(0);
                    lexema.append(newLexema);
                    token.setLexema(lexema);

                } else {
                    token.setLexema(lexema);
                }

                token.setId(ID);

                if ( ! TablaSimbolos.existeSimbolo(token.getLexema().toString()) ){
                    TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
                } else {
                    Token t = TablaSimbolos.getToken(token.getLexema().toString());
                    TablaSimbolos.addSimbolo(token.getLexema().toString(),t);
                }
            }

        }
    }

    static class cadena extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token.setId(CADENA);
            token.setLexema(lexema);

            if (!TablaSimbolos.existeSimbolo(token.getLexema().toString())) {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                Token t = TablaSimbolos.getToken(token.getLexema().toString());
                TablaSimbolos.addSimbolo(token.getLexema().toString(), t);
            }
        }
    }

    private static boolean perteneceAlLenguaje(Character c) {
        return c == '+' || c == '-' || c == '*' || c == '/' ||
                c == '>' || c == '<' || c == '=' || c == '(' ||
                c == ')' || c == ',' || c == '.' || c == ';' ||
                c == '_' || c == '{' || c == '}' || c == '#' ||
                c == ':' || c == '[' || c == ']' ||
                Character.isLetter(c) || Character.isDigit(c);
    }
}
