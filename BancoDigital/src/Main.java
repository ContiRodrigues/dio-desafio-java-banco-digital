import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banco banco = Banco.getInstance();
        Scanner keyboard = new Scanner(System.in);

        Conta contaCorrente = new ContaCorrente(new Cliente("Luís Rodrigues", "288"));
        banco.cadastrarConta(contaCorrente);
        ContaPoupanca contaPoupanca = new ContaPoupanca(new Cliente("Renata Conti", "362"));
        banco.cadastrarConta(contaPoupanca);

        boolean naoSair = true;

        while (naoSair) {

            System.out.println("Bem vindo(a) ao Banco Digital!");
            System.out.println("Escolha a opção desejada:");
            System.out.println("1- Cadastrar nova conta");
            System.out.println("2- Acessar conta");
            System.out.println("3- Sair");

            int opcao = keyboard.nextInt();

            switch (opcao) {
                case 1:
                    criarConta(banco,keyboard);
                    break;

                case 2:
                    acessarConta(banco,keyboard);
                    break;
                case 3:
                    naoSair=false;
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }

    }

    private static void criarConta(Banco banco, Scanner keyboard) {

        System.out.println("Cadastrar Conta Corrente - digite: 1");
        System.out.println("Cadastrar Conta Poupança - digite: 2");
        int tipoConta = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Informe o nome");
        String nome = keyboard.nextLine();

        System.out.println("Informe o CPF");
        String cpf = keyboard.nextLine();
        Cliente clienteNovo = new Cliente(nome, cpf);

        if (tipoConta == 1) {
            Conta contaCorrenteNova = new ContaCorrente(clienteNovo);
            System.out.println(contaCorrenteNova + "cadastrada com sucesso!");
            banco.cadastrarConta(contaCorrenteNova);

        } else if (tipoConta == 2) {
            Conta contaPoupancaNova = new ContaPoupanca(clienteNovo);
            System.out.println(contaPoupancaNova+ "cadastrada com sucesso");
            banco.cadastrarConta(contaPoupancaNova);

        } else {
            System.out.println("Tipo inválido de conta");
        }
    }

    private static void acessarConta(Banco banco, Scanner keyboard) {

        System.out.println("Digite CPF");
        String cpf = keyboard.next();
        Conta contaEncontrada = banco.encontrarConta(cpf);

        if(contaEncontrada == null) {
            System.out.println("Conta não encontrada");
        }

        System.out.println("Operações disponíveis: ");
        System.out.println("1- Imprimir Extrato");
        System.out.println("2- Depósito");
        System.out.println("3- Saque");
        System.out.println("4- Transferência");

        int opcao= keyboard.nextInt();

        switch (opcao) {
            case 1:
                contaEncontrada.imprimirInformacoes();
                break;
            case 2:
                System.out.println("Digite o valor do depósito");
                BigDecimal valor = keyboard.nextBigDecimal();
                contaEncontrada.depositar(valor);
                break;
            case 3:
                System.out.println("Digite o valor do saque");
                BigDecimal valor1 = keyboard.nextBigDecimal();
                contaEncontrada.sacar(valor1);
                break;
            case 4:
                System.out.println("Digite o valor da transferência");
                BigDecimal valor2 = keyboard.nextBigDecimal();
                System.out.println("Digite o CPF da conta de destino");
                String cpfDestino = keyboard.next();
                Conta contaDestino= banco.encontrarConta(cpfDestino);
                contaEncontrada.transferir(valor2, contaDestino);
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

}