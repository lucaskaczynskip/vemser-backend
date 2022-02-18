package com.dbc;

import java.util.Scanner;

public class Exercicio5 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] numbers = new int[20];
		for (int i = 0; i < 20; i++) {
			numbers[i] = sc.nextInt();
			sc.nextLine();
		}
		
		System.out.println("----------------------------------");
		
		for (int i = numbers.length-1; i >= 0; i--) {
			System.out.printf("%d ", numbers[i]);
		}
		
		sc.close();
	}
}
