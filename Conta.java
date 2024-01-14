package br.com.projeto_bancario.Programa;

import br.com.projeto_bancario.Utilitarios.Utils;

public class Conta {

    private static int contadorDeContas = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas+=1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ", nome= " + pessoa.getNome() +
                ", cpf= " + pessoa.getCpf() +
                ", email=" + pessoa.getEmail() +
                ", saldo=" + Utils.doubleToString(saldo) +
                '}';
    }

    public void depositar(Double valor)
    {
        if(valor > 0)
        {
            saldo += valor;
            System.out.println("seu depósito de " + Utils.doubleToString(valor) + " foi realizado com sucesso!");
        }
        else
        {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor)
    {
        if (valor > saldo)
        {
            System.out.println("Não é possível sacar " + Utils.doubleToString(valor) + " pois seu saldo é " + Utils.doubleToString(saldo) + " e o saldo é inferior ao valor solicitado para saque");
        }

        else
        {
            saldo -= valor;
            System.out.println("seu saque de " + Utils.doubleToString(valor) + " foi realizado com sucesso!");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor)
    {
        if (valor <= saldo)
        {
            saldo -= valor;
            contaParaDeposito.saldo += valor;
            System.out.println("sua transferência de " + Utils.doubleToString(valor) + " foi realizado com sucesso!");
        }
    }
}
