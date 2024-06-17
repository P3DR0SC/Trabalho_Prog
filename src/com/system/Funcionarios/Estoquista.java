
package com.system.Funcionarios;

import com.system.Estoque.Caixa;
import com.system.Estoque.Estoque;
import com.system.Prateleira.Produto;

/**
 * Classe que representa um estoquista, um tipo de funcionário.
 */
public class Estoquista extends Funcionario {

    /**
     * Construtor da classe Estoquista.
     *
     * @param nome    O nome do estoquista.
     * @param cpf     O CPF do estoquista.
     * @param salario O salário do estoquista.
     */
    public Estoquista(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
        System.out.println("Funcionário criado com sucesso!");
    }

    /**
     * Empacota um produto em uma caixa.
     *
     * @param p O produto a ser empacotado.
     * @return A caixa contendo o produto.
     */
    public Caixa empacotar(Produto p) {
        Caixa c = new Caixa(p);
        return c;
    }

    /**
     * Adiciona uma caixa ao estoque.
     *
     * @param c A caixa a ser adicionada ao estoque.
     */
    public void colocarNoEstoque(Caixa c) {
        Estoque.addCaixa(c);
    }

    /**
     * Empacota um produto em uma caixa e a adiciona ao estoque.
     *
     * @param p O produto a ser empacotado e adicionado ao estoque.
     */
    public void colocarNoEstoque(Produto p) {
        Caixa c = new Caixa(p);
        Estoque.addCaixa(c);
    }
}

