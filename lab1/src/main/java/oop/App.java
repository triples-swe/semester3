package oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку " + (i + 1) + ": ");
            strings.add(scanner.nextLine());
        }

        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                }
                return s1.compareTo(s2);
            }
        });

        System.out.println("\nСтроки после сортировки:");
        for (String str : strings) {
            System.out.println(str + " (длина: " + str.length() + ")");
        }
    }
}