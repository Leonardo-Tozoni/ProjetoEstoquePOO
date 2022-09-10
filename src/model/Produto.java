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
}