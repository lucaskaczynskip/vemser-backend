package com.dbc;

import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double amountPaid, totalConsumed, returnedCash;

        System.out.print("Valor a pagar: R$ ");
        totalConsumed = sc.nextDouble();
        System.out.print("Valor pago: R$ ");
        amountPaid = sc.nextDouble();


        sc.close();

        if (amountPaid < totalConsumed) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido.");
        } else {
            returnedCash = amountPaid - totalConsumed;
            System.out.printf("Troco do cliente: R$ %.2f", returnedCash);
        }
    }
}
