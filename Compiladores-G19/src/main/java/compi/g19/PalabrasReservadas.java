package compi.g19;

import java.util.HashMap;

public class PalabrasReservadas {

    public static final HashMap<String, Short> palabrasReservadas = new HashMap<>();
    static {
        palabrasReservadas.put("if", (short) 265);
        palabrasReservadas.put("then", (short) 266);
        palabrasReservadas.put("else", (short) 267);
        palabrasReservadas.put("begin", (short) 268);
        palabrasReservadas.put("end", (short) 269);
        palabrasReservadas.put("end_if", (short) 270);
        palabrasReservadas.put("outf", (short) 271);
        palabrasReservadas.put("typedef", (short) 272);
        palabrasReservadas.put("fun", (short) 273);
        palabrasReservadas.put("ret", (short) 274);
        palabrasReservadas.put("ulongint", (short) 275);
        palabrasReservadas.put("single", (short) 276);
        palabrasReservadas.put("for", (short) 277);
        palabrasReservadas.put("up", (short) 278);
        palabrasReservadas.put("down", (short) 279);
        palabrasReservadas.put("triple", (short) 280);
    }

    public Short getId(String lexema){
        return palabrasReservadas.get(lexema);
    }
}
