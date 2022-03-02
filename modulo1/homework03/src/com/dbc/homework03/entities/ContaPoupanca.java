package com.dbc.homework03.entities;

import com.dbc.homework03.interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {

    private static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        super.setSaldo(super.getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println(
                "\nNome: " + super.getCliente().getNome() +
                        "\nCPF: " + super.getCliente().getCpf() +
                        "\n---------------------------------" +
                        "\nConta: " + super.getNumeroConta() + " - " + super.getAgencia() +
                        "\n---------------------------------" +
                        "\nSaldo total: " + super.getSaldo()
        );
    }
}
