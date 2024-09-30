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

    private static void setId(StringBuilder lexema){
        if (lexema.charAt(0) == '{') {
            token.setId(CADENA);
            lexema.deleteCharAt(0);
            if (!TablaSimbolos.existeSimbolo(token.getLexema().toString())) {
                TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            }
        }
        else if (lexema.charAt(0) == 'u' ||lexema.charAt(0) == 'v' ||lexema.charAt(0) == 'w') {
                token.setId(ULONGINT);
                if ( ! TablaSimbolos.existeSimbolo(token.getLexema().toString()) ){
                    TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
                } else {
                    TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
                }
        } else if (lexema.charAt(0) == 's'){
            token.setId(FLOTANTE);
            if ( ! TablaSimbolos.existeSimbolo(token.getLexema().toString()) ){
                TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            }
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
            //SE LLAMA CUANDO VIENEN LOS LITERALES SOLOS, O CUANDO YA SE CONCATENO EL PRIMER CHAR DE LOS CASOS DE '!=', '>=', ETC.
            //  POR ESO, HAY QUE VER SI LEXEMA ESTA VACIO, SI ESTA VACIO LE SETEAMOS 'c' COMO LEXEMA, SI NO SETEAMOS 'lexema'
            //Ejemplo 1: Estoy en e0 y viene un '+'. Ejecuto esta AS y seteo 'c' como lexema.
            //Ejemplo 2: Estoy en e2 ('lexema' ya tiene '!', '>', '<', ':') y viene algo que no es '='. Ejecuto esta AS y seteo 'lexema' como lexema y despues voy a resetaer.


            //CHEQUEAR SI 'c' PERTENECE AL LENGUAJE, SI NO PERTENECE LANZA ERROR LEXICO: CARACTER NO CONOCIDO
            //PERTENECEN: '*', =', '}', '#', '+', '-', '/', ';', '(', ')', '.', '='
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
            ////TAMBIEN TIENE QUE CHEQUEAR SI PERTENECE AL LENGUAJE, SI NO PERTENECE LANZA ERROR LEXICO(es por los comentarios)
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
            System.out.println("ERRORRRRRRRRR");
            String erroLexema = "ERROR";
            lexema.setLength(0);
            lexema.append(erroLexema);
            token.setLexema(lexema);
            entrada.reset();

        }
    }
    static class chequeoHexa extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) throws IOException {
                entrada.reset();
                StringBuilder valorEntero = null;
                //DEBEMOS CHEQUEAR QUE 'lexema' NO TENGA CARACTERES INVALIDOS (solo entre A-F o digitos son validos)
                //LANZAMOS ERROR SINTACTICO EN CASO DE Q LOS TENGA, LOS ELIMINAMOS.
                //PARSEAMOS A ENTERO PARA CHEQUEAR EL RANGO


                AccionSemantica chequeoEntero = new chequeoEntero();
                chequeoEntero.ejecutar(valorEntero,c,entrada);
        }
    }

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

            if ( ! TablaSimbolos.existeSimbolo(token.getLexema().toString()) ){
                TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            }
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
            }

            if ( ! TablaSimbolos.existeSimbolo(token.getLexema().toString()) ){
                TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            }
        }
    }

    static class chequeoFlotante extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            token = new Token();
            try {
                String[] partes = lexema.toString().split("s");

                float base = 0;
                float exponente = 0;

                try {
                    base = Float.parseFloat(partes[0]);
                }catch (Exception e){
                    AnalizadorLexico.agregarWarning("Parte entera del flotante ausente");
                }

                if (partes.length > 1) {
                    exponente = Float.parseFloat(partes[1]);
                } else {
                    AnalizadorLexico.agregarWarning("Parte decimal del flotante ausente");
                }

                float resultado = (float) Math.pow(base, exponente);
                if (resultado > Float.MAX_VALUE) {
                    AnalizadorLexico.agregarErrorLexico("Constante flotante fuera de rango");
                    resultado = Float.MAX_VALUE;
                }
                lexema.setLength(0);
                lexema.append(resultado);

                token.setLexema(lexema);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                // Si ocurre un error (como un formato no válido o falta de "s"), manejamos el error
                AnalizadorLexico.agregarErrorLexico("Constante flotante mal deifinida");
                lexema.setLength(0);
                lexema.append("0.0");
                token.setLexema(lexema); // Asignamos un valor por defecto en caso de error
            }
            token.setId(FLOTANTE);
            if ( ! TablaSimbolos.existeSimbolo(token.getLexema().toString()) ){
                TablaSimbolos.addNuevoSimbolo(token.getLexema().toString(), new Token(token));
            } else {
                TablaSimbolos.addSimbolo(token.getLexema().toString(), new Token(token));
            }
        }
    }

    static class errorFlotanteDecimal extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            lexema.append(c);
            AnalizadorLexico.agregarErrorLexico("Constante flotante mal definida. Parte decimal esta ausente");
        }
    }

    static class errorFlotanteEntera extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            lexema.append(c);
            if (lexema.charAt(0)=='.')
                AnalizadorLexico.agregarErrorLexico("Constante flotante mal definida. Parte entera esta ausente");
        }
    }

    static class errorIdentificador extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            lexema.append(c);
            if (lexema.charAt(0)=='_'){ //ESTO SE EJECUTA UNICAMENTE CON '_'. AL PEDO PREGUNTAR.
                                        //HABRIA QUE CONCATENAR Y CUANDO SE RECONOCE UN IDENTIFICADOR CHEQUEAR SI INICIA CON '_'.
                AnalizadorLexico.agregarErrorLexico("El identificador no puede comenzar con \"_\"");
                lexema.deleteCharAt(0);
            }

        }
    }

    static class errorCadena extends AccionSemantica {
        @Override
        public void ejecutar(StringBuilder lexema, Character c, Reader entrada) {
            if ((c.equals('\r') || c.equals('\n')))
                lexema.append(c);
            if (lexema.charAt(lexema.length()-1)!='}'){
                AnalizadorLexico.agregarErrorLexico("La cadena debe finalizar con \"}\"");
                setId(lexema);
            }

        }
    }
}
