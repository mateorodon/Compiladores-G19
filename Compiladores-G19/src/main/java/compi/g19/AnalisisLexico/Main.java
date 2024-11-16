package compi.g19.AnalisisLexico;

import compi.g19.AnalisisSintactico.*;
import compi.g19.GeneracionAssembler.GeneradorAssembler;
import compi.g19.GeneracionDeCodigo.Nodo;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try{
            if (args.length == 0) {
                System.err.println("Debe proporcionar el path del archivo de entrada como argumento.");
                return;
            }
            armarArchivoSalida(args[0]);
            File inputFile = new File(args[0]);
            if (inputFile.length() == 0) {
                System.out.println("El archivo proporcionado está vacío.");
                return;
            }
            try (FileWriter fileWriter = new FileWriter(args[0], true)) {
                fileWriter.write(" ");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al intentar escribir en el archivo: " + e.getMessage());
            }
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            AnalizadorLexico.setEntrada(reader);

            armarArchivoSalida(args[0]);
            Parser parser = new Parser();
            parser.run();
            System.out.println("----------ARBOL SINTACTICO -----------");
            if (parser.getRaiz()!=null)
                parser.getRaiz().recorrerArbol(0);
            System.out.println("----------ARBOL SINTACTICO FUNCIONES -----------");
            if (parser.getFuncionesDeclaradas() != null) {
                for (Nodo funcion : parser.getFuncionesDeclaradas()) {
                    if (funcion != null)
                        funcion.recorrerArbol(0);
                }
            }

            GeneradorAssembler generador = new GeneradorAssembler(parser);
            File f = new File(args[0].substring(0,args[0].length()-4)+".asm");
            f.createNewFile();
            PrintWriter pw;
            try {
                pw = new PrintWriter(args[0].substring(0,args[0].length()-4)+".asm");
                pw.print(generador.getAssembler());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

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
        System.out.println("-----------ERRORES SEMANTICOS----------");
        Parser.imprimirErroresSemanticos();
        System.out.println("----------WARNINGS-----------");
        AnalizadorLexico.imprimirWarnings();
    }
}
