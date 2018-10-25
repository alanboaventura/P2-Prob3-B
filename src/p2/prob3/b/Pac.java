package p2.prob3.b;

public class Pac implements EntregaStrategy {

    @Override
    public double getValorDeEntrega(int weight) throws TipoEntregaInvalido {
        if (weight > 5000)
            throw new TipoEntregaInvalido("O tipo de entrega PAC não disponível para entregas que remetam a pedidos com peso maior que 5KG.");
        if (weight > 3000)
            return 30;
        if (weight > 2000)
            return 20;
        if (weight > 1000)
            return 15;

        return 10;
    }
}