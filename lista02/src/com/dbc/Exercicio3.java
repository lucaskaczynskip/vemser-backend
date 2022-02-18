package com.dbc;

import java.util.Scanner;

public class Exercicio3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int playerCount = 0, age = 0, _age = 0;
		double h, m;
		double _h = 0.0, _m = 0.0, media = 0.0;
		String player, _player = null, _playerM = null;
		
		System.out.print("Digite o nome do jogador: ");
		player = sc.nextLine();
		System.out.print("Altura do jogador: ");
		h = sc.nextDouble();
		sc.nextLine();
		System.out.print("Idade do jogador: ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print("Peso do jogador: ");
		m = sc.nextDouble();
		sc.nextLine();
		
		while (!player.equalsIgnoreCase("sair")) {
			if (h > _h) {
				_h = h;
			}
			if (age > _age) {
				_age = age;
				_player = player;
			}
			if (m > _m) {
				_playerM = player;
				_m = m;	
			}
			playerCount++;
			media += h;
			
			System.out.print("\nDigite o nome do jogador: ");
			player = sc.nextLine();
			if (player.equalsIgnoreCase("sair")) {
				break;
			}
			System.out.print("Altura do jogador: ");
			h = sc.nextDouble();
			sc.nextLine();
			System.out.print("Idade do jogador: ");
			age = sc.nextInt();
			sc.nextLine();
			System.out.print("Peso do jogador: ");
			m = sc.nextDouble();
			sc.nextLine();
		}
		
		System.out.println("\nQuantidade de jogadores: " + playerCount);
		System.out.println("Altura do maior jogador: " + _h);
		System.out.println("Jogador mais velho: " + _player);
		System.out.println("Jogador mais pesado: " + _playerM);
		System.out.println("Média das alturas dos jogadores: " + media/playerCount);
		
		sc.close();
	}
}
