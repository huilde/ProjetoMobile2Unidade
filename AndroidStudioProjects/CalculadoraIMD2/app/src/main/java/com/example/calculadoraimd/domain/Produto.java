package com.example.calculadoraimd.domain;
import java.io.Serializable;

public class Produto implements Serializable  {

    // Atributos
    private String codigoProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private Integer estoque;

    public Produto(String codigoProduto, String nomeProduto, String descricaoProduto, Integer estoque) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.estoque = estoque;
    }

    // Métodos Getter e Setter para codigoProduto
    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    // Métodos Getter e Setter para nomeProduto
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    // Métodos Getter e Setter para descricaoProduto
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    // Métodos Getter e Setter para estoque
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


    @Override
    public String toString() {
        return "{" +
                "\"code\": \"" + codigoProduto + "\"," +
                "\"name\": \"" + nomeProduto + "\"," +
                "\"description\": \"" + descricaoProduto + "\"," +
                "\"stock\": " + estoque +
                "}";
    }
}
