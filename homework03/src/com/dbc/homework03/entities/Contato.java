package com.dbc.homework03.entities;

public class Contato {

    private String descricao;
    private String telefone;
    private int tipo;

    public Contato(String descricao, String telefone, int tipo) {
        this.setDescricao(descricao);
        this.setTelefone(telefone);

        if (tipo < 1 || tipo > 2) {
            this.setTipo(1);
        } else {
            this.setTipo(tipo);
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void imprimirContato() {
        String tipoContato = getTipo() == 1 ? "residencial" : "comercial";

        System.out.println(
                "Telefone " + tipoContato + ": " + getTelefone() +
                        "\n" + getDescricao() + "\n"
        );
    }
}
