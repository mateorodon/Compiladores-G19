package compi.g19.a.AnalisisLexico;

import compi.g19.b.AnalisisSintactico.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        try{
            if (args.length == 0) {
                System.err.println("Debe proporcionar el path del archivo de entrada como argumento.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            AnalizadorLexico.setEntrada(reader);

            armarArchivoSalida(args[0]);

            Parser parser = new Parser();
            parser.run();

            imprimirEstructurasYErrores();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void armarArchivoSalida(String archivo_entrada) throws FileNotFoundException {
        File archivoEntrada = new File(archivo_entrada);

        String nombreArchivoEntrada = archivoEntrada.getName();
        int lastDot = nombreArchivoEntrada.lastIndexOf('.');
        if (lastDot > 0) {
            nombreArchivoEntrada = nombreArchivoEntrada.substring(0, lastDot);
        }

        String directorioEntrada = archivoEntrada.getParent();

        File archivoSalida = new File(directorioEntrada, "salida_" + nombreArchivoEntrada + ".txt");

        // Redirigir la salida de System.out a archivo_salida.txt
        PrintStream salidaArchivo = new PrintStream(new FileOutputStream(archivoSalida));
        System.setOut(salidaArchivo);
    }

    public static void imprimirEstructurasYErrores(){
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
    }
}
