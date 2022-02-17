package com.dbc;

import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o valor da hora? R$ ");
        double hourPrice = sc.nextDouble();
        System.out.print("Qual o número de horas trabalhadas? ");
        double totalHours = sc.nextDouble();
        System.out.print("O número de horas extra? ");
        double extraHours = sc.nextDouble();

        double salary = (hourPrice*totalHours) + (extraHours*hourPrice*1.5) + (extraHours*hourPrice*2);

        System.out.printf("O salário bruto total é de R$ %.2f", salary);

        sc.close();
    }
}
