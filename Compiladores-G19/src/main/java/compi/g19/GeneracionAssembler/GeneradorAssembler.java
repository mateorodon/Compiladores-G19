package compi.g19.GeneracionAssembler;


import compi.g19.AnalisisLexico.TablaSimbolos;
import compi.g19.AnalisisLexico.Token;
import compi.g19.AnalisisSintactico.Parser;
import compi.g19.GeneracionDeCodigo.Nodo;
import compi.g19.GeneracionDeCodigo.NodoComun;

import static compi.g19.AnalisisSintactico.Parser.tiposDeclarados;

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
                +"includelib \\masm32\\lib\\user32.lib \n"
                + "include \\masm32\\include\\masm32rt.inc \n"
                + "dll_dllcrt0 PROTO C \n"
                + "printf PROTO C : VARARG \n";
        this.data= "\n.data\n"
                + "AutoinvocacionFunciones db \"Una funcion no puede llamarse a si misma.\", 0 \n"
                + "OperacionEnteroNegativo db \"El resultado de la operacion no puede ser negativo.\", 0 \n"
                + "OverflowSumaFlotantes db \"Se produjo un un overflow en la suma de flotantes.\", 0 \n"
                + "error db \"Error\", 0 \n"
                + "printMensaje db \"Print\", 0 \n";

        this.code="";
        this.codigoFunciones=
                "handle_autoinvocacion: \n"
                + "invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK \n"
                + "invoke ExitProcess, 0 \n"
                + "handle_negativos: \n"
                + "invoke MessageBox, NULL, addr OperacionEnteroNegativo, addr error, MB_OK \n"
                + "invoke ExitProcess, 0 \n"
                + "handle_overflow: \n"
                + "invoke MessageBox, NULL, addr OverflowSumaFlotantes, addr error, MB_OK \n"
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
            if(uso != null){
                if(uso.equals("constante")){
                    String prefijo = "_";
                    if (t.getTipo().equals("ulongint"))
                        data += prefijo + k + " dd " + k + "\n";
                    if (t.getTipo().equals("single")) {
                        String kNew = k.replace('.', '_');
                        if (!t.getValor().contains("-")) {
                            data += prefijo + kNew + " dq " + k + "\n";
                        }
                        else{
                            data += prefijo + kNew + " dq " + "-" + k + "\n";
                        }
                    }
                }
                if( uso.equals("variable")  ||  uso.equals("variableAuxiliar") || uso.equals("parametro"))
                {
                    String prefijo = "_";

                    if (t.getTipo() != null && t.getTipo().equals("ulongint"))
                        data += prefijo + k + " dd " + "?" + "\n";
                    if (t.getTipo() != null && t.getTipo().equals("single"))
                        data += prefijo + k + " dq " + "?" + "\n";
                    if (uso.equals("parametro") && tiposDeclarados.containsKey(t.getTipo())){
                        String tipoDelTipo = tiposDeclarados.get(t.getTipo());
                        if (tipoDelTipo.equals(ENTERO))
                            data += prefijo + k + " dd " + "?" + "\n";
                        else if (tipoDelTipo.equals(FLOTANTE)) {
                            data += prefijo + k + " dq " + "?" + "\n";
                        }
                    }

                }
                if (uso.equals("arreglo")){
                    String prefijo = "_";
                    data += prefijo +  k + " dd " + "?,?,?" + "\n";
                }
            }
        }
        data+= "limite_float dq 3.4e38" + "\n";
        data+= NodoComun.data;
    }

    private void generarCode() {
        code = "\n.code\n";

        code+= codigoFunciones;
        code+= "start:\n";

        code+= this.codigoArbol;
        code+= "invoke ExitProcess, 0 \n";
        code+= "end start";
    }

    public String getAssembler(){
        return (this.bibliotecas + this.data + this.code);
    }
}