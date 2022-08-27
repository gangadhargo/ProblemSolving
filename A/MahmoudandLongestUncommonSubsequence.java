package com.practice.A;

import java.util.Scanner;

public class MahmoudandLongestUncommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        if(a.equals(b)){
            System.out.println(-1);
        }else{
            System.out.println(Math.max(a.length(), b.length()));
        }
    }
}
