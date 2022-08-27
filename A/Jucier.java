package com.practice.A;

import java.util.Scanner;

public class Jucier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int d = scanner.nextInt();
        int waste = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int orange = scanner.nextInt();
            if (orange > b) {
                continue;
            } else {
                count += orange;
                if (count > d) {
                    waste++;
                    count = 0;
                }
            }
        }
        scanner.close();
        System.out.println(waste);
    }
}
