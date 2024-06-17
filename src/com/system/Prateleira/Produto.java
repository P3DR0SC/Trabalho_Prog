package com.system.Prateleira;

/**
 * A classe Produto representa um item que pode ser armazenado em uma prateleira.
 */
public class Produto {
    private String nome; // O nome do produto
    private String categoria; // A categoria do produto

    /**
     * Construtor da classe Produto.
     * @param nome O nome do produto.
     * @param categoria A categoria do produto.
     */
    public Produto(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    /**
     * Obtém o nome do produto.
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a categoria do produto.
     * @return A categoria do produto.
     */
    public String getCategoria() {
        return categoria;
    }
}