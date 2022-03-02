package com.dbc.entities;

public class ContaCorrente {

    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente() {
        System.out.println(
                "\nNome: " + cliente.nome +
                        "\nCPF: " + cliente.cpf +
                        "\n---------------------------------" +
                        "\nConta: " + numeroConta + " - " + agencia +
                        "\n---------------------------------" +
                        "\nSaldo total: " + retornarSaldoComChequeEspecial()
        );
    }

    public boolean sacar(double valor) {
        if (valor <= retornarSaldoComChequeEspecial() && valor > 0) {
            saldo -= valor;
            return true;
        } else if (valor <= 0) {
            System.out.println("Impossível retirar valores negativos ou nulos.");
        } else {
            System.out.println("Valor inválido.");
        }
        return false;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        System.out.println("Impossível depositar valores negativos ou nulos.");
        return false;
    }

    public double retornarSaldoComChequeEspecial() {
        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente conta, double valor) {
        if (conta != null) {
            if (sacar(valor)) {
                conta.depositar(valor);
                return true;
            }
        }
        return false;
    }
}
