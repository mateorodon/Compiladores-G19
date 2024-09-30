package compi.g19.a.AnalisisLexico;

public class GeneradorMatriz {

    private static final AccionSemantica concatenar = new AccionSemantica.concatenar();
    private static final AccionSemantica generarASCII = new AccionSemantica.generarASCII();
    private static final AccionSemantica ignorar = new AccionSemantica.ignorar();
    private static final AccionSemantica resetear = new AccionSemantica.resetear();
    private static final AccionSemantica chequeoEntero = new AccionSemantica.chequeoEntero();
    private static final AccionSemantica chequeoHexa = new AccionSemantica.chequeoHexa();
    private static final AccionSemantica chequeoFlotante = new AccionSemantica.chequeoFlotante();
    private static final AccionSemantica truncar = new AccionSemantica.truncar();
    private static final AccionSemantica comentario = new AccionSemantica.comentario();
    private static final AccionSemantica compararOAsignar = new AccionSemantica.compararOAsignar();
    private static final AccionSemantica error = new AccionSemantica.error();

    private static final AccionSemantica errorFlotanteDecimal = new AccionSemantica.errorFlotanteDecimal();
    private static final AccionSemantica errorFlotanteEntera = new AccionSemantica.errorFlotanteEntera();
    private static final AccionSemantica errorIdentificador = new AccionSemantica.errorIdentificador();
    private static final AccionSemantica errorCadena = new AccionSemantica.errorCadena();


    private static final AccionSemantica concatCompararOAsignar = new AccionSemantica.compuesta(concatenar, compararOAsignar);
    private static final AccionSemantica resetTruncar = new AccionSemantica.compuesta(resetear, truncar);
    private static final AccionSemantica resetGenerarASCII = new AccionSemantica.compuesta(resetear, generarASCII);
    private static final AccionSemantica concatGenerarASCII = new AccionSemantica.compuesta(concatenar, generarASCII);
    private static final AccionSemantica resetGenerarToken = new AccionSemantica.compuesta(resetear, compararOAsignar);//OJOTA ACA

    private static final AccionSemantica tokenEntero = new AccionSemantica.compuesta(resetear, chequeoEntero);
    private static final AccionSemantica tokenFlotante = new AccionSemantica.compuesta(resetear, chequeoFlotante);




    public static final int[][] matrizEstados;
    static {
        matrizEstados =
                new int[][] {
              // 0  1  2  3  4   5   6  7  8  9  10 11 12 13 14 15 16 17 18 19 20
                {1, 3, 4, 1, 11, 0, 14, 2, 2, 2, 2, 0, 10, 0, 0, 0, 0, 1, 1, 0, 0},// estado 0
                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0}, // estado 1
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// estado 2
                {0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0},// estado 3
                {0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 5, 0, 0},// estado 4
                {5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// estado 5
                {0, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0}, //estado 6
                {0, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0},// estado 7
                {0, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 0, 0, 0, 0},// estado 8
                {0, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// estado 9
                {0, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// estado 10
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 0, 0, 0},// estado 11
                {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 12, 12, 12, 12, 12, 12},// estado 12
                {12, 12, 12, 12, 0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12},// estado 13
                {14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 0, 14, 14, 14, 14, 14, 14, 14},// estado 14

        };
    }


    public static final AccionSemantica[][] matrizAS;
    static {
        matrizAS=new AccionSemantica[][]{
                {concatenar, concatenar, concatenar, concatenar, concatenar, generarASCII, ignorar, concatenar,concatenar,concatenar, concatenar,generarASCII,concatenar,generarASCII, generarASCII, generarASCII,generarASCII,concatenar,concatenar,ignorar, generarASCII},
                {concatenar, concatenar, concatenar, concatenar, resetTruncar, resetTruncar,resetTruncar,resetTruncar,resetTruncar, resetTruncar,resetTruncar,resetTruncar,resetTruncar,resetTruncar,resetTruncar, resetTruncar, resetTruncar, concatenar, concatenar, resetTruncar, resetTruncar},
                {resetGenerarASCII, resetGenerarASCII, resetGenerarASCII, resetGenerarASCII, resetGenerarASCII, resetGenerarASCII, resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,concatCompararOAsignar,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII,resetGenerarASCII},
                {tokenEntero,concatenar,concatenar,tokenEntero,tokenEntero, tokenEntero,tokenEntero,tokenEntero, tokenEntero, tokenEntero,tokenEntero,tokenEntero,concatenar, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero},
                {tokenEntero,concatenar,concatenar,tokenEntero,tokenEntero, tokenEntero, tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero, concatenar, tokenEntero,tokenEntero,tokenEntero,tokenEntero,tokenEntero,concatenar, tokenEntero,tokenEntero},
                {concatenar, concatenar, concatenar, chequeoHexa, chequeoHexa, chequeoHexa,chequeoHexa,chequeoHexa,chequeoHexa,chequeoHexa, chequeoHexa,chequeoHexa, chequeoHexa,chequeoHexa,chequeoHexa,chequeoHexa,chequeoHexa,chequeoHexa,chequeoHexa,chequeoHexa,chequeoHexa},
                {error, error,errorFlotanteEntera,concatenar,concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, concatenar, errorFlotanteDecimal, concatenar, concatenar, concatenar},
                {resetGenerarToken,resetGenerarToken,concatenar,resetGenerarToken,resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, concatenar, resetGenerarToken, resetGenerarToken, resetGenerarToken},
                {error,error,concatenar,error,error, error, error, error, error, error, error, error, error, error, error, concatenar, concatenar, error, error, error, error},
                {tokenFlotante,tokenFlotante,concatenar,concatenar,tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante, tokenFlotante,tokenFlotante,tokenFlotante,tokenFlotante,tokenFlotante,tokenFlotante,tokenFlotante},
                {resetGenerarToken,resetGenerarToken,resetGenerarToken,resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, resetGenerarToken, concatenar, resetGenerarToken, resetGenerarToken},
                {concatenar,tokenEntero,concatenar,tokenEntero,tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero, tokenEntero},
                {generarASCII, generarASCII,generarASCII,generarASCII,generarASCII, generarASCII, generarASCII, generarASCII, generarASCII, generarASCII, generarASCII, generarASCII, generarASCII, generarASCII, ignorar, generarASCII, generarASCII, generarASCII, generarASCII, generarASCII, generarASCII},
                {ignorar,ignorar,ignorar,ignorar,ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar, ignorar},
                {error, error,error,error,error, comentario, error, error, error, error, error, error,error,error, error, error, error, error, error, error, error}
        };
    }

}
