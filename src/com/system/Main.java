
package com.system;

import java.util.Scanner;

import com.system.Estoque.Caixa;
import com.system.Estoque.Estoque;
import com.system.Funcionarios.*;
import com.system.Prateleira.Produto;
public class Main {
    //menu principal, onde são listadas as opções aos usuários.
    public static void menuPrincipal(){
        Scanner scanner = new Scanner(System.in);

            
            System.out.println("\nBem vindo ao sistema de gerenciamento, gerente\n");
            System.out.println("            ------======------          ");
            System.out.println("Selecione a opção desejada:");
            System.out.println("  1 - Cadastrar funcionário");
            System.out.println("  2 - Remover funcionário");
            System.out.println("  3 - Cadastrar recebimento de produto");
            System.out.println("  4 - Alterar salário de funcionário");
            System.out.println("  5 - Mover do estoque para a prateleira");
            System.out.println("  6 - Mover da prateleira para o estoque");
            System.out.println("  7 - Listar funcionários");

            System.out.println("  0 - Sair");
            System.out.println("            ------======------          ");

            int op = scanner.nextInt();
            scanner.nextLine();

            //Opção 1 cadastra um novo funcionário
            switch (op) {
                case 1:
                    System.out.println("Insira o nome do funcionário: ");
                    String nome = scanner.nextLine();

                    System.out.println("Insira o cpf do funcionário: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Insira o salário do funcionário: ");
                    double salario = scanner.nextDouble();
                //Cadastra o cargo
                    System.out.println("Selecione o cargo: ");
                    System.out.println("  1 - Estoquista");
                    System.out.println("  2 - Carregador");

                    int cargo = scanner.nextInt();
                //avisa o usuário caso o input seja inválido
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
                    return;

                default:
                    return;
                
                case 2:
                    System.out.println("Insira o cpf do funcionário: ");
                    cpf = scanner.nextLine();
                    
                    Equipe.removeFuncionario(cpf);
                    menuPrincipal();
                    return;
                
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

                    try {
                        Produto p;
                        String nomeCategoriaProduto;
                        switch (categoriaProduto) {
                            case 1:
                                nomeCategoriaProduto = "Alimento Fresco";
                                p = new Produto(nomeProduto, nomeCategoriaProduto);
                                break;

                            case 2:
                                nomeCategoriaProduto = "Mercearia";
                                p = new Produto(nomeProduto, nomeCategoriaProduto);
                                break;

                            case 3:
                                nomeCategoriaProduto = "Frio, Laticínio ou Congelado";
                                p = new Produto(nomeProduto, nomeCategoriaProduto);
                                break;

                            case 4:
                                nomeCategoriaProduto = "Bebida";
                                p = new Produto(nomeProduto, nomeCategoriaProduto);
                                break;

                            default:
                                throw new IllegalArgumentException("Categoria inválida");
                        }
                        
                        Caixa c = new Caixa(p);
                        Estoque.addCaixa(c);
                        System.out.println("Produto cadastrado com sucesso!");

                        

                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar produto");
                    }
                    break;

                        
                case 4:
                    System.out.println("Insira o cpf do funcionário para o reajuste: ");
                    cpf = scanner.nextLine();
                    System.out.println("Insira o novo salário: ");
                    salario = scanner.nextDouble();
                    System.out.println("CPF: --" + cpf);
                    Equipe.modificarSalario(cpf, salario);
                    menuPrincipal();
                    return;
                
                case 5:
                    //mover do estoque para a prateleira.
                    System.out.println("Digite o produto que será mandado para a prateleira:");
                    
                    
                    

                case 7:
                    Equipe.listarFuncionarios();
                    menuPrincipal();
                    return;
                }
                
                

            }
    
    public static void main(String[] args) {
        Gerente user = new Gerente(null, null, 0);
        menuPrincipal();

        }
    }

