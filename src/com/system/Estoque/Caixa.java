package com.system.Estoque;

import com.system.Prateleira.Produto;

/**
 * Representa uma caixa que pode conter um único produto.
 */
public class Caixa {
    private Produto produto; // O produto armazenado na caixa

    /**
     * Cria uma nova instância de Caixa com o produto especificado.
     *
     * @param produto O produto a ser armazenado na caixa.
     */
    public Caixa(Produto produto) {
        this.produto = produto;
    }

    /**
     * Remove o produto da caixa e retorna-o.
     *
     * @return O produto removido da caixa, ou null se a caixa estiver vazia.
     */
    public Produto removerDaCaixa() {
        Produto p = this.produto;
        this.produto = null; // Remove o produto da caixa
        return p; // Retorna o produto removido
    }

    /**
     * Obtém o produto atualmente armazenado na caixa.
     *
     * @return O produto armazenado na caixa, ou null se a caixa estiver vazia.
     */
    public Produto getProduto() {
        return this.produto;
    }
}
