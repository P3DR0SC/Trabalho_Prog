package com.system.Funcionarios;

import java.util.Vector;

public class Equipe {

   static Vector<Funcionario> funcionarios = new Vector<Funcionario>();
    
   public static void addFuncionario(Funcionario f) {
        funcionarios.add(f);
   }

   public static void removeFuncionario(int index) {
        funcionarios.remove(index);
    }

    public static void removeFuncionario(Funcionario f) {
        funcionarios.remove(f);
    }
}
