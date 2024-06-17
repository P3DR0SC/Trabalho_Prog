package com.system.Funcionarios;

/**
 * Classe que representa um Gerente, que é um tipo de Funcionario.
 */
public class Gerente extends Funcionario {
    public Double salario;

    /**
     * Construtor da classe Gerente.
     *
     * @param nome    O nome do gerente.
     * @param cpf     O CPF do gerente.
     * @param salario O salário do gerente.
     */
    public Gerente(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }

    /**
     * Altera o salário de um funcionário com base no CPF.
     *
     * @param cpf     O CPF do funcionário cujo salário será alterado.
     * @param salario O novo salário do funcionário.
     */
    public void alterarSalarioPorCpf(String cpf, double salario) {
        Equipe.modificarSalario(cpf, salario);
    }

    /**
     * Altera o cargo de um funcionário com base no CPF.
     *
     * @param cpf O CPF do funcionário cujo cargo será alterado.
     */
    public void alterarCargoPorCpf(String cpf) {
        Equipe.modificarCargo(cpf);
    }
}
