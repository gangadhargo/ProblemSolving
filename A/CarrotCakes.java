package com.practice.A;

import java.util.Scanner;

public class CarrotCakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        int time = 0;
        while (time <= d) {
            n -= k;
            time += t;
        }

        System.out.println(n > 0 ? "YES" : "NO");
    }
}
