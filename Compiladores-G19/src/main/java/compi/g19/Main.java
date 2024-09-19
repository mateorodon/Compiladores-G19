package compi.g19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/compi/g19/entrada1.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            AnalizadorLexico analizador = new AnalizadorLexico(reader);
            Token t; //Token leido
            while ((t = analizador.obtenerToken()) != null || (reader.read() == -1)) {
               // ES POR ACA, CONSULTAR SI READER.READ CAE EN UN NUL
                System.out.println(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
