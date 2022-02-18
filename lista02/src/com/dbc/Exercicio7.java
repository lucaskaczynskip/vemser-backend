package com.dbc;

import java.util.Scanner;

public class Exercicio7 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] mat = new int[4][4];
		int	greaterThanTen = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				mat[i][j] = sc.nextInt();
				sc.nextLine();
				if (mat[i][j] > 10) {
					greaterThanTen++;
				}
			}
		}
		
		System.out.println("");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%d ", mat[i][j]);
			}
			System.out.println("");
		}
		
		System.out.println("\nExistem " + greaterThanTen + " números maior que 10 na matriz.");
	}
}
