package com.practice.A;

import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[5][5];
        int r = 0;
        int c = 0;
        int moves = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        if(r!=2 && c!=2){
            moves = Math.abs(2 - r) + Math.abs(2 - c);
        }else if(r==2 && c!=2){
            moves = Math.abs(2 - c);
        }else if(r!=2 && c == 2){
            moves = Math.abs(2 - r);
        }
        System.out.println(moves);
    }
}
