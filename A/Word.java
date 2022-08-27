package com.practice.A;

import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLowerCase(str.charAt(i))) {
                count++;
            }
        }
        String ans = "";
        if (count > str.length() - count) {
            ans = str.toUpperCase();
        } else {
            ans = str.toLowerCase();
        }
        System.out.println(ans);
    }
}
