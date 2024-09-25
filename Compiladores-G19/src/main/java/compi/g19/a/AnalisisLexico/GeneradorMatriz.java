package compi.g19.a.AnalisisLexico;

public class GeneradorMatriz {

    private static final AccionSemantica generarASCII = new AccionSemantica.generarASCII();
    private static final AccionSemantica ignorar = new AccionSemantica.ignorar();
    private static final AccionSemantica concatenar = new AccionSemantica.concatenar();
    private static final AccionSemantica resetear = new AccionSemantica.resetear();
    private static final AccionSemantica generarToken = new AccionSemantica.generarToken();
    private static final AccionSemantica error = new AccionSemantica.error();
    private static final AccionSemantica chequeoEntero = new AccionSemantica.chequeoEntero();
    private static final AccionSemantica chequeoFlotante = new AccionSemantica.chequeoFlotante();
    private static final AccionSemantica truncar = new AccionSemantica.truncar();
    private static final AccionSemantica comentario = new AccionSemantica.comentario();

    private static final AccionSemantica concatGenerarToken = new AccionSemantica.compuesta(concatenar, generarToken);
    private static final AccionSemantica resetTruncar = new AccionSemantica.compuesta(resetear, truncar);
    private static final AccionSemantica resetGenerarASCII = new AccionSemantica.compuesta(resetear, generarASCII);
    private static final AccionSemantica concatGenerarASCII = new AccionSemantica.compuesta(concatenar, generarASCII);
    private static final AccionSemantica resetGenerarToken = new AccionSemantica.compuesta(resetear, generarToken);//OJOTA ACA

    private static final AccionSemantica tokenEntero = new AccionSemantica.compuesta(resetear, chequeoEntero);
    private static final AccionSemantica tokenFlotante = new AccionSemantica.compuesta(resetear, chequeoFlotante);




    public static final int[][] matrizEstados;
    static {
        matrizEstados = new int[][] {
                {1, 1, 5, 10, 0, 12, 0, 4, 3, 2, 2, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 0, 4, 4, 4},
                {0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0},
                {0, 0, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 0, 0, 0, 0, 0, 0},
                {0, 0, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0},
                {11, 0, 11, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 0, 0, 0, 0, 0},
                {13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 13, 13, 13, 13, 13, 13, 13, 13},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }


    public static final AccionSemantica[][] matrizAS;
    static {
        matrizAS=new AccionSemantica[][]{
                {concatenar, concatenar, concatenar, concatenar, error, ignorar, concatGenerarASCII, concatenar,concatenar,concatenar, concatenar,concatGenerarASCII,concatGenerarASCII,concatGenerarASCII, concatGenerarASCII, concatGenerarASCII,concatGenerarASCII,concatenar,concatenar,ignorar, ignorar, ignorar, concatGenerarASCII},
                {concatenar, concatenar, concatenar, concatenar, concatenar, resetTruncar,resetTruncar,resetTruncar,resetTruncar, resetTruncar,resetTruncar,resetTruncar,resetTruncar,resetTruncar,resetTruncar, resetTruncar, resetTruncar, concatenar, concatenar, resetTruncar, resetTruncar,resetTruncar, resetTruncar},
                {resetGenerarASCII, resetGenerarASCII, resetGenerarASCII, resetGenerarASCII, resetGenerarASCII, resetGenerarASCII, resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,concatGenerarToken,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII},
                {error, error, error, error,error, error,error,error, error, error,error,concatGenerarToken,error, error, error, error, error, error, error, error, error, error, error},
                {concatenar,concatenar,concatenar,concatenar,concatenar, concatenar, concatenar,concatenar,concatenar,concatenar,concatenar,concatenar, concatenar, generarToken,concatenar,concatenar,concatenar,concatenar,concatenar, error,concatenar,concatenar,concatenar},
                {tokenEntero, tokenEntero, concatenar, concatenar, tokenEntero, tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero, tokenEntero,tokenEntero, concatenar,tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero},
                {error, error,concatenar,concatenar,concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, error, concatenar, concatenar, concatenar, concatenar, concatenar},
                {resetGenerarToken,resetGenerarToken,concatenar,resetGenerarToken,resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, concatenar, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken},
                {error,error,concatenar,error,error, error, error, error, error, error, error, error, error, error, error, concatenar, concatenar, error, error, error, error, error, error},
                {tokenFlotante,tokenFlotante,concatenar,concatenar,tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante,tokenFlotante,tokenFlotante,tokenFlotante,tokenFlotante,tokenFlotante,tokenFlotante,tokenFlotante, tokenFlotante},
                {resetGenerarToken,resetGenerarToken,resetGenerarToken,resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, concatenar, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken},
                {concatenar,tokenEntero,concatenar,tokenEntero,tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero},
                {resetGenerarToken, resetGenerarToken,resetGenerarToken,resetGenerarToken,resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, ignorar, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken},
                {ignorar,ignorar,ignorar,ignorar,ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar},
                {error, error,error,error,error, comentario, error, error, error, error, error, error,error,error, error, error, error, error, error, error, error, error, error}
        };
    }

}
