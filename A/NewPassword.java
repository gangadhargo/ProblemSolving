package com.practice.A;

import java.util.Scanner;

public class NewPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] str = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++){
            sb.append(str[i]);
        }
        if(sb.length() == n){
            System.out.println(sb);
        }else{
            StringBuilder sb1 = new StringBuilder();
            for(int i=0; i< sb.length(); i++){
                sb1.append(sb.charAt(i));
                if((sb1.length()+sb.length()) == n) break;
                if(i == sb.length()-1){
                    i=-1;
                }
            }
            System.out.println(sb.append(sb1));
        }
    }
}
