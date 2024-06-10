package com.system.Funcionarios;

public class Gerente extends Funcionario{
    public Double salario;

    public Gerente(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    public void alterarSalarioPorCpf(String cpf, double salario){
        Equipe.modificarSalario(cpf, salario);
    }
    
    public void alterarCargoPorCpf(String cpf){
        Equipe.modificarCargo(cpf);
    }
}   