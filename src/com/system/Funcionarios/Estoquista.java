
package com.system.Funcionarios;

import com.system.Estoque.Caixa;
import com.system.Estoque.Estoque;
import com.system.Prateleira.Produto;

public class Estoquista extends Funcionario{

    public Estoquista(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    
    public Caixa empacotar(Produto p){
        Caixa c = new Caixa(p);
        return c;
    }

    public void colocarNoEstoque(Caixa c){
        Estoque.addCaixa(c);
    }

    public void colocarNoEstoque(Produto p){
        Caixa c = new Caixa(p);
        Estoque.addCaixa(c);
    }
}
