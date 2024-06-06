package com.system.Funcionarios;

public class Funcionario implements iPessoa{
    double salario;
    String cargo;
    public final String nome; 
    public final String cpf; 

    public Funcionario(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        System.out.println("Funcionário criado com sucesso!");        
    }

void mostrarStatus(){
    System.out.format("O funcionário %s está %s no momento." , nome, cargo);

    }

void empacotar(){

}
void passar(){

}
void fiscalizar(){

}

}