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

    public static void removeFuncionario(String cpf) {
        for(Funcionario f:funcionarios){
            if(f.cpf.equals(cpf)){
                funcionarios.remove(funcionarios.indexOf(f));
                System.out.println("Funcionário excluido com sucesso");

                return;
            }
        }
        System.out.println("Funcionário não encontrado!");

    }
    public static void modificarSalario(String cpf, double reajuste){
        for(Funcionario f:funcionarios){
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
                System.out.println("Cpf: " + f.cpf);
                System.out.println("Salário: " + f.getSalario());
            }
        }
        else{
            System.out.println("Não há nenhum funcionário cadastrado no momento");
        }
    }
}
