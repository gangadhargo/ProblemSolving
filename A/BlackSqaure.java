package com.practice.A;

import java.util.Scanner;

public class BlackSqaure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cal = new int[4];
        for(int i = 0; i<4; i++){
            cal[i] = scanner.nextInt();
        }
        String s = scanner.next();
        int wasted = 0;
        for(int i = 0; i<s.length(); i++){
            int num = Character.getNumericValue(s.charAt(i));
            wasted+=cal[num - 1];
        }

        System.out.println(wasted);
    }
}
