package p2.prob3.b;

public class RetiradaNoLocal implements FormaDeEntrega {

    private static RetiradaNoLocal instancia;

    private RetiradaNoLocal() {
    }

    public static synchronized RetiradaNoLocal getInstance() {
        if (instancia == null) {
            instancia = new RetiradaNoLocal();
        }

        return instancia;
    }

    @Override
    public double getValorDeEntrega(Pedido pedido) {
        return 0.00;
    }
}
