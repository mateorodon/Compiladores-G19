package compi.g19.a.AnalisisLexico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/compi/g19/a/AnalisisLexico/entrada_errores.txt";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            AnalizadorLexico analizador = new AnalizadorLexico(reader);
            //Lo hago asi porque si hago while((t = analizador.obtToken())!=null) no anda bien.
            Token t=analizador.obtenerToken();
            while (t != null) {
                System.out.println(t);
                t = analizador.obtenerToken();
            }
            System.out.println("---------------------");
            TablaSimbolos.imprimirSimbolos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
