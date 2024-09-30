package compi.g19.a.AnalisisLexico;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static compi.g19.a.AnalisisLexico.AccionSemantica.token;


@Getter
@Setter
public class AnalizadorLexico {
    private BufferedReader entrada;
    private int estadoAct;
    public static int lineaAct = 1;
    private int[][] matrizEstados = GeneradorMatriz.matrizEstados;
    private AccionSemantica[][] matrizAS = GeneradorMatriz.matrizAS;
    static List<Error> warning = new ArrayList<Error>();
    static List<Error> errorSintactico = new ArrayList<Error>();
    static List<Error> errorLexico = new ArrayList<Error>();

    public AnalizadorLexico(BufferedReader entrada) {
        this.entrada = entrada;
        this.estadoAct = 0; // Estado inicial
    }

    public static void agregarWarning(String error){
        Error e = new Error(error, lineaAct);
        warning.add(e);
    }

    public static void imprimirErrores(){
        for (Error e : errorLexico)
            System.out.println(e.toString());
    }

    public static void imprimirWarnings(){
        for (Error e : warning)
            System.out.println(e.toString());
    }

    public static void agregarErrorSintactico(String error){
        Error e = new Error(error, lineaAct);
        errorSintactico.add(e);
    }

    public static void agregarErrorLexico(String error){
        Error e = new Error(error, lineaAct);
        errorLexico.add(e);
    }

    public Token obtenerToken() throws IOException {

        StringBuilder lexemaBuilder = new StringBuilder();
        int valorLeido;
        int val = 0;
        entrada.mark(1);
        //Token token = new Token();
        while (estadoAct != -1 && val != 100 && (valorLeido = entrada.read()) != -1) {
            Character caracter = (char) valorLeido;

            int valorCaracter = getCaracter(Character.toLowerCase(caracter));
            matrizAS[estadoAct][valorCaracter].ejecutar(lexemaBuilder, caracter, entrada);

            estadoAct = matrizEstados[estadoAct][valorCaracter];

            entrada.mark(1);

            if (estadoAct == 0) {
                val = 100;
            }

            //Si es un espacio en blanco no generamos token
            //Paso el LEXEMA porque si paso solo el token me seguiria concatenando con el siguiente TOKEN en caso de venir un caracter especial, ya que no cortaria la ejecucion
            if (caracterEspecial(lexemaBuilder)){
                val=0;
            }
        }

        Token returnToken = new Token(token);

        lexemaBuilder.setLength(0);

        //Llegaria aca con LEXEMA vacio en caso de llegar al fin del archivo.
        return (returnToken.getLexema().isEmpty()) ? null : returnToken;
    }

    private static char mapCaracter(char c) {
        if (Character.isDigit(c) && c != '0') {
            return 'd'; // Devuelve 'd' si es un dígito excepto '0'
        }

        if (Character.isLetter(c) && c!='s' && c!='x') {
            return 'l'; // Devuelve 'L' si está entre A - F
        }
        return c; // Devuelve el carácter propio en otro caso
    }

    private static int getCaracter(char c) {
        return switch (mapCaracter(c)) {
            case 'l' -> 0;
            case 'd' -> 1;
            case '0' -> 2;
            case '_' -> 3;
            case '/' -> 4;
            case '*' -> 5;
            case '{' -> 6;
            case '!' -> 7;
            case '<' -> 8;
            case '>' -> 9;
            case ':' -> 10;
            case '=' -> 11;
            case '.' -> 12;
            case '}' -> 13;
            case '#' -> 14;
            case '+' -> 15;
            case '-' -> 16;
            case 's' -> 17;
            case 'x' -> 18;
            case '\n' -> 19;
            case '\r' -> 19;
            case '\t' -> 19;
            case ' ' -> 19;
            default -> 20;
        };
    };

    public static boolean caracterEspecial(StringBuilder c) {
        String caracterComoString = String.valueOf(c);
        return ((caracterComoString.equals("\n") || caracterComoString.equals("\t")
                || caracterComoString.isEmpty() || caracterComoString.equals("\r") || caracterComoString.isBlank()));


    }

    public static void sumarLinea(){
        lineaAct++;
    }
}
