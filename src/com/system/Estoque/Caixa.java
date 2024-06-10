package com.system.Estoque;

import com.system.Prateleira.Produto;

public class Caixa {
    private Produto produto;
        
    public Caixa(Produto produto){
        this.produto = produto;
    }
    
    public Produto removerDaCaixa(){
        Produto p = this.produto;
        this.produto = null;
        return p;
    }

    public Produto getProduto(){
        return this.produto;
    }
}
