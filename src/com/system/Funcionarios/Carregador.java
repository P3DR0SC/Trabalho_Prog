
package com.system.Funcionarios;

import com.system.Estoque.Caixa;
import com.system.Estoque.Estoque;
import com.system.Prateleira.Prateleira;
import com.system.Prateleira.Produto;

public class Carregador extends Funcionario{

    public Carregador(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
        System.out.println("Funcionário criado com sucesso!");
    }
    
    public void colocarNaPrateleira(Caixa caixa){
        Estoque.removeCaixa(caixa);
        Prateleira.addProduto(caixa.removerDaCaixa());
        System.out.println("Produto adicionado a prateleira");
    }
    
    public void colocarNaPrateleira(Produto produto){
        Prateleira.addProduto(produto);
        System.out.println("Produto adicionado a prateleira");
    }
}
