package compi.g19;

public abstract class AccionSemantica {

    protected static final int TAMANIO_VAR = 15;
    public abstract void ejectuar(Token t);

    class generarASCII extends AccionSemantica {
        @Override
        public void ejectuar(Token t) {

        }
    }

    class concatenar extends AccionSemantica {
        @Override
        public void ejectuar(Token t) {

        }
    }

    class resetear extends AccionSemantica {
        @Override
        public void ejectuar(Token t) {

        }
    }

    class generarToken extends AccionSemantica {
        @Override
        public void ejectuar(Token t) {

        }
    }

    class error extends AccionSemantica {
        @Override
        public void ejectuar(Token t) {

        }
    }


    
}
