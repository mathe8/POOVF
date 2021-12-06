package com.supermercado.main;

import com.supermercado.sistema.usuario.Cliente;
import com.supermercado.sistema.externo.Produto;
import com.supermercado.sistema.externo.Caixa;

public class Main {

    public static void main(String[] args) {
	    Produto produto_Um   = new Produto("A", "zxc", 10, 1.0, true, 10.0, "abc");
        Produto produto_Dois = new Produto("B", "qwe", 10, 5.5, true, 2.0, "abc");
        Produto produto_Tres = new Produto("C", "asd", 10, 2.0, true, 5.0, "abc");

        Cliente consumidor = new Cliente("Zalee Sean Diceli", "123.325.121-00", 10.0);

        consumidor.atribuirCarrinho();
        consumidor.getCarrinho().adicionarNoCarrinho(produto_Dois, 2);
        consumidor.getCarrinho().adicionarNoCarrinho(produto_Tres, 1);

        Caixa c1 = new Caixa();
        c1.realizarCompra(consumidor);
    }
}
