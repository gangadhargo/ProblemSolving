package com.practice.A;

import java.util.Scanner;

public class LinelandMail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        for(int i=0; i<n; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            max = Math.max(Math.abs(arr[i]-arr[0]),Math.abs(arr[i] - arr[n-1]));
            if(i == 0) {
                min = Math.abs(arr[i]-arr[i+1]);
            }else if(i == n-1) {
                min = Math.abs(arr[i]-arr[i-1]);
            }else {
                min = Math.min(Math.abs(arr[i]-arr[i-1]), Math.abs(arr[i] - arr[i+1]));
            }
            System.out.println(min+" "+max);
        }
    }
}
