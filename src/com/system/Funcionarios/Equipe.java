package com.system.Funcionarios;

import java.util.Vector;

/**
 * Classe que gerencia uma equipe de funcionários.
 */
public class Equipe {

    /** Lista de funcionários da equipe. */
    static Vector<Funcionario> funcionarios = new Vector<>();

    /**
     * Adiciona um funcionário à equipe.
     *
     * @param f O funcionário a ser adicionado.
     */
    public static void addFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    /**
     * Remove um funcionário da equipe pelo índice.
     *
     * @param index O índice do funcionário a ser removido.
     */
    public static void removeFuncionario(int index) {
        funcionarios.remove(index);
    }

    /**
     * Remove um funcionário da equipe pelo CPF.
     *
     * @param cpf O CPF do funcionário a ser removido.
     */
    public static void removeFuncionario(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.cpf.equals(cpf)) {
                funcionarios.remove(funcionarios.indexOf(f));
                System.out.println("Funcionário excluído com sucesso");
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }

    /**
     * Modifica o cargo de um funcionário baseado no CPF.
     *
     * @param cpf O CPF do funcionário cujo cargo será modificado.
     */
    public static void modificarCargo(String cpf) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario prev = funcionarios.get(i);
            if (prev.cpf.equals(cpf)) {
                Funcionario novo;
                if (prev instanceof Carregador) {
                    novo = new Estoquista(prev.nome, prev.cpf, prev.getSalario());
                } else {
                    novo = new Carregador(prev.nome, prev.cpf, prev.getSalario());
                }
                funcionarios.set(i, novo);
                System.out.println("Cargo alterado com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }

    /**
     * Modifica o salário de um funcionário baseado no CPF.
     *
     * @param cpf      O CPF do funcionário cujo salário será modificado.
     * @param reajuste O novo salário a ser definido.
     */
    public static void modificarSalario(String cpf, double reajuste) {
        for (Funcionario f : funcionarios) {
            if (f.cpf.equals(cpf)) {
                if (f.getSalario() <= reajuste) {
                    System.out.println("Reajuste não pode ser aplicado");
                } else {
                    f.setSalario(reajuste);
                }
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }

    /**
     * Lista todos os funcionários da equipe.
     */
    public static void listarFuncionarios() {
        if (!funcionarios.isEmpty()) {
            for (Funcionario f : funcionarios) {
                System.out.println("Nome: " + f.nome);
                System.out.println("Cpf: " + f.cpf);
                System.out.println("Salário: " + f.getSalario());
                System.out.println("---------------");
            }
        } else {
            System.out.println("Não há nenhum funcionário cadastrado no momento");
        }
    }

    /**
     * Lista todos os carregadores da equipe.
     */
    public static void selecionarCarregador() {
        if (!funcionarios.isEmpty()) {
            for (Funcionario f : funcionarios) {
                if (f instanceof Estoquista) continue;
                System.out.println("Nome: " + f.nome);
                System.out.println("Cpf: " + f.cpf);
                System.out.println("Salário: " + f.getSalario());
                System.out.println("---------------");
            }
        } else {
            System.out.println("Não há nenhum funcionário cadastrado no momento");
        }
    }

    /**
     * Lista todos os estoquistas da equipe.
     */
    public static void selecionarEstoquista() {
        if (!funcionarios.isEmpty()) {
            for (Funcionario f : funcionarios) {
                if (f instanceof Carregador) continue;
                System.out.println("Nome: " + f.nome);
                System.out.println("Cpf: " + f.cpf);
                System.out.println("Salário: " + f.getSalario());
                System.out.println("---------------");
            }
        } else {
            System.out.println("Não há nenhum funcionário cadastrado no momento");
        }
    }

    /**
     * Verifica se a equipe possui funcionários.
     *
     * @return true se a equipe possui funcionários, false caso contrário.
     */
    public static boolean possuiFuncionarios() {
        return !funcionarios.isEmpty();
    }

    /**
     * Verifica se a equipe possui carregadores.
     *
     * @return true se a equipe possui carregadores, false caso contrário.
     */
    public static boolean possuiCarregadores() {
        if (!funcionarios.isEmpty()) {
            for (Funcionario f : funcionarios) {
                if (f instanceof Carregador) return true;
            }
        }
        return false;
    }

    /**
     * Verifica se a equipe possui estoquistas.
     *
     * @return true se a equipe possui estoquistas, false caso contrário.
     */
    public static boolean possuiEstoquistas() {
        if (!funcionarios.isEmpty()) {
            for (Funcionario f : funcionarios) {
                if (f instanceof Estoquista) return true;
            }
        }
        return false;
    }

    /**
     * Retorna um carregador baseado no CPF.
     *
     * @param cpf O CPF do carregador a ser retornado.
     * @return O carregador com o CPF especificado ou null se não encontrado.
     */
    public static Carregador getCarregadorPorCPF(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.cpf.equals(cpf)) {
                if (f instanceof Carregador)
                    return (Carregador) f;
            }
        }
        System.out.println("Funcionário não encontrado!");
        return null;
    }

    /**
     * Retorna um estoquista baseado no CPF.
     *
     * @param cpf O CPF do estoquista a ser retornado.
     * @return O estoquista com o CPF especificado ou null se não encontrado.
     */
    public static Estoquista getEstoquistaPorCPF(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.cpf.equals(cpf)) {
                if (f instanceof Estoquista)
                    return (Estoquista) f;
            }
        }
        System.out.println("Funcionário não encontrado!");
        return null;
    }
}
