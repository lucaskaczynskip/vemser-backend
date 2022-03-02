package com.dbc;

import java.util.Scanner;

public class Exercicio4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double[] v = new double[3];
		double min = 999999999999.0;
		int pos = 0;
		
		System.out.println("Digite 3 números: ");
		for (int i = 0; i < v.length; i++) {
			v[i] = sc.nextDouble();
			sc.nextLine();
			if (v[i] < min) {
				min = v[i];
				pos = i;
			}
		}
		
		System.out.println("A posição do menor número no vetor é: " + pos);
	}
}
