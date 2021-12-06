package com.supermercado.sistema.externo;

import java.lang.Math;

public class Produto {

    private String nome;
    private String marca;
    private Integer quantidade;
    private Double peso;
    private Boolean disponivel;
    private Double precoUnd;
    private String categoria;
    final private long codigoDeBarras;

    public Produto(String nome, String marca, Integer quantidade, Double peso, Boolean disponivel, Double precoUnd, String categoria) {
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
        this.peso = peso;
        this.disponivel = disponivel;
        this.precoUnd = precoUnd;
        this.categoria = categoria;
        this.codigoDeBarras = gerarCodigoDeBarras();
    }

    private Long gerarCodigoDeBarras(){
        long max = 9999999999999L;
        long min = 1000000000001L;
        return (long) ((Math.random() * (max - min)) + min);
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPeso() {
        return peso;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public Double getPrecoUnd() {
        return precoUnd;
    }

    public String getCategoria() {
        return categoria;
    }

    public Long getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void somarNaQuantidade(Integer quantidade) {
        this.quantidade += quantidade;
    }

    public void subtrairNaQuantidade(Integer quantidade) {
        this.quantidade -= quantidade;
    }
}
