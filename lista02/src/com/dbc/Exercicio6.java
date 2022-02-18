package com.dbc;

import java.util.Random;
import java.util.Scanner;

public class Exercicio6 {
	
	public static void main(String[] args) {
		int[] v = new int[10];
		for (int i = 0; i < v.length; i++) {
			v[i] = new Random().nextInt(1, 100);
		}
		
		System.out.print("Digite um número: ");
		int number = new Scanner(System.in).nextInt();
		
		boolean numberExists = false;
		for (int i = 0; i < v.length; i++) {
			if (v[i] == number) {
				numberExists = false;
				break;
			}
		}
		
		if (!numberExists) {
			System.out.println("O número digitado não existe no sistema.");
		}
	}
}
