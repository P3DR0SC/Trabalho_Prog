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
    
    public static void modificarCargo(String cpf){
        
        for (int i = 0; i < funcionarios.size(); i++)  
        { 
            Funcionario prev = funcionarios.get(i);
            if(prev.cpf.equals(cpf)){
                Funcionario novo;
                if(prev instanceof Carregador){
                    novo = new Estoquista(prev.nome, prev.cpf, prev.getSalario());
                } else{
                    novo = new Carregador(prev.nome, prev.cpf, prev.getSalario());
                }
                funcionarios.set(i, novo);
                System.out.println("Cargo alterado com sucesso!");
                return;
            }
        } 

        System.out.println("Funcionário não encontrado!");
    }
    
    public static void modificarSalario(String cpf, double reajuste){
        for(Funcionario f:funcionarios){
            if(f.cpf.equals(cpf)){
                
                if(f.getSalario() <= reajuste){
                    System.out.println("Reajuste não pode ser aplicado");
                }
                else
                f.setSalario(reajuste);

                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }
    
    public static void listarFuncionarios(){
        if(!funcionarios.isEmpty()){
            for(Funcionario f:funcionarios){
                System.out.println("Nome: " + f.nome);
                System.out.println("Cpf: " + f.cpf);
                System.out.println("Salário: " + f.getSalario());
                System.out.println("---------------");
            }
        }
        else{
            System.out.println("Não há nenhum funcionário cadastrado no momento");
        }
    }
       
    public static void selecionarCarregador(){
        if(!funcionarios.isEmpty()){
            for(Funcionario f:funcionarios){
                if(f instanceof Estoquista) continue;
                System.out.println("Nome: " + f.nome);
                System.out.println("Cpf: " + f.cpf);
                System.out.println("Salário: " + f.getSalario());
                System.out.println("---------------");
            }
        }
        else{
            System.out.println("Não há nenhum funcionário cadastrado no momento");
        }
    }
    
        public static void selecionarEstoquista(){
        if(!funcionarios.isEmpty()){
            for(Funcionario f:funcionarios){
                if(f instanceof Carregador) continue;
                System.out.println("Nome: " + f.nome);
                System.out.println("Cpf: " + f.cpf);
                System.out.println("Salário: " + f.getSalario());
                System.out.println("---------------");
            }
        }
        else{
            System.out.println("Não há nenhum funcionário cadastrado no momento");
        }
    }
    
    public static boolean possuiFuncionarios(){
        return !funcionarios.isEmpty();
    }
    
    public static boolean possuiCarregadores(){
        if(!funcionarios.isEmpty()){
            for(Funcionario f:funcionarios){
                if(f instanceof Carregador) return true;
            }
        }
        return false;
    }

    public static boolean possuiEstoquistas(){
        if(!funcionarios.isEmpty()){
            for(Funcionario f:funcionarios){
                if(f instanceof Estoquista) return true;
            }
        }
        return false;
    }
    
    public static Carregador getCarregadorPorCPF(String cpf){
        for(Funcionario f:funcionarios){
            if(f.cpf.equals(cpf)){
                if(f instanceof Carregador)
                    return (Carregador) f;
            }
        }
        System.out.println("Funcionário não encontrado!");
        return null;
    }

    public static Estoquista getEstoquistaPorCPF(String cpf){
        for(Funcionario f:funcionarios){
            if(f.cpf.equals(cpf)){
                if(f instanceof Estoquista)
                    return (Estoquista) f;
            }
        }
        System.out.println("Funcionário não encontrado!");
        return null;
    }
}
