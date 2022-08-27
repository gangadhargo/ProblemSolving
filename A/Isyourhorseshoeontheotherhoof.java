package com.practice.A;

import java.util.HashSet;
import java.util.Scanner;

public class Isyourhorseshoeontheotherhoof {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i =0 ;i<4; i++){
            int n = scanner.nextInt();
            if(!set.contains(n)){
                set.add(n);
            }else{
                count++;
            }
        }
        System.out.println(count);
    }
}
