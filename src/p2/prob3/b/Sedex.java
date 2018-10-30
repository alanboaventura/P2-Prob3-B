/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class SEDEX implements TipoEntrega{
    
    @Override
    public double calculaValorEntrega(Pedido pedido) {
        double peso = pedido.getPesoTotal();
        if (peso <= 500) {
            return 12.50;
        } else if (peso >= 501 && peso <= 750) {
            return 20.00;
        } else if (peso >= 751 && peso <= 1200) {
            return 30.00;
        } else if (peso > 1201 && peso <= 2000) {
            return 45.00;
        } else if (peso > 2000) {
            peso = peso - 2000;
            int x = (int) (peso / 100);
            return (45.00 + (x * 1.50));
        }
        return 0;
    }
}
