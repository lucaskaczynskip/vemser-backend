package com.dbc.homework03.entities;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos;
    private ArrayList<Endereco> enderecos;

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
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

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
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
