package com.dbc;

import java.util.Random;
import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = new Random().nextInt(1, 20);
		
		System.out.print("Digite um numero: ");
		int digitedNumber = sc.nextInt();
		sc.nextLine();
		
		while (digitedNumber != number) {
			if (digitedNumber < number) {
				System.out.println("O número correto é maior");
			} else {
				System.out.println("O número correto é menor");
			}
			System.out.print("Digite um numero: ");
			digitedNumber = sc.nextInt();
			sc.nextLine();
		}
			
		System.out.println("Parabéns, você acertou!");
		
		sc.close();
	}
}
