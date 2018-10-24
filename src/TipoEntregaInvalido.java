package problema3;

class TipoEntregaInvalido extends Exception {
    
    public TipoEntregaInvalido() {}

    public TipoEntregaInvalido(String message){
        super(message);
    }
}