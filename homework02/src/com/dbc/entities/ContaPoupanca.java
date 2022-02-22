package com.dbc.entities;

import com.dbc.interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {

    private static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println(
                "\nNome: " + this.getCliente().getNome() +
                        "\nCPF: " + this.getCliente().getCpf() +
                        "\n---------------------------------" +
                        "\nConta: " + this.getNumeroConta() + " - " + this.getAgencia() +
                        "\n---------------------------------" +
                        "\nSaldo total: " + this.getSaldo()
        );
    }
}
