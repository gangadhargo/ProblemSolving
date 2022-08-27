package com.practice.A;

import java.util.Scanner;

public class BearAndBigBrother {
    //https://codeforces.com/contest/791/problem/A
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w1 = scanner.nextInt();
        int w2 = scanner.nextInt();
        boolean isGreater = false;
        int count = 0;
        while(!isGreater){
            w1 = w1 * 3;
            w2 = w2 * 2;
            count++;
            if(w1 > w2){
                isGreater = true;
            }
        }
        scanner.close();
        System.out.println(count);
    }
}
