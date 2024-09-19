package compi.g19;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AnalizadorLexico {
    private BufferedReader entrada;
    private int estadoAct;
    @Getter
    public static int lineaAct = 1;
    private int[][] matrizEstados = GeneradorMatriz.matrizEstados;
    private AccionSemantica[][] matrizAS = GeneradorMatriz.matrizAS;
    static List<Error> erroresLexicos = new ArrayList<Error>();
    static List<Error> erroresSintacticos = new ArrayList<Error>();

    public AnalizadorLexico(BufferedReader entrada) {
        this.entrada = entrada;
        this.estadoAct = 0; // Estado inicial
    }

    public static void agregarErrorLexico(String error){
        Error e = new Error(error, getLineaAct());
        erroresLexicos.add(e);
    }

    public static void agregarErrorSintactico(String error){
        Error e = new Error(error, getLineaAct());
        erroresSintacticos.add(e);
    }

    public Token obtenerToken() throws IOException {

        StringBuilder lexemaBuilder = new StringBuilder();
        int valorLeido;
        int val = 0;
        entrada.mark(1);
        Token token = new Token();

        while (estadoAct != -1 && val != 100 && (valorLeido = entrada.read()) != -1) {
            Character caracter = (char) valorLeido;

            int valorCaracter = getCaracter(Character.toLowerCase(caracter));
            matrizAS[estadoAct][valorCaracter].ejecutar(token, caracter, entrada);
            estadoAct = matrizEstados[estadoAct][valorCaracter];

            entrada.mark(1);

            if (estadoAct == 0) {
                val = 100;
            }

            //Si es un espacio en blanco no generamos token
            //if (caracterEspecial(caracter)){
               // val=0;
           // }
        }

        lexemaBuilder.setLength(0);

        return token;
    }

    private static char mapCaracter(char c) {
        if (Character.isDigit(c) && c != '0') {
            return 'd'; // Devuelve 'd' si es un dígito excepto '0'
        }

        if (c >= 'a' && c <= 'f') {
            return 'L'; // Devuelve 'L' si está entre A - F
        }

        if (c >= 'g' && c <= 'z' && c != 'x' && c != 's') {
            return 'l'; // Devuelve 'l' si está entre G - Z y no es 'x' ni 's'
        }

        return c; // Devuelve el carácter propio en otro caso
    }

    private static int getCaracter(char c) {
        int valor;
        switch(mapCaracter(c)) {
            case 'L':
                valor = 0;
                break;
            case 'l':
                valor = 1;
                break;
            case 'd':
                valor = 2;
                break;
            case '0':
                valor = 3;
                break;
            case '_':
                valor = 4;
                break;
            case '/':
                valor = 5;
                break;
            case '*':
                valor = 6;
                break;
            case '{':
                valor = 7;
                break;
            case '!':
                valor = 8;
                break;
            case '<':
                valor = 9;
                break;
            case '>':
                valor = 10;
                break;
            case '=':
                valor = 11;
                break;
            case '.':
                valor = 12;
                break;
            case '}':
                valor = 13;
                break;
            case '#':
                valor = 14;
                break;
            case '+':
                valor = 15;
                break;
            case '-':
                valor = 16;
                break;
            case 's':
                valor = 17;
                break;
            case 'x':
                valor = 18;
                break;
            case '\n':
                valor = 19;
                break;
            case '\t':
                valor = 20;
                break;
            case '\r':
                valor = 21;
                break;
            case 'o':
                valor = 22;
                break;
            default:
                valor = -1; // Valor por defecto para caracteres no mapeados
                break;
        }
        return valor;
    }

    private boolean caracterEspecial(Character c) {
        String caracterComoString = Character.toString(c);
        return ((caracterComoString.equals("\n")
                || caracterComoString.equals("\t") || caracterComoString.isEmpty()) ||caracterComoString.isBlank());


    }

    public static void sumarLinea(){
        lineaAct++;
    }
}
