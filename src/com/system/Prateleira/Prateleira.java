package com.system.Prateleira;

import java.util.Vector;

public class Prateleira {

    static Vector<Produto> produtos = new Vector<>();

    public static void addProduto(Produto p) {
        produtos.add(p);
    }

    public static Produto encontrarProduto(String nomeProduto) {
        if (!produtos.isEmpty()) {
            for (Produto p : produtos) {
                if (nomeProduto.equalsIgnoreCase(p.getNome())) {
                    return p;
                }
            }
        }
        return null;
    }

    public static Produto removeProduto(int index) {
        if (index >= 0 && index < produtos.size()) {
            return produtos.remove(index);
        }
        return null;
    }

    public static Produto removeProduto(Produto p) {
        if (produtos.remove(p)) {
            return p;
        }
        return null;
    }

    public static boolean possuiProdutos() {
        return !produtos.isEmpty();
    }

    public static void listar() {
        if (!produtos.isEmpty()) {
            for (Produto p : produtos) {
                System.out.println("Produto: " + p.getNome());
                System.out.println("Categoria: " + p.getCategoria());
                System.out.println("---------------");
            }
        } else {
            System.out.println("Não há nenhum produto cadastrado no momento");
        }
    }
}