package com.dbc.collections;

import java.util.LinkedList;
import java.util.Queue;

public class Exercicio3 {

    public static void main(String[] args) {
        Queue<Senha> lista = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            Senha senha = new Senha(++Senha.quantidadeSenhas);
            lista.add(senha);

            System.out.printf("Senha %d retirada.%n", Senha.quantidadeSenhas);
        }

        System.out.println("");

        for (int i = 0; i < 3; i++) {
            Senha senha = lista.poll();
            if (senha != null) {
                System.out.println("Senha " + senha.getSenha() + " foi atendida");
            }
        }

        System.out.println("");

        for (int i = 0; i < 3; i++) {
            Senha senha = new Senha(++Senha.quantidadeSenhas);
            lista.add(senha);

            System.out.printf("Senha %d retirada.%n", Senha.quantidadeSenhas);
        }

        System.out.println("");

        for (int i = 0; i < 3; i++) {
            Senha senha = lista.poll();
            if (senha != null) {
                System.out.println("Senha " + senha.getSenha() + " foi atendida");
            }
        }

        System.out.println("");

        System.out.println("Senhas restantes: " + lista);


    }
}