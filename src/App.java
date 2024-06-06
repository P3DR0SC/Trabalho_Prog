public class App {
    public static void main(String[] args) throws Exception {

        //Funcionário Júlio, salário inicial R$1350.00, exercendo o cargo Empacotador.

        Funcionario funcionario01 = new Funcionario();
        funcionario01.nome = "Júlio";
        funcionario01.salario = 1350.00;
        funcionario01.cargo = "Empacotador";

        //Funcionário Luigi, salário inicial R$1800.00, exercendo o cargo Caixa.

        Funcionario funcionario02 = new Funcionario();
        funcionario02.nome = "Luigi";
        funcionario02.salario = 1800.00;
        funcionario02.cargo = "Caixa";

        //Funcionário Thiago, salário inicial R%2000.00, exercendo cargo de Fiscal.

        Funcionario funcionario03 = new Funcionario();
        funcionario03.nome = "Thiago";
        funcionario03.salario = 2000.00;
        funcionario03.cargo = "fiscal de estoque";
    }

}