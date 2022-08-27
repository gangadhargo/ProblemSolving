package com.practice.A;

import java.util.Scanner;

public class SerejaAndDima {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        boolean isSereja = true;
        int serejaScore = 0;
        int dimaScore = 0;
        int j = n - 1;
        int i = 0;
        while (i < n) {
            if (j < i && i > j) {
                System.out.println(serejaScore + " " + dimaScore);
                break;

            }
            if (arr[i] > arr[j]) {
                if (isSereja) {
                    serejaScore += arr[i];
                    isSereja = false;
                } else {
                    dimaScore += arr[i];
                    isSereja = true;
                }
                i++;
            } else {
                if (isSereja) {
                    serejaScore += arr[j];
                    isSereja = false;
                } else {
                    dimaScore += arr[j];
                    isSereja = true;
                }
                j--;
            }

        }
        scanner.close();

    }
}