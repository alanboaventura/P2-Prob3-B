package p2.prob3.b;

class TipoEntregaInvalido extends Exception {

    public TipoEntregaInvalido() {
    }

    public TipoEntregaInvalido(String message) {
        super(message);
    }
}