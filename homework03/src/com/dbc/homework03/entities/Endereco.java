package com.dbc.homework03.entities;

public class Endereco {

    private int tipo;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        if (tipo < 1 || tipo > 2) {
            this.setTipo(1);
        } else {
            this.setTipo(tipo);
        }

        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setCep(cep);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setPais(pais);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void imprimirEndereco() {
        String tipoEndereco = getTipo() == 1 ? "residencial" : "comercial";

        System.out.println(
                "Endereco " + tipoEndereco +
                        "\nLogradouro: " + getLogradouro() +
                        "\nNumero: " + getNumero() +
                        "\nComplemento: " + getComplemento() +
                        "\nCEP: " + getCep() +
                        "\nCidade: " + getCidade() +
                        "\nEstado: " + getEstado() +
                        "\nPaís: " + getPais()
        );
    }
}
