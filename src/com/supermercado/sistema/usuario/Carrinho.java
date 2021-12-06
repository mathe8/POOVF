package com.supermercado.sistema.usuario;

import com.supermercado.sistema.externo.Produto;

import java.util.ArrayList;
import java.util.UUID;

public class Carrinho {

    final private String dono;
    final private String codigo;
    private ArrayList<ItemCarrinho> itens;
    private ArrayList<Produto> listaProdutos;

    public Carrinho(String dono) {
        this.dono = dono;
        this.codigo = UUID.randomUUID().toString();
        this.itens = new ArrayList<ItemCarrinho>();
        this.listaProdutos = new ArrayList<Produto>();
    }

    public String getDono() {
        return dono;
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }

    public void adicionarNoCarrinho(Produto produto, Integer quantidade) {
        if ((produto.getQuantidade() != 0) && (produto.getQuantidade() >= quantidade)) {
            boolean existeNoCarrinho = false;

            for (ItemCarrinho item : this.itens){
                if (item.getCodigoDeBarras().equals(produto.getCodigoDeBarras())) {
                    item.adicionarNaQuantidade(quantidade);
                    existeNoCarrinho = true;
                }
            }

            if (!existeNoCarrinho) {
                this.itens.add(new ItemCarrinho(produto.getNome(), quantidade, produto.getPrecoUnd(), produto.getCodigoDeBarras()));
            }

            if (!listaProdutos.contains(produto)){
                this.listaProdutos.add(produto);
            }

            produto.subtrairNaQuantidade(quantidade);
        } else {
            System.out.println("Quantidade inválida. Disponível: "+produto.getQuantidade());
        }
    }

    public void removerNoCarrinho(Produto produto, Integer quantidade) {
        boolean existeNoCarrinho = false;

        for (ItemCarrinho item : this.itens){
            if (item.getCodigoDeBarras().equals(produto.getCodigoDeBarras())) {
                item.removerNaQuantidade(quantidade);
                produto.somarNaQuantidade(quantidade);
                existeNoCarrinho = true;
            }
        }

        if (!existeNoCarrinho) {
            System.out.println("Produto "+produto.getNome()+": Não foi possível remover. Esse produto não está no carrinho.");
        }
    }

    public void limparTodosOsProdutosEDevolverAsPrateleiras() {
        this.itens.forEach(item -> {
            listaProdutos.forEach(produto -> {
                if (produto.getCodigoDeBarras().equals(item.getCodigoDeBarras())){
                    produto.somarNaQuantidade(item.getQuantidade());
                }
            });
        });
        this.itens.clear();
        this.listaProdutos.clear();
    }
}
