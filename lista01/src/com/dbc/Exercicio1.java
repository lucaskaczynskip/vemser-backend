package com.dbc;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();
        System.out.print("Digite sua idade: ");
        int age = sc.nextInt();
        System.out.print("Qual sua cidade? ");
        sc.nextLine();
        String city = sc.nextLine();
        System.out.print("Em qual estado se encontra sua cidade? ");
        String state = sc.nextLine();

        sc.close();

        System.out.println(
                "Olá seu nome é " + name +
                ", você tem " + age +
                " anos, é da cidade de " + city +
                ", situada no estado de " + state +
                "."
        );
    }
}
