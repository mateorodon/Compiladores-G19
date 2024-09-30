package compi.g19.a.AnalisisLexico;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.Reader;

import static compi.g19.a.AnalisisLexico.AnalizadorLexico.lineaAct;

public abstract class AccionSemantica {

    public static Token token = new Token();

    protected static final int TAMANIO_VAR = 15;
    protected static final short ID = 256;
    protected static final short ASIGNACION = 257;
    protected static final short MAYORIGUAL = 258;
    protected static final short MENORIGUAL = 259;
    protected static final short DISTINTO = 260;
    protected static final short CONSTANTE = 261;
    protected static final short CADENA = 264;

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


    //LISTO
    static class generarASCII extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            //SE LLAMA CUANDO VIENEN LOS LITERALES SOLOS, O CUANDO YA SE CONCATENO EL PRIMER CHAR DE LOS CASOS DE '!=', '>=', ETC.
            //  POR ESO, HAY QUE VER SI LEXEMA ESTA VACIO, SI ESTA VACIO LE SETEAMOS 'c' COMO LEXEMA, SI NO SETEAMOS 'lexema'
            //Ejemplo 1: Estoy en e0 y viene un '+'. Ejecuto esta AS y seteo 'c' como lexema.
            //Ejemplo 2: Estoy en e2 ('lexema' ya tiene '!', '>', '<', ':') y viene algo que no es '='. Ejecuto esta AS y seteo 'lexema' como lexema y despues voy a resetaer.


            //CHEQUEAR SI 'c' PERTENECE AL LENGUAJE, SI NO PERTENECE LANZA ERROR LEXICO: CARACTER NO CONOCIDO
            //PERTENECEN: '*', =', '}', '#', '+', '-', '/', ';', '(', ')', '.', '='

            if (!perteneceAlLenguaje(c))
                AnalizadorLexico.agregarErrorLexico("El character "+c+" no pertenece al lenguaje" );


            token = new Token();
            int ascii = (int) c;
            token.setId((short) ascii);

            if (lexema.isEmpty())
                lexema.append(c);

            token.setLexema(lexema);
        }
    }

    //LISTO
    static class comentario extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            System.out.println("SE RECONOCIO UN COMENTARIO EN LA LINEA "+lineaAct);
        }
    }

    static class ignorar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            //if (!perteneceAlLenguaje(c))
                //AnalizadorLexico.agregarErrorLexico("El character "+c+" no pertenece al lenguaje" );
            if (c.equals('\n')){
                AnalizadorLexico.sumarLinea();
            }
        }
    }

    //LISTO
    static class concatenar extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            if (perteneceAlLenguaje(c))
                lexema.append(c);
            else
                AnalizadorLexico.agregarErrorLexico("El character "+c+" no pertenece al lenguaje" );


            if (c.equals('\n') || c.equals('\r'))
                AnalizadorLexico.agregarErrorLexico("Las cadenas deben ser de una unica linea");
        }
    }

    //LISTO
    static class resetear extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
            entrada.reset();
        }
    }

    //LISTO
    static class compararOAsignar extends AccionSemantica { //VER CUANDO VAMOS A USAR ESTO, CAPAZ NI ES NECESARIO
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada){
            //PRIMERO YA CONCATENE, AHORA TENGO QUE CHEQUEAR CUAL DE LOS SIGUIENTES ES: '!=', '>=', '<=', ':='
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

    //LISTO
    static class chequeoHexa extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
            entrada.reset();
            StringBuilder valorEntero = new StringBuilder(); // Inicializamos el StringBuilder
            int index = 0;

            // Chequeamos que 'lexema' no tenga caracteres inválidos
            for (char caracter : lexema.toString().toCharArray()) {
                if (!((caracter >= '0' && caracter <= '9') || (caracter >= 'A' && caracter <= 'F'))) {
                    AnalizadorLexico.agregarErrorSintactico("Las constantes hexadecimales no pueden contener caracteres inválidos: " + caracter);
                    lexema.deleteCharAt(index); // Eliminar carácter inválido
                } else {
                    index++; // Solo incrementamos el índice si el carácter es válido
                }
            }

            // Intentamos parsear a entero
            Integer parseado=0;
            try {
                parseado = Integer.parseInt(lexema.toString(), 16); // Usamos base 16 para parsear hexadecimales
            } catch (NumberFormatException e) {
                AnalizadorLexico.agregarErrorLexico("La constante hexadecimal no se pudo parsear correctamente");
            }

            valorEntero.append(parseado.toString());

            // Creamos una instancia de chequeoEntero y ejecutamos su método
            AccionSemantica chequeoEntero = new chequeoEntero();
            chequeoEntero.ejecutar(valorEntero, c, entrada); // Pasamos valorEntero como lexema
        }
    }

    //LISTO
    static class chequeoEntero extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            //CHEQUEAR EL RANGO DEL LEXEMA -> ERROR LEXICO CONSTANTE ENTERA FUERA DE RANGO
            //GENERAR TOKEN CON ID = Constante.
            // AGREGAR A LA TS.

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
            } else if (valueLong > Math.pow(2,31)-1) {
                AnalizadorLexico.agregarErrorLexico("Constante entera fuera de rango");
                newLexema = String.valueOf(Math.pow(2,31)-1);
                lexema.setLength(0);
                lexema.append(newLexema);
                token.setLexema(lexema);
            }else {
                token.setLexema(lexema);
            }

            token.setId(CONSTANTE);
            if ( ! TablaSimbolos.existeSimbolo(token.getLexema().toString()) ){
                TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            }
        }
    }

    //LISTO
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
                if (lexema.charAt(0)=='_')
                    AnalizadorLexico.agregarErrorLexico("Cadena mal definida, no puede comenzar con \"_\"");

                if (lexema.length() > TAMANIO_VAR) {

                    AnalizadorLexico.agregarWarning("Warning: El ID excedio el tamanio permitido");

                    //Haciendo asi usamos siempre el mismo lexema, si creamos uno nuevo, no corta la ejecucion del programa
                    //lexema = new StringBuilder(lexema.substring(0, TAMANIO_VAR));
                    String newLexema = lexema.substring(0, TAMANIO_VAR);
                    lexema.setLength(0);
                    lexema.append(newLexema);

                    token.setLexema(lexema);
                } else {
                    token.setLexema(lexema);
                }

                token.setId(ID);

                if ( ! TablaSimbolos.existeSimbolo(token.getLexema().toString()) ){
                    TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
                } else {
                    TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
                }
            }

        }
    }

    //LISTO
    static class chequeoFlotante extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token = new Token();
            try {
                String[] partes = lexema.toString().split("s");

                float base = 0;
                float exponente = 0;

                if (partes.length > 1) {
                    exponente = Float.parseFloat(partes[1]);
                } else {
                    AnalizadorLexico.agregarWarning("Parte exponencial del flotante ausente");
                }

                String[] partesNoExponenciales = lexema.toString().split("\\.");

                if (partesNoExponenciales[0].isEmpty()) {
                    AnalizadorLexico.agregarWarning("Parte entera del flotante ausente");
                }

                if (partesNoExponenciales[1].isEmpty()) {
                    AnalizadorLexico.agregarWarning("Parte decimal del flotante ausente");
                }

                try {
                    base = Float.parseFloat(partes[0]);
                }catch (Exception e){
                    AnalizadorLexico.agregarWarning("Parte entera del flotante ausente");
                }

                float resultado = base;
                if (exponente != 0.0)
                     resultado = (float) Math.pow(base, exponente);

                if (resultado > Float.MAX_VALUE) {
                    AnalizadorLexico.agregarErrorLexico("Constante flotante fuera de rango");
                    resultado = Float.MAX_VALUE;
                }
                lexema.setLength(0);
                lexema.append(resultado);

                token.setLexema(lexema);

                token.setId(CONSTANTE);
                if ( ! TablaSimbolos.existeSimbolo(token.getLexema().toString()) ){
                    TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
                } else {
                    TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                // Si ocurre un error (como un formato no válido o falta de "s"), manejamos el error
                AnalizadorLexico.agregarErrorLexico("Constante flotante mal deifinida");
                lexema.setLength(0);
                lexema.append("0.0");
                token.setId(CONSTANTE);
                token.setLexema(lexema); // Asignamos un valor por defecto en caso de error
            }

        }
    }

    //LISTO
    static class cadena extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token.setId(CADENA);
            token.setLexema(lexema);

            if (!TablaSimbolos.existeSimbolo(token.getLexema().toString())) {
                TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            }
        }
    }

    private static boolean perteneceAlLenguaje(Character c) {
        return c == '+' || c == '-' || c == '*' || c == '/' ||
                c == '>' || c == '<' || c == '=' || c == '(' ||
                c == ')' || c == ',' || c == '.' || c == ';' ||
                Character.isLetter(c) || Character.isDigit(c);
    }
}
