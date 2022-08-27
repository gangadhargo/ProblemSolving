package com.practice.A;

import java.util.Scanner;

public class PoliceRecruits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int crime = 0;
        int police = 0;
        int ans = 0;
        for(int i=0; i<num;i++){
            int value = scanner.nextInt();
            if(value == -1 && police != 0){
                police--;
            }else if(value == -1){
                crime++;
            }else if(value> -1){
                police += value;
            }

        }
        System.out.println(crime);
    }
}
