package p2.prob3.b;

public class Pac implements FormaDeEntrega {

    private static Pac instancia;

    private Pac() {
    }

    public static synchronized Pac getInstance() {
        if (instancia == null) {
            instancia = new Pac();
        }

        return instancia;
    }

    @Override
    public double getValorDeEntrega(Pedido pedido) throws TipoEntregaInvalido {
        final int pesoPedido = pedido.getPesoPedido();

        if (pesoPedido > 5000) {
            throw new TipoEntregaInvalido("O tipo de entrega PAC não disponível para entregas que remetam a pedidos com peso maior que 5KG.");
        } else if (pesoPedido > 3000) {
            return 30;
        } else if (pesoPedido > 2000) {
            return 20;
        } else if (pesoPedido > 1000) {
            return 15;
        }

        return 10;
    }
}