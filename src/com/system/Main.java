package com.system;

import java.util.Scanner;

import com.system.Estoque.*;
import com.system.Funcionarios.*;
import com.system.Prateleira.Prateleira;
import com.system.Prateleira.Produto;

/**
 * Classe principal que contém o método para execução do sistema de gerenciamento.
 * @author Pedro Sciesleski
 */

public class Main {

    /**
     * Método principal que exibe o menu principal e gerencia as operações do sistema.
     */
    public static void menuPrincipal() {
        Gerente user = new Gerente(null, null, 0); // Instanciação de um gerente
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            /*  Exibição do menu principal*/
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
            scanner.nextLine(); // Consumir a nova linha pendente

            /*  Switch case para as opções do menu*/
            switch (op) {
                case 1:
                    /*  Cadastro de funcionário*/
                    System.out.println("Insira o nome do funcionário: ");
                    String nome = scanner.nextLine();

                    System.out.println("Insira o cpf do funcionário: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Insira o salário do funcionário: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha pendente

                    /*  Seleção do cargo do funcionário*/
                    System.out.println("Selecione o cargo: ");
                    System.out.println("  1 - Estoquista");
                    System.out.println("  2 - Carregador");

                    int cargo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha pendente

                    /*  Validando o cargo selecionado*/
                    while (cargo < 1 || cargo > 2) {
                        System.out.println("Cargo inválido, tente novamente: ");
                        cargo = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha pendente
                    }

                    try {
                        Funcionario f;
                        /*Criando instância do funcionário com base no cargo selecionado*/
                        if (cargo == 1) {
                            f = new Estoquista(nome, cpf, salario);
                        } else {
                            f = new Carregador(nome, cpf, salario);
                        }

                        Equipe.addFuncionario(f); /*Adicionando o funcionário à equipe*/

                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar funcionário");
                    }
                    break;

                case 2:
                    /*  Remoção de funcionário*/
                    if (!Equipe.possuiFuncionarios()) {
                        System.out.println("Sem funcionários cadastrados!");
                        break;
                    }

                    System.out.println("Deseja listar os funcionários antes da ação? ");
                    System.out.println("  1 - Sim");
                    System.out.println("  2 - Não");

                    if (scanner.nextInt() == 1) {
                        Equipe.listarFuncionarios();
                    }
                    scanner.nextLine(); /*  Consumir a nova linha pendente*/

                    System.out.println("Insira o cpf do funcionário que deseja remover: ");
                    cpf = scanner.nextLine();

                    Equipe.removeFuncionario(cpf); // Removendo o funcionário da equipe
                    break;

                case 3:
                    /*  Cadastro de recebimento de produto*/
                    System.out.println("Insira o nome do produto: ");
                    String nomeProduto = scanner.nextLine();

                    System.out.println("Selecione a categoria: ");
                    System.out.println("  1 - Alimentos Frescos");
                    System.out.println("  2 - Mercearia");
                    System.out.println("  3 - Frios, Laticínios e Congelados");
                    System.out.println("  4 - Bebidas");

                    int categoriaProduto = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha pendente

                    /* Validando a categoria selecionada*/
                    while (categoriaProduto < 1 || categoriaProduto > 4) {
                        System.out.println("Categoria inválida, tente novamente: ");
                        categoriaProduto = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha pendente
                    }

                    Produto p;
                    String nomeCategoriaProduto;

                    /*  Definindo o nome da categoria do produto com base na seleção do usuário*/
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
                            nomeCategoriaProduto = "";
                            break;
                    }

                    /*  Criando instância do produto*/
                    p = new Produto(nomeProduto, nomeCategoriaProduto);

                    Caixa c = new Caixa(p); // Criando uma caixa com o produto
                    Estoque.addCaixa(c); // Adicionando a caixa ao estoque
                    System.out.println("Produto guardado no estoque");
                    break;

                case 4:
                    /*  Atualização de funcionário (salário ou cargo)*/
                    if (!Equipe.possuiFuncionarios()) {
                        System.out.println("Sem funcionários cadastrados!");
                        break;
                    }

                    System.out.println("Deseja listar os funcionários antes da ação? ");
                    System.out.println("  1 - Sim");
                    System.out.println("  2 - Não");

                    if (scanner.nextInt() == 1) {
                        Equipe.listarFuncionarios();
                    }
                    scanner.nextLine(); /*  Consumir a nova linha pendente*/

                    System.out.println("Insira o cpf do funcionário para o reajuste: ");
                    cpf = scanner.nextLine();

                    System.out.println("Qual operação deseja realizar? ");
                    System.out.println("  1 - Atualização salarial");
                    System.out.println("  2 - Ajuste de cargo");

                    int operacao = scanner.nextInt();
                    scanner.nextLine(); /* Consumir a nova linha pendente*/


                    while (operacao < 1 || operacao > 2) {
                        System.out.println("Operação inválida, tente novamente: ");
                        operacao = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha pendente
                    }

                    if (operacao == 1) {
                        // Atualização salarial
                        System.out.println("Insira o novo salário: ");
                        salario = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a nova linha pendente
                        user.alterarSalarioPorCpf(cpf, salario);
                    } else {
                        // Ajuste de cargo
                        user.alterarCargoPorCpf(cpf);
                    }
                    break;

                case 5:
                    /*  Movimentação do estoque para a prateleira*/
                    if (!Estoque.possuiEstoque()) {
                        System.out.println("Sem estoque cadastrado!");
                        break;
                    }

                    System.out.println("Deseja listar as caixas em estoque? ");
                    System.out.println("  1 - Sim");
                    System.out.println("  2 - Não");

                    if (scanner.nextInt() == 1) {
                        Estoque.listar();
                    }
                    scanner.nextLine(); // Consumir a nova linha pendente

                    System.out.println("Digite o produto que será mandado para a prateleira:");
                    String produto = scanner.nextLine();

                    Caixa caixa = Estoque.pegarCaixa(produto);

                    if (caixa == null) {
                        System.out.println("Produto não encontrado no estoque.");
                        break;
                    }

                    if (!Equipe.possuiCarregadores()) {
                        System.out.println("Sem carregadores cadastrados!");
                        break;
                    }

                    System.out.println("Deseja listar os carregadores? ");
                    System.out.println("  1 - Sim");
                    System.out.println("  2 - Não");

                    if (scanner.nextInt() == 1) {
                        Equipe.selecionarCarregador();
                    }
                    scanner.nextLine(); // Consumir a nova linha pendente

                    System.out.println("Insira o cpf do carregador: ");
                    cpf = scanner.nextLine();

                    Carregador carregador = Equipe.getCarregadorPorCPF(cpf);

                    if (carregador == null) {
                        break;
                    }

                    carregador.colocarNaPrateleira(caixa);
                    break;

                case 6:
                    /* Movimentação da prateleira para o estoque*/
                    if (!Prateleira.possuiProdutos()) {
                        System.out.println("Sem produtos na prateleira!");
                        break;
                    }

                    System.out.println("Deseja listar os produtos da prateleira? ");
                    System.out.println("  1 - Sim");
                    System.out.println("  2 - Não");

                    if (scanner.nextInt() == 1) {
                        Prateleira.listar();
                    }
                    scanner.nextLine(); // Consumir a nova linha pendente

                    System.out.println("Digite o produto que será mandado para o estoque: ");
                    String nomeProdutoPrateleiraEstoque = scanner.nextLine();

                    if (!Equipe.possuiEstoquistas()) {
                        System.out.println("Sem estoquistas cadastrados!");
                        break;
                    }

                    System.out.println("Deseja listar os estoquistas? ");
                    System.out.println("  1 - Sim");
                    System.out.println("  2 - Não");

                    if (scanner.nextInt() == 1) {
                        Equipe.selecionarEstoquista();
                    }
                    scanner.nextLine(); // Consumir a nova linha pendente

                    System.out.println("Insira o cpf do Estoquista: ");
                    cpf = scanner.nextLine();

                    Estoquista estoquista = Equipe.getEstoquistaPorCPF(cpf);

                    if (estoquista == null) {
                        break;
                    }

                    Produto produto2 = Prateleira.encontrarProduto(nomeProdutoPrateleiraEstoque);
                    if (produto2 != null) {
                        Caixa caixa2 = estoquista.empacotar(produto2);
                        estoquista.colocarNoEstoque(caixa2);
                    } else {
                        System.out.println("Produto não encontrado na prateleira.");
                    }

                    break;

                case 7:
                    /*  Listar funcionários*/
                    Equipe.listarFuncionarios();
                    break;

                case 8:
                    /*  Listar estoque */
                    Estoque.listar();
                    break;

                case 9:
                    /*  Listar produtos na prateleira */
                    Prateleira.listar();
                    break;

                case 0:
                    /*  Sair do sistema*/
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Método principal que inicia a execução do sistema.
     * @param args Argumentos da linha de comando (não utilizados neste sistema).
     */
    public static void main(String[] args) {
        menuPrincipal();
    }
}