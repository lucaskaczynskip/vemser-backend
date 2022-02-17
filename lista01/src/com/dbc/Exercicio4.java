package com.dbc;

import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        System.out.println("Escolha uma opção: \n1 - São Paulo\n2 - Rio Grande do Sul\n3 - Santa Catarina");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op) {
            case 1:
                System.out.println("Escolhe uma cidade: \n1 - São Paulo\n2 - São José dos Campos");
                op = sc.nextInt();

                if (op == 1) {
                    System.out.println(
                                    "Prefeito: Ricardo Luis Reis Nunes\n" +
                                    "Área territorial: 1.521,110 km²\n" +
                                    "População estimada: 12.396.372 pessoas\n" +
                                    "IDHM: 0,805\n" +
                                    "PIB per capita: R$ 62.341,21"
                    );
                } else {
                    System.out.println(
                                    "Prefeito: Felicio Ramuth\n" +
                                    "Área territorial: 1.099,409 km²\n" +
                                    "População estimada: 737.310 pessoas\n" +
                                    "IDHM: 0,807\n" +
                                    "PIB per capita: R$ 737.310"
                    );
                }
                break;
            case 2:
                System.out.println("Escolhe uma cidade: \n1 - Porto Alegre\n2 - Alegrete");
                op = sc.nextInt();

                if (op == 1) {
                    System.out.println(
                                    "Prefeito: Sebastião de Araujo Melo\n" +
                                    "Área territorial: 495,390 km²\n" +
                                    "População estimada: 1.492.530 pessoas\n" +
                                    "IDHM: 0,805\n" +
                                    "PIB per capita: R$ 55.555,39"
                    );
                } else {
                    System.out.println(
                                    "Prefeito: Márcio Fonseca do Amaral\n" +
                                    "Área territorial: 7.800,428 km²\n" +
                                    "População estimada: 72.493 pessoas\n" +
                                    "IDHM: 0,740\n" +
                                    "PIB per capita: R$ 72.493"
                    );
                }
                break;
            case 3:
                System.out.println("Escolhe uma cidade: \n1 - Florianópolis\n2 - Bombinhas");
                op = sc.nextInt();

                if (op == 1) {
                    System.out.println(
                                    "Prefeito: Gean Marques Loureiro\n" +
                                    "Área territorial: 674,844 km²\n" +
                                    "População estimada: 516.524 pessoas\n" +
                                    "IDHM: 0,847\n" +
                                    "PIB per capita: R$ 43.842,54"
                    );
                } else {
                    System.out.println(
                                    "Prefeito: Paulo Henrique Dalago Muller\n" +
                                    "Área territorial: 35,143 km²\n" +
                                    "População estimada: 20.889 pessoas\n" +
                                    "IDHM: 0,781\n" +
                                    "PIB per capita: R$ 36.504,73"
                    );
                }
                break;
        }

        sc.close();
    }
}
