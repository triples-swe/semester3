package oop;

import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        String input = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (char digit : input.toCharArray()) {
            stack.push(digit);
        }

        System.out.print("Число с обратным порядком цифр: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        System.out.println();
    }
}

