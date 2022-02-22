package com.dbc.interfaces;

import com.dbc.entities.Conta;

public interface Movimentacao {

    public boolean sacar(double valor);
    public boolean depositar(double valor);
    public boolean transferir(Conta conta, double valor);
}
