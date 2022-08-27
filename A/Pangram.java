package com.practice.A;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = scanner.next();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<num; i++){
            char ch = Character.toLowerCase(s.charAt(i));
            if(!set.contains(ch)){
                set.add(ch);
            }
        }
        System.out.println(set.size()!= 26 ? "NO" : "YES");
    }
}
