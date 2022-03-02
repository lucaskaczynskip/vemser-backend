package com.dbc;

import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {
        System.out.println("Tradutor de palavras: Português - Inglês");
        System.out.println("Digite uma palavra em uma das linguas e veja a tradução.");
        System.out.print("Palavra: ");

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        switch (word.toLowerCase()) {
            case "cachorro" -> System.out.println("Tradução: Dog");
            case "dog" -> System.out.println("Tradução: Cachorro");
            case "tempo" -> System.out.println("Tradução: Time");
            case "time" -> System.out.println("Tradução: Tempo");
            case "amor" -> System.out.println("Tradução: Love");
            case "love" -> System.out.println("Tradução: Amor");
            case "cidade" -> System.out.println("Tradução: City");
            case "city" -> System.out.println("Tradução: Cidade");
            case "feliz" -> System.out.println("Tradução: Happy");
            case "happy" -> System.out.println("Tradução: Feliz");
            default -> System.out.println("Essa palavra não é válida.");
        }


        sc.close();
    }
}
