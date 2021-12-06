package com.supermercado.sistema.externo;

import com.supermercado.sistema.usuario.Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Caixa {

    private Double valorTotal;

    public void realizarCompra(Cliente cliente){
        this.valorTotal = 0.00;
        try {
            processarValorCompra(cliente);

            if (!cliente.getCarrinho().getItens().isEmpty()) {
                int prosseguir = 0;
                boolean repetir = true;
                Scanner input = new Scanner(System.in);
                do {
                    try {
                        System.out.print("\nO valor total da compra é: R$" + this.valorTotal + "\nDeseja prosseguir com a compra? 1. Sim / 2. Não: ");
                        prosseguir = input.nextInt();
                        repetir = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Apenas números inteiros!");
                        input.nextLine();
                    }
                } while (repetir);

                if (prosseguir == 1) {
                    if (this.valorTotal <= cliente.getDinheiroNaCarteira()) {
                        cliente.retirarDinheiroNaCarteira(valorTotal);

                        NotaFiscal cupom = new NotaFiscal(cliente.getCarrinho().getItens(), valorTotal, cliente.getCPF(), cliente.getNome());
                        cliente.adicionarNotaFiscal(cupom);
                        cupom.imprimirValores();
                    } else {
                        System.out.println("Você não possui dinheiro suficiente na carteira. Cancelando compra...");
                    }
                } else if (prosseguir == 2) {
                    System.exit(0);
                }
            } else {
                System.out.println("Seu carrinho está vazio! Não foi possível prosseguir com sua compra.");
            }
        }finally{
            cliente.getCarrinho().limparTodosOsProdutosEDevolverAsPrateleiras();
            cliente.removerCarrinho();
        }
    }

    private void processarValorCompra(Cliente cliente){
        cliente.getCarrinho().getItens().forEach(item -> atualizarValorCompra(item.getPrecoUnd(), item.getQuantidade()));
    }

    private void atualizarValorCompra(Double valor, Integer quantidade){
        this.valorTotal += valor * quantidade;
    }
}
