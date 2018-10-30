package p2.prob3.b;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private Date data;
    private String endereco;
    private ArrayList<ItemPedido> itens;
    private FormaDeEntrega formaDeEntrega;

    public Pedido(int numero, String nomeCliente, Date data, String endereco, ArrayList<ItemPedido> itens, FormaDeEntrega formaDeEntrega) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.endereco = endereco;
        this.itens = itens;
        this.formaDeEntrega = formaDeEntrega;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void incluirItem(Produto p, int qtd) {
        this.itens.add(new ItemPedido(p, qtd));
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public FormaDeEntrega getFormaDeEntrega() {
        return formaDeEntrega;
    }

    public void setFormaDeEntrega(FormaDeEntrega formaDeEntrega) {
        this.formaDeEntrega = formaDeEntrega;
    }

    public double getValorPedido() {
        double valorTotal = 0;
        for (ItemPedido ip : this.itens) {
            valorTotal += (ip.getValorItem());
        }
        return valorTotal;
    }

    public int getPesoPedido() {
        int pesoTotal = 0;
        for (ItemPedido ip : this.itens) {
            final Produto produto = ip.getProduto();
            if (produto != null) {
                pesoTotal += (produto.getPeso() * ip.getQuantidade());
            }
        }

        return pesoTotal;
    }

    public double getValorEntrega() throws Exception {
        if (this.formaDeEntrega != null) {
            return this.formaDeEntrega.getValorDeEntrega(this);
        }

        throw new Exception("Tipo de entrega não definido");
    }

    public double getValorTotal() throws Exception {
        final double valorPedido = getValorPedido();
        final double valorEntrega = getValorEntrega();

        return valorPedido + valorEntrega;
    }

}
