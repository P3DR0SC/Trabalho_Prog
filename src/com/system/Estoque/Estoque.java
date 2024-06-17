package com.system.Estoque;

import java.util.Vector;



/**
 * Representa o estoque que contém várias caixas de produtos.
 */
public class Estoque {
    // Lista de caixas no estoque
    private static Vector<Caixa> caixas = new Vector<>();

    /**
     * Adiciona uma caixa ao estoque.
     *
     * @param c A caixa a ser adicionada.
     */
    public static void addCaixa(Caixa c) {
        caixas.add(c);
    }

    /**
     * Remove uma caixa do estoque com base no índice especificado.
     *
     * @param index O índice da caixa a ser removida.
     * @return A caixa removida, ou null se o índice estiver fora dos limites.
     */
    public static Caixa removeCaixa(int index) {
        if (index >= 0 && index < caixas.size()) {
            return caixas.remove(index);
        }
        return null;
    }

    /**
     * Remove uma caixa específica do estoque.
     *
     * @param c A caixa a ser removida.
     * @return A caixa removida, ou null se a caixa não estiver no estoque.
     */
    public static Caixa removeCaixa(Caixa c) {
        if (caixas.remove(c)) {
            return c;
        }
        return null;
    }

    /**
     * Retorna todas as caixas no estoque.
     *
     * @return Um vetor de caixas no estoque.
     */
    public static Vector<Caixa> getCaixas() {
        return caixas;
    }

    /**
     * Verifica se o estoque possui caixas.
     *
     * @return true se o estoque tiver caixas, false caso contrário.
     */
    public static boolean possuiEstoque() {
        return !caixas.isEmpty();
    }

    /**
     * Lista todos os produtos nas caixas do estoque.
     */
    public static void listar() {
        if (!caixas.isEmpty()) {
            for (Caixa c : caixas) {
                if (c.getProduto() != null) {
                    System.out.println("Produto: " + c.getProduto().getNome());
                    System.out.println("---------------");
                }
            }
        } else {
            System.out.println("Não há nenhuma caixa cadastrada no momento");
        }
    }

    /**
     * Obtém a caixa que contém o produto especificado.
     *
     * @param produto O nome do produto a ser procurado.
     * @return A caixa que contém o produto, ou null se não for encontrada.
     */
    public static Caixa pegarCaixa(String produto) {
        if (!caixas.isEmpty()) {
            for (Caixa c : caixas) {
                if (c.getProduto() != null && c.getProduto().getNome().equalsIgnoreCase(produto)) {
                    return c;
                }
            }
        }
        System.out.println("Caixa com produto não encontrada!");
        return null;
    }
}
