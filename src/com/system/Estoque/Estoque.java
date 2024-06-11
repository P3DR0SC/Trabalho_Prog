package com.system.Estoque;

import java.util.Vector;

public class Estoque {
    static Vector<Caixa> caixas = new Vector<Caixa>();
    
   public static void addCaixa(Caixa c) {
    caixas.add(c);
   }

   public static Caixa removeCaixa(int index) {
        Caixa res = caixas.get(index);
        caixas.remove(index);
        return res;
    }

    public static Caixa removeCaixa(Caixa c) {
        caixas.remove(c);
        return c;
    }

    public static Vector<Caixa> getCaixas() {
        return caixas;
    }
    
    public static boolean possuiEstoque(){
        return !caixas.isEmpty();
    }
    
    public static void listar(){
        if(!caixas.isEmpty()){
            for(Caixa c:caixas){
                System.out.println("Produto: " + c.getProduto().nome);
                System.out.println("---------------");
            }
        }
        else{
            System.out.println("Não há nenhuma caixa cadastrado no momento");
        }
    }
    
    public static Caixa pegarCaixa(String produto) {
        if (!caixas.isEmpty()) {
            for (Caixa c : caixas) {
                if (c.getProduto() != null && c.getProduto().nome.equalsIgnoreCase(produto)) {
                    return c;
                }
            }
        }
        System.out.println("Caixa com produto não encontrada!");
        return null;
    }
    
}
