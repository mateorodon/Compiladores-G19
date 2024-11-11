package compi.g19.AnalisisLexico;

import java.util.HashMap;

public class PalabrasReservadas {

    public static final HashMap<String, Integer> palabrasReservadas = new HashMap<>();
    static {
        palabrasReservadas.put("if", 264);
        palabrasReservadas.put("then", 265);
        palabrasReservadas.put("else", 266);
        palabrasReservadas.put("begin", 267);
        palabrasReservadas.put("end", 268);
        palabrasReservadas.put("end_if", 269);
        palabrasReservadas.put("outf", 270);
        palabrasReservadas.put("typedef", 271);
        palabrasReservadas.put("fun", 272);
        palabrasReservadas.put("ret", 273);
        palabrasReservadas.put("ulongint", 274);
        palabrasReservadas.put("single", 275);
        palabrasReservadas.put("for", 276);
        palabrasReservadas.put("or", 277);
        palabrasReservadas.put("up", 278);
        palabrasReservadas.put("down", 279);
        palabrasReservadas.put("triple", 280);
    }
}
