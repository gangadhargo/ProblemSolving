package com.practice.A;

import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            ans[arr[i]-1] = i + 1;
        }
        String s = "";
        for(int i=0; i<n; i++){
            s+=ans[i] +" ";
        }
        System.out.println(s.trim());
    }
}
