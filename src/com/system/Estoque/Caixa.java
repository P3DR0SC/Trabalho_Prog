package com.system.Estoque;

import com.system.Prateleira.Produto;

public class Caixa {
    private Produto produto;
        
    public Caixa(Produto produto){
        this.produto = produto;
    }

    public Produto getProduto(){
        Produto p = this.produto;
        this.produto = null;
        return p;
    }
}
