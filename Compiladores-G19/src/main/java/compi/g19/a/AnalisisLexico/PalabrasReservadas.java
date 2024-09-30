package compi.g19.a.AnalisisLexico;

import java.util.HashMap;

public class PalabrasReservadas {

    public static final HashMap<String, Integer> palabrasReservadas = new HashMap<>();
    static {
        palabrasReservadas.put("if", 265);
        palabrasReservadas.put("then", 266);
        palabrasReservadas.put("else", 267);
        palabrasReservadas.put("begin", 268);
        palabrasReservadas.put("end", 269);
        palabrasReservadas.put("end_if", 270);
        palabrasReservadas.put("outf", 271);
        palabrasReservadas.put("typedef", 272);
        palabrasReservadas.put("fun", 273);
        palabrasReservadas.put("ret", 274);
        palabrasReservadas.put("ulongint", 275);
        palabrasReservadas.put("single", 276);
        palabrasReservadas.put("for", 277);
        palabrasReservadas.put("or", 281);
        palabrasReservadas.put("up", 278);
        palabrasReservadas.put("down", 279);
        palabrasReservadas.put("triple", 280);
    }

    public Integer getId(String lexema){
        return palabrasReservadas.get(lexema);
    }
}
