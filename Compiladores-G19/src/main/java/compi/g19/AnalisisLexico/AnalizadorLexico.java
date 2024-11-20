package compi.g19.AnalisisLexico;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class AnalizadorLexico {
    private static BufferedReader entrada;
    private static int estadoAct;
    public static int lineaAct = 1;
    private static int[][] matrizEstados = GeneradorMatriz.matrizEstados;
    private static AccionSemantica[][] matrizAS = GeneradorMatriz.matrizAS;
    static List<String> warning = new ArrayList<>();
    public static List<String> errorSintactico = new ArrayList<>();
    public static List<String> errorLexico = new ArrayList<>();
    static List<String> estructuraReconocida = new ArrayList();

    public AnalizadorLexico(BufferedReader entrada) {
        this.entrada = entrada;
        this.estadoAct = 0; // Estado inicial
    }

    public static void setEntrada(BufferedReader entrada){
        AnalizadorLexico.entrada = entrada;
    }

    public static void imprimirErroresLexicos(){
        for (String e : errorLexico)
            System.out.println(e);
    }

    public static void imprimirEstructuras(){
        for (String e : estructuraReconocida)
            System.out.println(e);
    }

    public static void imprimirErroresSintacticos(){
        for (String e : errorSintactico)
            System.out.println(e);
    }
    public static void imprimirWarnings(){
        for (String e : warning)
            System.out.println(e);
    }

    public static void agregarWarning(String error){
        warning.add("WARNING: " + error + " en la línea " + lineaAct);
    }

    public static void agregarErrorSintactico(String error){
        errorSintactico.add("ERROR SINTACTICO: " + error + " en la línea " + lineaAct);

    }

    public static void agregarErrorLexico(String error){
                                    errorLexico.add("ERROR LEXICO: " + error + " en la línea " + lineaAct);
    }

    public static void agregarEstructura(String estructura){
        estructuraReconocida.add(estructura + " en la línea " + AnalizadorLexico.lineaAct);
    }

    public static Token obtenerToken() throws IOException {

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

        Token returnToken = new Token(AccionSemantica.token);

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
