package compi.g19.AnalisisLexico;

import compi.g19.AnalisisSintactico.*;
import compi.g19.GeneracionAssembler.GeneradorAssembler;
import compi.g19.GeneracionDeCodigo.Nodo;

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.err.println("Debe proporcionar el path del archivo de entrada como argumento.");
                return;
            }

            String inputFilePath = args[0];
            File inputFile = new File(inputFilePath);

            if (!inputFile.exists()) {
                System.err.println("El archivo proporcionado no existe.");
                return;
            }

            if (inputFile.length() == 0) {
                System.out.println("El archivo proporcionado está vacío.");
                return;
            }

            // Crear una copia única del archivo de entrada
            String uniqueFileName = createUniqueCopy(inputFile);

            // Leer el archivo copiado sin modificar el original
            BufferedReader reader = new BufferedReader(new FileReader(uniqueFileName));
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append(System.lineSeparator());
            }
            reader.close();

            // Pasa el contenido leído al analizador léxico
            AnalizadorLexico.setEntrada(new BufferedReader(new StringReader(contenido.toString())));

            armarArchivoSalida(uniqueFileName);
            Parser parser = new Parser();
            parser.run();

            System.out.println("----------ARBOL SINTACTICO -----------");
            if (parser.getRaiz() != null)
                parser.getRaiz().recorrerArbol(0);

            System.out.println("----------ARBOL SINTACTICO FUNCIONES -----------");
            if (parser.getFuncionesDeclaradas() != null) {
                for (Nodo funcion : parser.getFuncionesDeclaradas()) {
                    if (funcion != null)
                        funcion.recorrerArbol(0);
                }
            }

            imprimirEstructurasYErrores();

            // Eliminar el archivo de copia único al final
            File fileToDelete = new File(uniqueFileName);
            if (fileToDelete.exists()) {
                if (fileToDelete.delete()) {
                    System.out.println("Archivo copia eliminado: " + uniqueFileName);
                } else {
                    System.out.println("No se pudo eliminar el archivo copia: " + uniqueFileName);
                }
            }


            if (Parser.noHayErrores()) {
                GeneradorAssembler generador = new GeneradorAssembler(parser);
                File asmFile = new File(uniqueFileName.substring(0, uniqueFileName.length() - 4) + ".asm");
                asmFile.createNewFile();

                try (PrintWriter pw = new PrintWriter(asmFile)) {
                    pw.print(generador.getAssembler());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String createUniqueCopy(File inputFile) throws IOException {
        // Crear un nombre único usando timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String uniqueFileName = inputFile.getParent() + File.separator +
                "copia_" + timestamp + "_" + inputFile.getName();

        // Copiar el contenido del archivo original al nuevo archivo
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(uniqueFileName))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }
        }

        return uniqueFileName;
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

    public static void imprimirEstructurasYErrores() {
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

