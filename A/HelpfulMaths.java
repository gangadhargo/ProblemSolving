package com.practice.A;

import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') ones++;
            if (s.charAt(i) == '2') twos++;
            if (s.charAt(i) == '3') threes++;
        }
        String output = "";
        for (int i = 0; i < ones; i++) {
            output += "1+";
        }
        for (int i = 0; i < twos; i++) {
            output += "2+";
        }
        for (int i = 0; i < threes; i++) {
            output += "3+";
        }
        System.out.println(output.substring(0, output.length() - 1));
    }
}
