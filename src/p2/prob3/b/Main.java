package p2.prob3.b;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String args[]) {
        Pac formaDeEntregaPac = new Pac();
        Sedex formaDeEntregaSedex = new Sedex();

        Produto produto1 = new Produto("Produto 1", 500, 100);
        Produto produto2 = new Produto("Produto 2", 350, 195);
        Produto produto3 = new Produto("Produto 3", 420, 75);
        Produto produtoPesado = new Produto("Produto pesado", 420, 5000);

        ItemPedido itemPedido1 = new ItemPedido(produto1, 3);
        ItemPedido itemPedido2 = new ItemPedido(produto2, 1);
        ItemPedido itemPedido3 = new ItemPedido(produto3, 5);

        ArrayList<ItemPedido> itensPedidos = new ArrayList<>(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
        Pedido pedido = new Pedido(123, "Grupo B", Date.from(Instant.now()), "FURB", itensPedidos, null);

        try {
            pedido.setFormaDeEntrega(formaDeEntregaPac);
            System.out.println("Valor pedido: " + pedido.getValorPedido());
            System.out.println("Valor entrega: " + pedido.getValorEntrega());
            System.out.println("Valor TOTAL: " + pedido.getValorTotal());
            System.out.println();

            pedido.setFormaDeEntrega(formaDeEntregaSedex);
            System.out.println("Valor pedido: " + pedido.getValorPedido());
            System.out.println("Valor entrega: " + pedido.getValorEntrega());
            System.out.println("Valor TOTAL: " + pedido.getValorTotal());
            System.out.println();

            pedido.setFormaDeEntrega(formaDeEntregaPac);
            pedido.incluirItem(produtoPesado, 1);
            pedido.getValorEntrega(); // Deve lançar uma exceção TipoEntregaInvalido.
        } catch (TipoEntregaInvalido e1) {
            System.out.println(e1.getMessage());
        } catch (Exception e2) {
            System.err.println("Deu ruim! Exceção não esperada!");
        }
    }
}
