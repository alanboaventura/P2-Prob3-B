package p2.prob3.b;

public interface EntregaStrategy {

    double getValorDeEntrega(int pesoPedido) throws TipoEntregaInvalido;
}