package com.practice.A;

import java.util.Scanner;

public class ColorfulStones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        int count = 0;
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if(s.charAt(i) == t.charAt(j)){
                count++;
                i++;
            }
        }
        System.out.println(count + 1);
    }
}
