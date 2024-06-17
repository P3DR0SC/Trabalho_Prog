package com.system.Funcionarios;

/**
 * Classe abstrata que representa um funcionário.
 * Implementa a interface iPessoa.
 */
public abstract class Funcionario implements iPessoa {
    private double salario;
    public final String nome;
    public final String cpf;

    /**
     * Construtor da classe Funcionario.
     *
     * @param nome    O nome do funcionário.
     * @param cpf     O CPF do funcionário.
     * @param salario O salário do funcionário.
     */
    public Funcionario(String nome, String cpf, double salario) {
        this.salario = salario;
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * Mostra o status do funcionário.
     * Exibe o nome do funcionário no formato especificado.
     */
    void mostrarStatus() {
        System.out.format("O funcionário %s", nome);
    }

    /**
     * Retorna o salário do funcionário.
     *
     * @return O salário do funcionário.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Define o salário do funcionário.
     *
     * @param salario O novo salário do funcionário.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
