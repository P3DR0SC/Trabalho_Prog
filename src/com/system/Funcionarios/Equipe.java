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
    public static void modificarSalario(String cpf, double reajuste){
        for(Funcionario f:funcionarios){
            System.out.println("f:" + f.cpf + " cpf" + cpf);
            if(f.cpf.equals(cpf)){
                f.setSalario(reajuste);

                return;
            }
        }
        System.out.println("Funcionário não encontrado!");

    }
    public static void listarFuncionarios(){
        if(funcionarios.size() > 0){
            for(Funcionario f:funcionarios){
                System.out.println("Nome: " + f.nome);
                System.out.println("Salário: " + f.getSalario());
            }
        }

    }
}
