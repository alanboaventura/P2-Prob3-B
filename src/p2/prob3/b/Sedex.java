package p2.prob3.b;

public class Sedex implements FormaDeEntrega {

    private static Sedex instancia;

    private Sedex() {
    }

    public static synchronized Sedex getInstance() {
        if (instancia == null) {
            instancia = new Sedex();
        }

        return instancia;
    }

    @Override
    public double getValorDeEntrega(Pedido pedido) {
        final double pesoPedido = pedido.getPesoPedido();

        if (pesoPedido > 2000)
            return 45 + Math.ceil((pesoPedido - 2000) / 100) * 1.5;
        if (pesoPedido > 1200)
            return 45;
        if (pesoPedido > 750)
            return 30;
        if (pesoPedido > 500)
            return 20;

        return 12.5;
    }
}