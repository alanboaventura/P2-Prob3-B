package p2.prob3.b;

public interface FormaDeEntrega {

    double getValorDeEntrega(Pedido pedido) throws TipoEntregaInvalido;
}