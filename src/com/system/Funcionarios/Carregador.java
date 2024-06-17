
package com.system.Funcionarios;

import com.system.Estoque.Caixa;
import com.system.Estoque.Estoque;
import com.system.Prateleira.Prateleira;
import com.system.Prateleira.Produto;

/**
 * Classe que representa um Carregador, um tipo de Funcionario responsável por
 * mover produtos para a prateleira.
 */
public class Carregador extends Funcionario {

    /**
     * Construtor para criar um novo Carregador.
     *
     * @param nome    O nome do Carregador.
     * @param cpf     O CPF do Carregador.
     * @param salario O salário do Carregador.
     */
    public Carregador(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
        System.out.println("Funcionário criado com sucesso!");
    }

    /**
     * Move a Caixa do estoque para a prateleira.
     *
     * @param caixa A Caixa a ser movida para a prateleira.
     */
    public void colocarNaPrateleira(Caixa caixa) {
        Estoque.removeCaixa(caixa);
        Prateleira.addProduto(caixa.removerDaCaixa());
        System.out.println("Produto adicionado a prateleira");
    }

    /**
     * Adiciona diretamente um Produto à prateleira.
     *
     * @param produto O Produto a ser adicionado à prateleira.
     */
    public void colocarNaPrateleira(Produto produto) {
        Prateleira.addProduto(produto);
        System.out.println("Produto adicionado a prateleira");
    }
}
