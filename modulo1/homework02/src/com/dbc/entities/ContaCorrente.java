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
        return super.getSaldo() + this.chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.retornarSaldoComChequeEspecial()) {
            super.setSaldo(super.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public void imprimir() {
        System.out.println(
                "\nNome: " + super.getCliente().getNome() +
                        "\nCPF: " + super.getCliente().getCpf() +
                        "\n---------------------------------" +
                        "\nConta: " + super.getNumeroConta() + " - " + super.getAgencia() +
                        "\n---------------------------------" +
                        "\nSaldo total: " + this.retornarSaldoComChequeEspecial()
        );
    }

}
