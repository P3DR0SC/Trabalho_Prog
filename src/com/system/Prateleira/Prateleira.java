
package com.system.Prateleira;

import java.util.Vector;

public class Prateleira {

    static Vector<Produto> produtos = new Vector<Produto>();

    public static void addProduto(Produto p) {
        produtos.add(p);
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
}
