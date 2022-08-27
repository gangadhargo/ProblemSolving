package com.practice.A;


import java.util.Scanner;

public class OathoftheNightsWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        for(int i=0; i<n; i++){
            if(arr[i]>min && arr[i] < max){
                count++;
            }
        }
        System.out.println(count);
    }
}
