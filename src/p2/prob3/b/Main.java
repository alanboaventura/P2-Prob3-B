package p2.prob3.b;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String args[]) {
        Produto produto1 = new Produto("Produto 1", 500, 100);
        Produto produto2 = new Produto("Produto 2", 350, 195);
        Produto produto3 = new Produto("Produto 3", 420, 75);
        Produto produtoPesado = new Produto("Produto pesado", 420, 5000);

        ItemPedido itemPedido1 = new ItemPedido(produto1, 3);
        ItemPedido itemPedido2 = new ItemPedido(produto2, 1);
        ItemPedido itemPedido3 = new ItemPedido(produto3, 5);

        ArrayList<ItemPedido> itensPedidos = new ArrayList<>(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
        Pedido pedido1 = new Pedido(123, "Grupo B", Date.from(Instant.now()), "FURB", itensPedidos, null);
        Pedido pedido2 = new Pedido(123, "Grupo B", Date.from(Instant.now()), "FURB", new ArrayList<>(), null);

        try {
            System.out.println("Cálculos normais:\n");
            System.out.println("Valor pedido: " + pedido1.getValorPedido());
            System.out.println();

            System.out.println("PAC: ");
            pedido1.setFormaDeEntrega(Pac.getInstance());
            System.out.println("Valor entrega: " + pedido1.getValorEntrega());
            System.out.println("Valor TOTAL: " + pedido1.getValorTotal());
            System.out.println();

            System.out.println("Sedex: ");
            pedido1.setFormaDeEntrega(Sedex.getInstance());
            System.out.println("Valor entrega: " + pedido1.getValorEntrega());
            System.out.println("Valor TOTAL: " + pedido1.getValorTotal());
            System.out.println();

            System.out.println("Motoboy: ");
            pedido1.setFormaDeEntrega(Motoboy.getInstance());
            System.out.println("Valor entrega: " + pedido1.getValorEntrega());
            System.out.println("Valor TOTAL: " + pedido1.getValorTotal());
            System.out.println();

            System.out.println("Retirada no local: ");
            pedido1.setFormaDeEntrega(RetiradaNoLocal.getInstance());
            System.out.println("Valor entrega: " + pedido1.getValorEntrega());
            System.out.println("Valor TOTAL: " + pedido1.getValorTotal());
            System.out.println();

            System.out.println("------------------------------------------------------------------------------------------------------------\n");

            System.out.println("Cálculos com problemas (lançamento da exceção TipoEntregaInvalido):\n");

            try {
                pedido1.setFormaDeEntrega(Pac.getInstance());
                pedido1.incluirItem(produtoPesado, 1);
                pedido1.getValorEntrega(); // Deve lançar uma exceção TipoEntregaInvalido.
            } catch (TipoEntregaInvalido e1) {
                System.out.println(e1.getMessage());
            }

            try {
                pedido1.setFormaDeEntrega(Motoboy.getInstance());
                pedido1.incluirItem(produtoPesado, 5);
                pedido1.getValorEntrega(); // Deve lançar uma exceção TipoEntregaInvalido.
            } catch (TipoEntregaInvalido e1) {
                System.out.println(e1.getMessage());
            }

            try {
                pedido2.setFormaDeEntrega(Motoboy.getInstance());
                for (int i = 0; i < 35; i++) {
                    pedido2.incluirItem(new Produto(String.valueOf(i), 0.00, 1), 1);
                }
                pedido2.getValorEntrega(); // Deve lançar uma exceção TipoEntregaInvalido.
            } catch (TipoEntregaInvalido e1) {
                System.out.println(e1.getMessage());
            }

        } catch (Exception e2) {
            System.err.println("Deu ruim! Exceção não esperada!\n" + e2.getMessage());
        }
    }
}
