package p2.prob3.b;

public class Sedex implements EntregaStrategy {

    @Override
    public double getValorDeEntrega(int weight) {
        if (weight > 2000)
            return 45 + Math.ceil((weight - 2000) / 100) * 1.5;
        if (weight > 1200)
            return 45;
        if (weight > 750)
            return 30;
        if (weight > 500)
            return 20;

        return 12.5;
    }
}