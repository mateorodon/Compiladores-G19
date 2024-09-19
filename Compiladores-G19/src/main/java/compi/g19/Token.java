package compi.g19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static compi.g19.PalabrasReservadas.palabrasReservadas;

@Data
public class Token {
    private int id;
    private StringBuilder lexema;
    private Integer linea;

    public Token() {
        this.id = 0;
        this.lexema = new StringBuilder();
        this.linea = 0;
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

    public Short esPR(){
        return palabrasReservadas.get(this.lexema.toString().toLowerCase());
    }

}
