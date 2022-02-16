package com.dbc;

import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a seguir as 4 notas do aluno: ");

        double testGrade1 = sc.nextDouble();
        double testGrade2 = sc.nextDouble();
        double testGrade3 = sc.nextDouble();
        double testGrade4 = sc.nextDouble();

        sc.close();

        double media = (testGrade1+testGrade2+testGrade3+testGrade4) / 4;

        if (media >= 7 && media <= 10) {
            System.out.printf("Média: %.2f%nAprovado", media);
        } else if (media > 5 && media <= 6.9) {
            System.out.printf("Média: %.2f%nAprovado", media);
        } else {
            System.out.printf("Média: %.2f%nAprovado", media);
        }
    }
}
