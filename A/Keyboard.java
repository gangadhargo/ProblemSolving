package com.practice.A;

import java.util.Scanner;

public class Keyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String d = scanner.next();
        String s = scanner.next();
        String keys = "qwertyuiopasdfghjkl;zxcvbnm,./";
        String output = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(d.equals("R")){
                output+= keys.charAt(keys.indexOf(ch)-1);
            }else{
                output+= keys.charAt(keys.indexOf(ch)+1);
            }
        }
        System.out.println(output);
    }
}
