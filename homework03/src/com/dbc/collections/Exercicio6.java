package com.dbc.collections;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercicio6 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Lucas", 19));
        pessoas.add(new Pessoa("Nicolas", 19));
        pessoas.add(new Pessoa("Lucas", 37));
        pessoas.add(new Pessoa("Paulo", 15));

        pessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getIdade() - o2.getIdade();
            }
        });

        System.out.println(pessoas);

        pessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                int comparaNome = o1.getNome().compareTo(o2.getNome());
                if (comparaNome != 0) {
                    return comparaNome;
                }
                return o1.getIdade() - o2.getIdade();

            }
        });

        System.out.println(pessoas);
    }
}

class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}