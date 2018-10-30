package p2.prob3.b;

import java.util.ArrayList;
import java.util.List;

public class Motoboy implements FormaDeEntrega {

    private static Motoboy instancia;

    private Motoboy() {
    }

    public static synchronized Motoboy getInstance() {
        if (instancia == null) {
            instancia = new Motoboy();
        }

        return instancia;
    }

    @Override

    public double getValorDeEntrega(Pedido pedido) throws TipoEntregaInvalido {
        final int pesoPedido = pedido.getPesoPedido();
        final List<Produto> produtosPedido = new ArrayList<>();

        for (ItemPedido itemPedido : pedido.getItens()) {
            final Produto produto = itemPedido.getProduto();
            if (!produtosPedido.contains(produto)) {
                produtosPedido.add(produto);
            }
        }

        if (pesoPedido > 25000) {
            throw new TipoEntregaInvalido("O tipo de entrega MOTOBOY não disponível para entregas que remetam a pedidos com peso maior que 25KG.");
        } else if (produtosPedido.size() > 30) {
            throw new TipoEntregaInvalido("O tipo de entrega MOTOBOY não disponível para entregas que remetam a pedidos com mais de 30 produtos.");
        }

        return 7.00;
    }
}
