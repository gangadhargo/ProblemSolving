package com.practice.A;

import java.util.Scanner;

public class AntonAndDanik {
    //https://codeforces.com/contest/734/problem/A
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int aCount = 0;
        int dCount = 0;
        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == 'A') {
                aCount++;
            } else {
                dCount++;
            }
        }
        scanner.close();
        System.out.println(aCount == dCount ? "Friendship" : aCount > dCount ? "Anton" : "Danik");
    }
}
