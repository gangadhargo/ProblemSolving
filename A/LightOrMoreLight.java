package com.practice.A;

import java.util.Scanner;

public class LightOrMoreLight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            long num = -1;
            while((num = scanner.nextLong())!= 0){
                long sq = (long) Math.floor(Math.sqrt(num));
                System.out.println(sq * sq == num ? "yes" : "no");
            }
        }
    }
}
//    Sample Input
//3
//        6241
//        8191
//        0
//        Sample Output
//        no
//        yes
//        no