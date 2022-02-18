package com.dbc;

import java.util.Scanner;

public class Exercicio8 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double[][] mat = new double[5][4];
		double[] greater = new double[2]; 
		double medF = 0.0;
		
		for (int i = 0; i < 5; i++) {
			System.out.print("Número da matrícula: ");
			mat[i][0] = sc.nextDouble();
			sc.nextLine();
			System.out.print("Média das provas: ");
			mat[i][1] = sc.nextDouble();
			sc.nextLine();
			System.out.print("Média dos trabalhos: ");
			mat[i][2] = sc.nextDouble();
			sc.nextLine();
			mat[i][3] = (mat[i][1]*0.6) + (mat[i][2]*0.4);
			medF += mat[i][3];
			System.out.print("Nota final = " + mat[i][3]);
			System.out.println("\n");
			
			if (mat[i][3] > greater[0]) {
				greater[0] = mat[i][3];
				greater[1] = mat[i][0];
			}
		}
		
		System.out.println("-----------------------------------------");
		
		for (int i = 0; i < 5; i++) {
			if (mat[i][0] == greater[1]) {
				System.out.println(
						"Matrícula: " + mat[i][0] +
						"\nNota final: " +  mat[i][3]
				);
				break;
			}
		}
		
		System.out.println("\nMédia das notas finais = " + medF/5);
	}
}
