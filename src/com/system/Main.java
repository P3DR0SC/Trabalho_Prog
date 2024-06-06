
package com.system;

import java.util.Scanner;

import com.system.Funcionarios.Carregador;
import com.system.Funcionarios.Equipe;
import com.system.Funcionarios.Estoquista;
import com.system.Funcionarios.Funcionario;
import com.system.Funcionarios.Gerente;

public class Main {
    public static void main(String[] args) {
        Gerente user = new Gerente(null, null, 0);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bem vindo ao sistema de gerenciamento, gerente");
            System.out.println("Selecione a opção desejada:");
            System.out.println("  1 - Cadastrar funcionário");
            System.out.println("  2 - Remover funcionário");
            System.out.println("  3 - Cadastrar recebimento de produto");
            System.out.println("  4 - Alterar salário de funcionário");
            System.out.println("  5 - Mover do estoque para a prateleira");
            System.out.println("  6 - Mover da prateleira para o estoque");

            System.out.println("  7 - Sair\n");

            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Insira o nome do funcionário: ");
                    String nome = scanner.nextLine();

                    System.out.println("Insira o cpf do funcionário: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Insira o cpf do funcionário: ");
                    double salario = scanner.nextDouble();

                    System.out.println("Selecione o cargo: ");
                    System.out.println("  1 - Estoquista");
                    System.out.println("  2 - Carregador");

                    int cargo = scanner.nextInt();

                    while (cargo < 1 || cargo > 2) {
                        System.out.println("Cargo inválido, tente novamente: ");
                        cargo = scanner.nextInt();
                    }

                    try {
                        Funcionario f;
                        if (cargo == 1) {
                            f = new Estoquista(nome, cpf, salario);
                        } else {
                            f = new Carregador(nome, cpf, salario);
                        }

                        Equipe.addFuncionario(f);
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar funcionário");
                    }

                    break;

                default:
                    return;
            }

        }
    }
}
