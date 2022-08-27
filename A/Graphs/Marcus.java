package com.practice.A.Graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Marcus {
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
    static List<String> ans = new ArrayList<>();
    private static String marcus(char[][] chars, int num1, int num2) {

                String path = "IEHOVA#";
                int x = -1;
                int y = -1;
        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                if(chars[i][j] == '@'){
                    x = i;
                    y = j;
                }
            }
        }
        String output = "";
        for(int k=0; k<path.length(); k++){
            if(path.charAt(k) == chars[x][y-1]){
                output+="left"+" ";
                y--;
            }else if(path.charAt(k) == chars[x][y+1]){
                output+="right"+" ";
                y++;
            }else{
                output+="forth"+" ";
                x--;
            }
        }
        return output.trim();
    }
    public static void main(String[] args) throws IOException {
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        char[][] ch = new char[num1][num2];
        for(int i=0; i<num1; i++){
            String str = sc.next();
            for (int j=0; j<num2;j++){
                ch[i][j] = str.charAt(j);
            }
        }
        System.out.println(marcus(ch, num1, num2));
    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready() || st.hasMoreTokens();
        }
    }
}
