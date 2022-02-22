package com.dbc.entities;

import java.util.Arrays;

public class Cliente {

    private String nome;
    private String cpf;
    private Contato[] contatos;
    private Endereco[] enderecos;

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setContatos(contatos);
        this.setEnderecos(enderecos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        for (int i = 0; i < 2; i++) {
            this.contatos[i] = contatos[i];
        }
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        for (int i = 0; i < 2; i++) {
            this.enderecos[i] = enderecos[i];
        }
    }

    public void imprimirContatos() {
        for (Contato contato : this.getContatos()) {
            if (contato != null) {
                contato.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        for (Endereco endereco : this.getEnderecos()) {
            if (endereco != null) {
                endereco.imprimirEndereco();
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("\nNome: " + this.getNome() + "\nCPF: " + this.getCpf());
        System.out.println("---------- Endereço(s) ----------");
        this.imprimirEnderecos();
        System.out.println("---------- Contato(s) ----------");
        this.imprimirContatos();
    }
}
