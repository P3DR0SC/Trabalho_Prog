package com.system.Estoque;

import java.util.Vector;

import com.system.Funcionarios.Carregador;

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
    
    
}
