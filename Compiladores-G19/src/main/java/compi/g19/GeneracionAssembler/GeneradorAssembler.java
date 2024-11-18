package compi.g19.GeneracionAssembler;


import compi.g19.AnalisisLexico.TablaSimbolos;
import compi.g19.AnalisisLexico.Token;
import compi.g19.AnalisisSintactico.Parser;
import compi.g19.GeneracionDeCodigo.Nodo;
import compi.g19.GeneracionDeCodigo.NodoComun;

public class GeneradorAssembler {
    private String data, code, codigoArbol, bibliotecas, codigoFunciones;
    private Nodo arbol;
    private static final String ENTERO = "ulongint";
    private static final String FLOTANTE = "single";


    public GeneradorAssembler(Parser parser){
        this.bibliotecas = ".386 \n.model flat, stdcall \noption casemap :none  \n"
                +"include \\masm32\\include\\windows.inc \n"
                +"include \\masm32\\include\\kernel32.inc \n"
                +"include \\masm32\\include\\masm32.inc  \n"
                +"includelib \\masm32\\lib\\kernel32.lib \n"
                +"includelib \\masm32\\lib\\masm32.lib\n"
                +"include \\masm32\\include\\user32.inc \n"
                +"includelib \\masm32\\lib\\user32.lib \n";
        this.data= "\n.data\n"
                + "AutoinvocacionFunciones db \"Una funcion no puede llamarse a si misma.\", 0 \n"
                + "OperacionEnteroNegativo db \"El resultado de la operacion no puede ser negativo.\", 0 \n"
                + "OverflowSumaDouble db \"Se produjo un un overflow en la suma de doubles.\", 0 \n"
                + "error db \"Error\", 0 \n"
                + "printMensaje db \"Print\", 0 \n";

        this.code="";
        this.codigoFunciones= "invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK \n"
                + "invoke ExitProcess, 0 \n"
                + "invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK \n"
                + "invoke ExitProcess, 0 \n"
                + "invoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK \n"
                + "invoke ExitProcess, 0 \n";
        this.codigoArbol="";
        this.arbol=parser.getRaiz();

        for (Nodo a : Parser.getFuncionesDeclaradas()) {
            codigoFunciones += a.getAssembler()+"\n";
        }
        codigoArbol +=this.arbol.getAssembler();
        generarCode();
        generarData();
    }


    private void generarData(){

        for (String k :  TablaSimbolos.getSimbolos().keySet()){
            Token t = TablaSimbolos.getToken(k);
            String uso = t.getUso();
            String tipo = t.getTipo();
            if(uso != null){
                if(uso.equals("constante")){
                    String prefijo = "_";
                    if(tipo.equals(ENTERO))
                    {
                        data += prefijo + k + " db " + k + "\n";
                    }
                    else if(tipo.equals(FLOTANTE))
                    {
                        data += prefijo + k + " dq " + k + "\n";
                    }
                    else
                    {
                        data += prefijo +  k + " dd " + k + "\n";
                    }

                }
                if( uso.equals("variable")  ||  uso.equals("variableAuxiliar"))
                {
                    String prefijo = "";
                    if(uso.equals("variable"))
                    {
                        prefijo = "_";
                    }
                    if(tipo.equals(ENTERO))
                    {

                        data += prefijo +  k + " db " + "?" + "\n";
                    }
                    else if(tipo.equals(FLOTANTE))
                    {
                        data += prefijo + k + " dq " + "?" + "\n";
                    }
                    else
                    {
                        data += prefijo +  k + " dd " + "?" + "\n";
                    }
                }
            }
        }
        data+= NodoComun.data;
    }

    private void generarCode() {
        code = "\n.code\n";

        code+= codigoFunciones;
        code+= "main:\n";

        code+= this.codigoArbol;
        code+= "invoke ExitProcess, 0 \n";
        code+= "end main";
    }

    public String getAssembler(){
        return (this.bibliotecas + this.data + this.code);
    }
}