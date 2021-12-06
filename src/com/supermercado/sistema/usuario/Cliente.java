package com.supermercado.sistema.usuario;

import com.supermercado.sistema.externo.NotaFiscal;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    final private String cpf;
    private Double dinheiroNaCarteira;
    private ArrayList<NotaFiscal> notasFiscais;
    private Carrinho carrinho;
    private Boolean possuiCarrinho;

    public Cliente(String nome, String cpf, Double dinheiroNaCarteira) {
        this.nome = nome;
        this.cpf = cpf;
        this.dinheiroNaCarteira = dinheiroNaCarteira;
        this.notasFiscais = new ArrayList<NotaFiscal>();
        this.possuiCarrinho = false;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public Double getDinheiroNaCarteira() {
        return dinheiroNaCarteira;
    }

    public ArrayList<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Boolean getPossuiCarrinho() {
        return possuiCarrinho;
    }

    public void adicionarDinheiroNaCarteira(Double valor){
        this.dinheiroNaCarteira += valor;
    }

    public void retirarDinheiroNaCarteira(Double valor){
        this.dinheiroNaCarteira -= valor;
    }

    public void adicionarNotaFiscal(NotaFiscal notaFiscal) {
        this.notasFiscais.add(notaFiscal);
    }

    public void atribuirCarrinho() {
        if (!possuiCarrinho) {
            this.carrinho = new Carrinho(this.nome);
            this.possuiCarrinho = true;
        }
    }

    public void removerCarrinho() {
        if (possuiCarrinho) {
            this.carrinho = null;
            this.possuiCarrinho = false;
        }
    }
}
