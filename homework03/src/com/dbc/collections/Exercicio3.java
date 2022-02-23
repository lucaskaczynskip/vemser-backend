package com.dbc.collections;

import java.util.LinkedList;
import java.util.Queue;

public class Exercicio3 {

    public static void main(String[] args) {
        Queue<PessoaSenha> lista = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            PessoaSenha pessoa = new PessoaSenha(++PessoaSenha.quantidadePessoas);
            lista.add(pessoa);

            System.out.printf("Senha %d retirada.%n", PessoaSenha.quantidadePessoas);
        }

        System.out.println("");

        for (int i = 0; i < 3; i++) {
            PessoaSenha pessoa = lista.poll();
            if (pessoa != null) {
                System.out.println("Senha " + pessoa.getSenha() + " foi atendida");
            }
        }

        System.out.println("");

        for (int i = 0; i < 3; i++) {
            PessoaSenha pessoa = new PessoaSenha(++PessoaSenha.quantidadePessoas);
            lista.add(pessoa);

            System.out.printf("Senha %d retirada.%n", PessoaSenha.quantidadePessoas);
        }

        System.out.println("");

        for (int i = 0; i < 3; i++) {
            PessoaSenha pessoa = lista.poll();
            if (pessoa != null) {
                System.out.println("Senha " + pessoa.getSenha() + " foi atendida");
            }
        }

        System.out.println("");

        System.out.println("Senhas restantes: " + lista);


    }
}

class PessoaSenha {
    private int senha;
    public static int quantidadePessoas = 0;

    public PessoaSenha(int senha) {
        this.setSenha(senha);
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return String.format("%d", this.getSenha());
    }
}