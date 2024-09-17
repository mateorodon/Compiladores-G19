package compi.g19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Token {
    private int id;
    private StringBuilder lexema;
    private Integer linea;

    public void resetLexema(){
        this.lexema;
    }

    public void borrarUltimoCaracter(){
        lexema.deleteCharAt(lexema.length() - 1);
    }

    public void agregarCaracter(char c){
        lexema.append(c);
    }

}
