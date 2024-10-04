package compi.g19.a.AnalisisLexico;

import compi.g19.b.AnalisisSintactico.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/compi/g19/a/AnalisisLexico/programa_ejemplo.txt";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            AnalizadorLexico.setEntrada(reader);
            //Lo hago asi porque si hago while((t = analizador.obtToken())!=null) no anda bien.
            Parser parser = new Parser();
            parser.run();
            Token t=AnalizadorLexico.obtenerToken();
            while (t != null) {
                System.out.println(t);
                t = AnalizadorLexico.obtenerToken();
            }
            System.out.println("----------ESTRUCTURAS RECONOCIDAS-----------");
            AnalizadorLexico.imprimirEstructuras();
            System.out.println("----------TABLA DE SIMBOLOS-----------");
            TablaSimbolos.imprimirSimbolos();
            System.out.println("-----------ERRORES LEXICOS----------");
            AnalizadorLexico.imprimirErroresLexicos();
            System.out.println("-----------ERRORES SINTACTICOS----------");
            AnalizadorLexico.imprimirErroresSintacticos();
            System.out.println("----------WARNINGS-----------");
            AnalizadorLexico.imprimirWarnings();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
