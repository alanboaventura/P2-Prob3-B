package problema3;

class PAC implements Shipping {

    @Override
    double getShippingValue(int weight){
        if (weight > 5000)
            throw new TipoEntregaInvalido();

        if (weight > 3000)
            return 30;
        if (weight > 2000)
            return 20;
        if (weight > 1000)
            return 15;
        return 10;
    }
}