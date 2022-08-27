package com.practice.A;

import java.util.Scanner;

public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] ch1 = scanner.next().toCharArray();
        char[] ch2 = scanner.next().toCharArray();
        int k = 2;
        for (int i = 0; i < ch1.length; i++) {
            if (Character.toLowerCase(ch1[i]) > Character.toLowerCase(ch2[i])) {
                k = 1;
                break;
            } else if (Character.toLowerCase(ch1[i]) < Character.toLowerCase(ch2[i])) {
                k = -1;
                break;
            }
        }
        System.out.println(k == 2 ? 0 : k);
    }
}
