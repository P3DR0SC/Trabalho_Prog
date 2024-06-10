package com.system;

import java.util.Scanner;

import com.system.Estoque.*;
import com.system.Funcionarios.*;
import com.system.Prateleira.Produto;

public class Main {

    // menu principal, onde são listadas as opções aos usuários.
    public static void menuPrincipal() {
        Gerente user = new Gerente(null, null, 0);
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBem vindo ao sistema de gerenciamento, gerente\n");
        System.out.println("            ------======------          ");
        System.out.println("Selecione a opção desejada:");
        System.out.println("  1 - Cadastrar funcionário");
        System.out.println("  2 - Remover funcionário");
        System.out.println("  3 - Cadastrar recebimento de produto");
        System.out.println("  4 - Atualizar funcionário");
        System.out.println("  5 - Mover do estoque para a prateleira");
        System.out.println("  6 - Mover da prateleira para o estoque");
        System.out.println("  7 - Listar funcionários");
        System.out.println("  8 - Listar estoque");
        System.out.println("  9 - Listar produtos nas prateleira");
        System.out.println("  0 - Sair");
        System.out.println("            ------======------          ");

        int op = scanner.nextInt();
        scanner.nextLine();

        // Opção 1 cadastra um novo funcionário
        switch (op) {
            case 1:
                System.out.println("Insira o nome do funcionário: ");
                String nome = scanner.nextLine();

                System.out.println("Insira o cpf do funcionário: ");
                String cpf = scanner.nextLine();

                System.out.println("Insira o salário do funcionário: ");
                double salario = scanner.nextDouble();
                // Cadastra o cargo
                System.out.println("Selecione o cargo: ");
                System.out.println("  1 - Estoquista");
                System.out.println("  2 - Carregador");

                int cargo = scanner.nextInt();
                // avisa o usuário caso o input seja inválido
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
                menuPrincipal();
                break;

            case 2:
                if(!Equipe.possuiFuncionarios()){
                    System.out.println("Sem funcionários cadastrados!");
                    menuPrincipal();
                    break;
                }
                
                System.out.println("Deseja listar os funcionários? ");
                System.out.println("  1 - Sim");
                System.out.println("  2 - Não");
                                
                if(scanner.nextInt() ==   1) {
                     Equipe.listarFuncionarios();
                }
                
                System.out.println("Insira o cpf do funcionário: ");
                
                cpf = scanner.nextLine();

                Equipe.removeFuncionario(cpf);
                menuPrincipal();
                break;

            case 3:
                System.out.println("Insira o nome do produto: ");
                String nomeProduto = scanner.nextLine();

                System.out.println("Selecione a categoria: ");
                System.out.println("  1 - Alimentos Frescos");
                System.out.println("  2 - Mercearia");
                System.out.println("  3 - Frios, Laticínios e Congelados");
                System.out.println("  4 - Bebidas");

                int categoriaProduto = scanner.nextInt();
                while (categoriaProduto < 1 || categoriaProduto > 4) {
                    System.out.println("Categoria inválida, tente novamente: ");
                    categoriaProduto = scanner.nextInt();
                }
                scanner.nextLine();

                Produto p;
                String nomeCategoriaProduto;

                while (categoriaProduto < 1 || categoriaProduto > 4) {
                    System.out.println("Categoria inválido, tente novamente: ");
                    categoriaProduto = scanner.nextInt();
                }

                switch (categoriaProduto) {
                    case 1:
                        nomeCategoriaProduto = "Alimento Fresco";
                        break;

                    case 2:
                        nomeCategoriaProduto = "Mercearia";
                        break;

                    case 3:
                        nomeCategoriaProduto = "Frio, Laticínio ou Congelado";
                        break;

                    case 4:
                        nomeCategoriaProduto = "Bebida";
                        break;

                    default:
                        nomeCategoriaProduto = "Alimento Fresco";
                        break;
                }

                p = new Produto(nomeProduto, nomeCategoriaProduto);

                Caixa c = new Caixa(p);
                Estoque.addCaixa(c);
                System.out.println("Produto guardado no estoque");
                menuPrincipal();
                break;

            case 4:
                if(!Equipe.possuiFuncionarios()){
                    System.out.println("Sem funcionários cadastrados!");
                    menuPrincipal();
                    break;
                }
                
                System.out.println("Deseja listar os funcionários? ");
                System.out.println("  1 - Sim");
                System.out.println("  2 - Não");
                
                if(scanner.nextInt() ==   1) {
                     Equipe.listarFuncionarios();
                }
                
                System.out.println("Insira o cpf do funcionário para o reajuste: ");
                cpf = scanner.nextLine();
                
                System.out.println("Qual operação deseja realizar? ");
                System.out.println("  1 - Atualização salárial");
                System.out.println("  2 - Ajuste de cargo");
                
                int operacao;
                operacao = scanner.nextInt();
                
                while(operacao < 1 || operacao > 2){
                    System.out.println("operação inválida, tente novamente: ");
                    operacao = scanner.nextInt();
                }
                
                if(operacao == 1) {
                    System.out.println("Insira o novo salário: ");
                    salario = scanner.nextDouble();
                    user.alterarSalarioPorCpf(cpf, salario);
                } else {
                    user.alterarCargoPorCpf(cpf);
                }

                menuPrincipal();
                break;

            case 5:
                if(!Estoque.possuiEstoque()){
                    System.out.println("Sem estoque cadastrado!");
                    menuPrincipal();
                    break;
                }
                
                System.out.println("Deseja listar as caixas? ");
                System.out.println("  1 - Sim");
                System.out.println("  2 - Não");
                
                if(scanner.nextInt() ==   1) {
                     Estoque.listar();
                }
                
                System.out.println("Digite o produto que será mandado para a prateleira:");
                
                String produto = scanner.nextLine();
                
                Caixa caixa = Estoque.pegarCaixa(produto);
                
                if(caixa == null) {
                    menuPrincipal();
                    break;
                }
                
                if(!Equipe.possuiCarregadores()){
                    System.out.println("Sem carregadores cadastrados!");
                    menuPrincipal();
                    break;
                }
                
                System.out.println("Deseja listar os carregadores? ");
                System.out.println("  1 - Sim");
                System.out.println("  2 - Não");
                
                if(scanner.nextInt() ==   1) {
                     Equipe.selecionarCarregador();
                }
                
                System.out.println("Insira o cpf do carregador: ");
                cpf = scanner.nextLine();
                
                Carregador carregador = Equipe.getCarregadorPorCPF(cpf);
                
                if(carregador == null) {
                    menuPrincipal();
                    break;
                }
                
                carregador.colocarNaPrateleira(caixa);
                
                menuPrincipal();
                break;

            case 6:

                break;
                
            case 7:
                Equipe.listarFuncionarios();
                menuPrincipal();
                break;
                
            case 8:
                Estoque.listar();
                menuPrincipal();
                break;
                
            case 0: 
                break;
                
            default:
                menuPrincipal();
                break;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        menuPrincipal();
    }
}
