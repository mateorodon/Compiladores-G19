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
    static List<Error> estructuraReconocida = new ArrayList<Error>();

    public AnalizadorLexico(BufferedReader entrada) {
        this.entrada = entrada;
        this.estadoAct = 0; // Estado inicial
    }

    public static void agregarWarning(String error){
        Error e = new Error(error, lineaAct);
        warning.add(e);
    }

    public static void imprimirErroresLexicos(){
        for (Error e : errorLexico)
            System.out.println(e.toString());
    }
    public static void imprimirErroresSintacticos(){
        for (Error e : errorSintactico)
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

    public static void agregarEstructura(String error){
        Error e = new Error(error, AnalizadorLexico.lineaAct);
        estructuraReconocida.add(e);
    }

    public Token obtenerToken() throws IOException {

        StringBuilder lexemaBuilder = new StringBuilder();
        int valorLeido;
        int val = 0;
        entrada.mark(1);

        while (estadoAct != -1 && val != 100 && (valorLeido = entrada.read()) != -1) {
            Character caracter = (char) valorLeido;

            int valorCaracter = getCaracter(Character.toLowerCase(caracter));
            AccionSemantica accion = matrizAS[estadoAct][valorCaracter];

            accion.ejecutar(lexemaBuilder, caracter, entrada);

            estadoAct = matrizEstados[estadoAct][valorCaracter];

            entrada.mark(1);

            if (estadoAct == 0) {
                val = 100;
            }

            //Si es un espacio en blanco no generamos token
            //Paso el LEXEMA porque si paso solo el token me seguiria concatenando con el siguiente TOKEN en caso de venir un caracter especial, ya que no cortaria la ejecucion
            if (caracterEspecial(lexemaBuilder.toString())){
                val=0;
            }
        }

        Token returnToken = new Token(token);

        lexemaBuilder.setLength(0);

        //Llegaria aca con LEXEMA vacio en caso de llegar al fin del archivo.
        return (returnToken.getLexema().length() == 0) ? null : returnToken;
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
        switch (mapCaracter(c)) {
            case 'l':
                return 0;
            case 'd':
                return 1;
            case '0':
                return 2;
            case '_':
                return 3;
            case '/':
                return 4;
            case '*':
                return 5;
            case '{':
                return 6;
            case '!':
                return 7;
            case '<':
                return 8;
            case '>':
                return 9;
            case ':':
                return 10;
            case '=':
                return 11;
            case '.':
                return 12;
            case '}':
                return 13;
            case '#':
                return 14;
            case '+':
                return 15;
            case '-':
                return 16;
            case 's':
                return 17;
            case 'x':
                return 18;
            case '\n': // Caída a través para los casos '\r', '\t', ' '
            case '\r':
            case '\t':
            case ' ':
                return 19;
            default:
                return 20;
        }
    }

    public static boolean caracterEspecial(String c) {
        return ((c.equals("\n") || c.equals("\t")
                || c.isEmpty() || c.equals("\r") || c.isBlank()));


    }

    public static void sumarLinea(){
        lineaAct++;
    }
}
