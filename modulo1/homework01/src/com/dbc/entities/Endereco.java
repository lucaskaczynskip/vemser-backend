package com.dbc.entities;

public class Endereco {

    public int tipo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        if (tipo < 1 || tipo > 2) {
            this.tipo = 1;
        } else {
            this.tipo = tipo;
        }

        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public void imprimirEndereco() {
        String tipoEndereco = tipo == 1 ? "residencial" : "comercial";

        System.out.println(
                "Endereco " + tipoEndereco +
                        "\nLogradouro: " + logradouro +
                        "\nNumero: " + numero +
                        "\nComplemento: " + complemento +
                        "\nCEP: " + cep +
                        "\nCidade: " + cidade +
                        "\nEstado: " + estado +
                        "\nPaís: " + pais
        );
    }
}
