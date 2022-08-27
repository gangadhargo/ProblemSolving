package com.practice.A;

import java.util.Scanner;

public class StonesOnTheTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = scanner.next();
        int i = 0;
        int j = 1;
        int count = 0;
        while (i < num && j < num) {
            if (s.charAt(i) == s.charAt(j)){
                count++;
            }
            i++;
            j++;
        }
        System.out.println(count);
    }
}
