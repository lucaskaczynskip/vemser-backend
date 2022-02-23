package com.dbc.homework03.interfaces;

import com.dbc.homework03.entities.Conta;

public interface Movimentacao {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta conta, double valor);
}
