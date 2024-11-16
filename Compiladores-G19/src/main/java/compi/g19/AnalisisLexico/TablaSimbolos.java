package compi.g19.AnalisisLexico;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class TablaSimbolos {

    /*
    A la tabla de simbolos se deben agregar
        - Identificadores
        - Constantes enteras y flotantes
        - Cadenas
     */

    @Getter
    private static Map<String, Token> simbolos = new HashMap<>(); // <Lexema, Token>

    public static void addSimbolo(String lexema,Token t){
        simbolos.put(lexema,t);
    }

    public static void addNuevoSimbolo(String lexema, Token t){
        Token nuevo = new Token(t);
        simbolos.put(lexema, nuevo);
    }
    public static boolean existeSimbolo(String lexema) {
        return simbolos.containsKey(lexema);
    }

    public static void imprimirSimbolos() {
        for (String key : simbolos.keySet()) {
            Token token = simbolos.get(key);
            System.out.println(token.toString());
        }
    }

    public static Token getToken(String lexema){
        return simbolos.get(lexema);
    }

    public static void removeToken (String lexema){
        simbolos.remove(lexema);
    }

}
