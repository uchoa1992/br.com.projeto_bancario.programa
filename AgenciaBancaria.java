package br.com.projeto_bancario.Programa;

import br.com.projeto_bancario.Utilitarios.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    private static void operacoes() {

        System.out.println("------------------------------------------------------");
        System.out.println("--------------Bem-vindos a nossa agência--------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("|   Opção 1 - Criar Conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int operacao = input.nextInt();

        switch (operacao)
        {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;


            case 5:
                listar();
                break;

            case 6:
                System.out.println("Até a próxima, obrigado por usar nossa agência");
                System.exit(0);
                break;

            default:
                System.out.println("opção inválida");
                operacoes();
                break;
        }

    }

    public static void criarConta()
    {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCpf: ");
        String cpf = input.next();

        System.out.println("\nE-mail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome,cpf,email);
        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);

        System.out.println("Sua conta foi criada com sucesso");
        operacoes();
    }

    private static Conta encontrarConta(int numeroConta)
    {
        Conta conta = null;
        if(contasBancarias.size() > 0)
        {
            for (Conta c: contasBancarias)
            {
                if(c.getNumeroConta() == numeroConta)
                {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar()
    {
        if (contasBancarias.size() > 0)
        {
            System.out.println("Número da conta: ");
            int numeroConta = input.nextInt();

            Conta conta = encontrarConta(numeroConta);

            if (conta != null) {
                System.out.println("Qual valor você deseja depositar");
                double deposito = input.nextDouble();
                conta.depositar(deposito);
            } else {
                System.out.println("Conta não encontrada");
            }
        }

        else
        {
            System.out.println("Não há contas cadastradas");
        }

        operacoes();
    }

    public static void sacar()
    {
        if (contasBancarias.size() > 0)
        {
            System.out.println("Número da conta");
            int numeroConta = input.nextInt();

            Conta conta = encontrarConta(numeroConta);

            if (conta != null) {
                System.out.println("Qual valor você deseja sacar");
                double saque = input.nextDouble();
                conta.sacar(saque);
            } else {
                System.out.println("Conta não encontrada");
            }
        }

        else
        {
            System.out.println("Não há contas cadastradas");
        }

        operacoes();
    }

    public static void transferir()
    {
        if (contasBancarias.size() > 0)
        {
            if(contasBancarias.size() == 1)
            {
                System.out.println("Só há apenas uma conta cadastrada, não tem outra conta para fazer transferência");
            }

            else
            {
                System.out.println("Número da conta");
                int numeroConta = input.nextInt();

                Conta conta = encontrarConta(numeroConta);

                if (conta != null)
                {
                    System.out.println("Qual valor você deseja transferir");
                    double transferir = input.nextDouble();

                    if (transferir <= conta.getSaldo())
                    {
                        System.out.println("Para qual conta você deseja transferir");
                        int outraConta = input.nextInt();

                        Conta conta1 = encontrarConta(outraConta);

                        if (conta1 != null)
                        {
                            conta.transferir(conta1, transferir);
                        }

                        else
                        {
                            System.out.println("Conta para transferir não encontrada");
                        }
                    }

                    else
                    {
                        System.out.println("Não é possível transferir " + Utils.doubleToString(transferir) + " pois seu saldo é " + Utils.doubleToString(conta.getSaldo()) + " e o saldo é inferior ao valor solicitado para transferência");
                    }
                }

                else
                {
                    System.out.println("Conta não encontrada");
                }
            }
        }

        else
        {
            System.out.println("Não há contas cadastradas");
        }

        operacoes();
    }

    public static void listar()
    {
        if (contasBancarias.size() > 0)
        {
            for (Conta conta: contasBancarias)
            {
                System.out.println(conta);
            }
        }
        else
        {
            System.out.println("Não há contas cadastradas");
        }
        operacoes();
    }

}
