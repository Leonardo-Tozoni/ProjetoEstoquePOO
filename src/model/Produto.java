package model;

public class Produto {
    private int sku;
    private String nomeProduto;
    private double quantidadeProduto;
    private double precoProduto;

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(double quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return  "Código = " + sku + "\n" +
                "Nome = " + nomeProduto + "\n" +
                "Quantidade = " + quantidadeProduto +  "\n" +
                "Preço = " + precoProduto + "\n";
    }

    public String total(){
        return  "Código = " + sku + "\n" +
                "Nome = " + nomeProduto + "\n" +
                "Quantidade = " + quantidadeProduto +  "\n" +
                "Preço unitário = " + precoProduto + "\n" +
                "Preço total em estoque = " + (precoProduto * quantidadeProduto) + "\n";
    }

    public boolean acrescentar(double qtd){
        if(qtd > 0){
            quantidadeProduto += qtd;
            return true;
        }
        return false;
    }

    public boolean remover(double qtd){
        if(quantidadeProduto <= qtd){
            qtd -= quantidadeProduto;
            return true;
        }
        return false;
    }
}