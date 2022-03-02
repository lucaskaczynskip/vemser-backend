package com.dbc;

import java.util.Scanner;

public class Exercicio1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Produto: ");
		String name = sc.nextLine();
		System.out.print("Preço: R$ ");
		double price = sc.nextDouble();
		
		System.out.printf("%nPromoção: %s%n", name);
		System.out.print("-------------------------------");
		
		double percent = 0.05;
		for (int i = 1; i < 11; i++) {
			if (percent != 0.5) {
				percent = 0.05 * i;
			}
			double discount = price - (price * percent);
			System.out.printf("%n%d x R$ %.2f = R$ %.2f", i, discount, discount * i);
		}
		
		sc.close();
	}
}
