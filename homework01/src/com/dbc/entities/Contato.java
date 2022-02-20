package com.dbc.entities;

public class Contato {

    public String descricao;
    public String telefone;
    public int tipo;

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;

        if (tipo < 1 || tipo > 2) {
            this.tipo = 1;
        } else {
            this.tipo = tipo;
        }
    }

    public void imprimirContato() {
        String tipoContato = tipo == 1 ? "residencial" : "comercial";

        System.out.println(
                "Telefone " + tipoContato + ": " + telefone +
                        "\n" + descricao + "\n"
        );
    }
}
