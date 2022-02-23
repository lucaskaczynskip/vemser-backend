package com.dbc.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String name, cpf;

        for (int i = 0; i < 5; i++) {
            System.out.print("\nNome: ");
            name = scanner.nextLine();
            System.out.print("CPF: ");
            cpf = scanner.nextLine();

            map.put(cpf, name);
        }

        System.out.print("\nDigite um cpf para consulta: ");
        cpf = scanner.nextLine();

        String result = map.get(cpf);

        if (result != null) {
            System.out.printf("Nome do CPF cadastrado: %s%n", map.remove(cpf));
        } else {
            System.out.println("CPF não encontrado.\n");
        }

        System.out.println(map);

        scanner.close();
    }
}
