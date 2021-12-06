package com.supermercado.sistema.usuario;

public class ItemCarrinho {

    private String nome;
    private Integer quantidade;
    private Double precoUnd;
    final private Long codigoDeBarras;

    public ItemCarrinho(String nome, Integer quantidade, Double precoUnd, Long codigoDeBarras) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnd = precoUnd;
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPrecoUnd() {
        return precoUnd;
    }

    public Long getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void adicionarNaQuantidade(Integer quantidade){
        this.quantidade += quantidade;
    }

    public void removerNaQuantidade(Integer quantidade){
        this.quantidade -= quantidade;
    }
}
