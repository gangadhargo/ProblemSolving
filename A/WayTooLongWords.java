package com.practice.A;

import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            String str = words[i];
            if (str.length() > 10) {
                System.out.println(Character.toString(str.charAt(0)) + str.substring(1, str.length() - 1).length() + str.charAt(str.length() - 1));
            } else {
                System.out.println(str);
            }
        }
        scanner.close();
    }
}
