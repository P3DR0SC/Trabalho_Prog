package com.system.Prateleira;

public class Produto {
    public String nome;
    public String categoria;

    public Produto(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;

        System.out.println("Produto criado com sucesso!");
    }

    public String getNome() {
        return nome;
    }

}