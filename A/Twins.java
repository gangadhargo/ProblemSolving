package com.practice.A;

import java.util.Arrays;
import java.util.Scanner;

public class Twins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
            sum+= arr[i];
        }
        Arrays.sort(arr);
        int count = 0;
        int localSum = 0;
        for (int i = num-1; i >=0 ; i--) {
            localSum+=arr[i];
            count++;
            if(localSum > sum/2){
                break;
            }
        }
        System.out.println(count);
    }
}
