package com.practice.A;

import java.util.Scanner;

public class NightAtTheMuseum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int ch = 97;
        int min = 0;
        for (int i = 0; i<s.length();i++){
            int c = s.charAt(i);
            min += Math.min(Math.abs(ch - c), 26 - Math.abs(ch-c));
            ch = c;
        }
        System.out.println(min);
    }
}
