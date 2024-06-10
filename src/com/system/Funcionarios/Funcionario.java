package com.system.Funcionarios;

public abstract class Funcionario implements iPessoa {
    private double salario;

    public final String nome;
    public final String cpf;

    public Funcionario(String nome, String cpf, double salario) {
        this.salario = salario;
        this.nome = nome;
        this.cpf = cpf;
    }


    void mostrarStatus() {
        System.out.format("O funcionário %s", nome);

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}