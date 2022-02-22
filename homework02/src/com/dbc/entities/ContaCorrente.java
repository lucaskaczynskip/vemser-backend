package com.dbc.entities;

import com.dbc.interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.setChequeEspecial(chequeEspecial);
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial() {
        return this.getSaldo() + this.chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.retornarSaldoComChequeEspecial()) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public void imprimir() {
        System.out.println(
                "\nNome: " + this.getCliente().getNome() +
                        "\nCPF: " + this.getCliente().getCpf() +
                        "\n---------------------------------" +
                        "\nConta: " + this.getNumeroConta() + " - " + this.getAgencia() +
                        "\n---------------------------------" +
                        "\nSaldo total: " + this.retornarSaldoComChequeEspecial()
        );
    }

}
