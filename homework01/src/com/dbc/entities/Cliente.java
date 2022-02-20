package com.dbc.entities;

public class Cliente {

    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
        for (Contato contato : contatos) {
            if (contato != null) {
                contato.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        for (Endereco endereco : enderecos) {
            if (endereco != null) {
                endereco.imprimirEndereco();
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("\nNome: " + nome + "\nCPF: " + cpf);
        System.out.println("---------- Endereço(s) ----------");
        imprimirEnderecos();
        System.out.println("---------- Contato(s) ----------");
        imprimirContatos();
    }
}
