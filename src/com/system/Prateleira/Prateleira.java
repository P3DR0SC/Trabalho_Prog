
package com.system.Prateleira;

import java.util.Vector;

public class Prateleira {

    static Vector<Produto> produtos = new Vector<Produto>();

    public static void addProduto(Produto p) {
        produtos.add(p);
    }

    public static Produto encontrarProduto(String nomeProduto) {
        if (!produtos.isEmpty()) {
            for (Produto p : produtos) {
                if (nomeProduto.equals(p.getNome())) {
                    return p;
                }
            }
        }
        return null;
    }
    

    public static Produto removeProduto(int index) {
        Produto res = produtos.get(index);
        produtos.remove(index);
        return res;
    }

    public static Produto removeProduto(Produto p) {
        produtos.remove(p);
        return p;
    }
    
    public static boolean possuiProdutos(){
        return !produtos.isEmpty();
    }
    
    public static void listar(){
        if(!produtos.isEmpty()){
            for(Produto p:produtos){
                System.out.println("Produto: " + p.nome);
                System.out.println("Categoria: " + p.categoria);
                System.out.println("---------------");
            }
        }
        else{
            System.out.println("Não há nenhuma caixa cadastrado no momento");
        }
    }
    
}
