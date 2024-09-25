package compi.g19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static compi.g19.AnalizadorLexico.lineaAct;
import static compi.g19.PalabrasReservadas.palabrasReservadas;

@Data
public class Token {
    private int id;
    private StringBuilder lexema;
    private Integer linea;

    public Token() {
        this.id = 0;
        this.lexema = new StringBuilder();
        this.linea = lineaAct;
    }

    public Token(Token t){
        this.id = t.getId();
        this.lexema = new StringBuilder(t.getLexema());
        this.linea = t.getLinea();
    }

    public void resetLexema(){
        this.lexema.setLength(0);
    }

    public void borrarUltimoCaracter(){
        lexema.deleteCharAt(lexema.length() - 1);
    }

    public void agregarCaracter(char c){
        lexema.append(c);
    }

    public Integer esPR(StringBuilder lexema){
        return palabrasReservadas.get(lexema.toString().toLowerCase());
    }

    @Override
    public String toString() {
        return "Token{" +
                mapId(this.id) +
                ", lexema=" + lexema +
                ", linea=" + linea +
                '}';
    }

    private String mapId(int id) {
        switch(id) {
            case AccionSemantica.ID -> { return "Identificador"; }
            case AccionSemantica.ASIGNACION -> { return "Asignación"; }
            case AccionSemantica.ULONGINT-> { return "Constante entera";}
            case AccionSemantica.FLOTANTE -> { return "Constante flotante";}
            case AccionSemantica.HEXA -> {return "Constante hexadecimal";}
            case AccionSemantica.CADENA -> {return "Cadena una línea";}
            case AccionSemantica.DISTINTO -> {return "Distinto";}
            case AccionSemantica.MAYORIGUAL -> {return "Mayor o igual";}
            case AccionSemantica.MENORIGUAL -> {return "Menor o igual";}
            default -> {
                if (id >= 265 && id <= 280) {
                    return "Palabra reservada";
                }
                else {
                    return "Literal";
                }
            }
        }
    }
}
