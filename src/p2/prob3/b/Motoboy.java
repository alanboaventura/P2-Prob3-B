/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class Motoboy implements TipoEntrega{

    @Override
    public double calculaValorEntrega(Pedido pedido){
        if(pedido.getPesoTotal()*1000 > 25 || pedido.getQtdItens() > 30){
            new IllegalArgumentException("Não é possivel fazer essa entrega");
        }
        return 7.00;
    }
    
}
