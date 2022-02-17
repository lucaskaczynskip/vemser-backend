package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {
        System.out.println("Tradutor de palavras: Português - Inglês");
        System.out.println("Digite uma palavra em uma das linguas e veja a tradução.");
        System.out.print("Palavra: ");

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        switch (word.toLowerCase()) {
            case "cachorro":
                System.out.println("Tradução: Dog");
                break;
            case "dog":
                System.out.println("Tradução: Cachorro");
                break;
            case "tempo":
                System.out.println("Tradução: Time");
                break;
            case "time":
                System.out.println("Tradução: Tempo");
                break;
            case "amor":
                System.out.println("Tradução: Love");
                break;
            case "love":
                System.out.println("Tradução: Amor");
                break;
            case "cidade":
                System.out.println("Tradução: City");
                break;
            case "city":
                System.out.println("Tradução: Cidade");
                break;
            case "feliz":
                System.out.println("Tradução: Happy");
                break;
            case "happy":
                System.out.println("Tradução: Feliz");
                break;
            default:
                System.out.println("Essa palavra não é válida.");
                break;
        }


        sc.close();
    }
}
