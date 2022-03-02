package com.dbc.interfaces;

import com.dbc.entities.Conta;

public interface Movimentacao {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta conta, double valor);
}
