
import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private Date data;
    private String endereco;
    private ArrayList<ItemPedido> itens;
    private TipoEntrega entrega;

    public Pedido() {
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

    public double getValorPedido() {
        double valorTotal = 0;
        for (ItemPedido ip : this.itens) {
            valorTotal += (ip.getValorItem());
        }
        return valorTotal;
    }

////////////////////////////////////////////////////////////////////////////////
    public TipoEntrega getEntrega() {
        return entrega;
    }

    public void setEntrega(TipoEntrega entrega) {
        this.entrega = entrega;
    }

    public double getValorTotal() {
        double peso = getPesoTotal();
        double valorTotal = this.getValorTotal() + this.getValorPedido();
        return valorTotal;
    }

    /**
     * 
     * retorna o tipo de entrega escolhido
     * @throws Exception 
     */
    public double getValorEntrega(){
        if(entrega==null){
            new IllegalArgumentException("Nenhum tipo de entrega selecionado");
        }
        return entrega.calculaValorEntrega(this);
    }

    /**
    * Retorna o peso total em gramas
    */
    public double getPesoTotal() {
        double peso = 0;
        for (ItemPedido iten : itens) {
            peso = peso + (iten.getProduto().getPeso()) * iten.getQuantidade();
        }
        return peso;
    }

    /**
     * 
     * retorna a quantidade de itens que o pedido contem 
     */
    public int getQtdItens(){
        int qtdItens = 0;
        for (ItemPedido iten : itens) {
            qtdItens = qtdItens + iten.getProduto().getPeso() * iten.getQuantidade();
        }
        return qtdItens;
    }
}
