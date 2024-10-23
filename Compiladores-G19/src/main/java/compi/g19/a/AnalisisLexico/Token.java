package compi.g19.a.AnalisisLexico;

import lombok.Data;

import static compi.g19.a.AnalisisLexico.AnalizadorLexico.lineaAct;
import static compi.g19.a.AnalisisLexico.PalabrasReservadas.palabrasReservadas;

@Data
public class Token {
    private int id;
    private StringBuilder lexema;
    private Integer linea;
    private String tipo;
    private String uso;

    public Token() {
        this.id = 0;
        this.lexema = new StringBuilder();
        this.linea = lineaAct;
    }

    public Token(Token t){
        this.id = t.getId();
        this.lexema = new StringBuilder(t.getLexema());
        this.linea = t.getLinea();
        this.tipo = t.getTipo();
    }

    public Token(int id, StringBuilder lexema, Integer linea) {
        this.id = id;
        this.lexema = lexema;
        this.linea = linea;
    }

    public Integer esPR(StringBuilder lexema){
        return palabrasReservadas.get(lexema.toString().toLowerCase());
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", lexema=" + lexema +
                ", linea=" + linea +
                ", tipo=" + tipo +
                '}';
    }

}
