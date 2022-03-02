package com.dbc.collections;

import java.util.Scanner;
import java.util.Stack;

public class Exercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 15; i++) {
            int number = scanner.nextInt();
            scanner.nextLine();

            if (number % 2 == 0) {
                stack.push(number);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
        }

        System.out.println("\n" + stack + "\n");

        while (!stack.empty()) {
            System.out.printf("%d ", stack.pop());
        }

        System.out.println("\n\n" + stack);

        scanner.close();
    }
}
