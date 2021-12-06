package com.supermercado.sistema.externo;

import com.supermercado.sistema.usuario.ItemCarrinho;

import java.util.ArrayList;
import java.util.UUID;

public class NotaFiscal {

    final private ArrayList<ItemCarrinho> listaProdutos;
    final private Double valor;
    final private String cpf;
    final private String nomeConsumidor;
    final private String chave;

    public NotaFiscal(ArrayList<ItemCarrinho> listaProdutos, Double valor, String cpf, String nomeConsumidor) {
        this.listaProdutos = listaProdutos;
        this.valor = valor;
        this.cpf = cpf;
        this.nomeConsumidor = nomeConsumidor;
        this.chave = UUID.randomUUID().toString();
    }

    public ArrayList<ItemCarrinho> getListaProdutos() {
        return listaProdutos;
    }

    public Double getValor() {
        return valor;
    }

    public String getCpf() {
        return cpf;
    }

    public String getChave() {
        return chave;
    }

    public String getNomeConsumidor() {
        return nomeConsumidor;
    }

    public void imprimirValores() {
        if (!this.listaProdutos.isEmpty()) {
            System.out.println("\n______________ Supermercado _______________");
            System.out.println("___________________________________________");
            System.out.println("_______________ Informações _______________");
            System.out.println(
                    "Valor Total:       R$" + this.valor +
                            "\nCPF (Consumidor):  " + this.cpf +
                            "\nNome:              " + this.nomeConsumidor
            );
            System.out.println("___________________________________________");
            System.out.println("________________ Produtos _________________");
            this.listaProdutos.forEach(produto ->
                    System.out.println(produto.getNome() + "...... " + produto.getQuantidade() + "x und. " + produto.getPrecoUnd() + " ... Total: R$" + produto.getQuantidade() * produto.getPrecoUnd())
            );

            System.out.println("\nChave: "+getChave());
            System.out.println("___________________________________________\n");
        } else {
            System.out.println("Erro ao imprimir nota fiscal: Nenhum produto encontrado.");
        }
    }
}
