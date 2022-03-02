package com.dbc.homework03.entities;

import com.dbc.homework03.interfaces.Impressao;

public class ContaPagamento extends Conta implements Impressao {

    private static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        double saqueComTaxa = super.getSaldo() - TAXA_SAQUE;
        if (valor > 0 && valor <= saqueComTaxa) {
            super.setSaldo(super.getSaldo() - (valor + TAXA_SAQUE));
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (valor > 0 && valor <= super.getSaldo()) {
            super.setSaldo(super.getSaldo() - valor);
            return conta.depositar(valor);
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
                        "\nSaldo : " + super.getSaldo()
        );
    }
}
