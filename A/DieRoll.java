package com.practice.A;

import java.util.Scanner;

public class DieRoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        String[] s = new String[]{"1/6", "1/3", "1/2", "2/3", "5/6", "1/1"};
        int max = Math.max(y, w);
        System.out.println(s[6-max]);
        scanner.close();
    }
}
