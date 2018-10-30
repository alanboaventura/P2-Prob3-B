/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class PAC implements TipoEntrega {

    @Override
    public double calculaValorEntrega(Pedido pedido) {
        double peso = pedido.getPesoTotal();
        peso = peso * 1000;     //transforma em Kg
        if (peso <= 1) {
            return 10.00;
        } else if (peso > 1 && peso <= 2) {
            return 15.00;
        } else if (peso > 2 && peso <= 3) {
            return 20.00;
        } else if (peso > 3 && peso <= 5) {
            return 30.00;
            
        } else if (peso > 5) {
            new IllegalArgumentException("Quantidade de peso não aceita");
        }
        return 0;
    }
}
