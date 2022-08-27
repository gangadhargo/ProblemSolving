package com.practice.A.Graphs;

import java.io.*;
import java.util.StringTokenizer;

public class BattleShips {
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);

    private static int battleship(char[][] battle){
        int size = battle.length;
        int count = 0;
        boolean[][] visited = new boolean[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(battle[i][j] == 'x' && !visited[i][j]){
                    count++;
                    dfs(battle, i, j, size, visited);
                }
            }
        }
        return count;
    }
    private static void dfs(char[][] battle, int i, int j, int size, boolean[][] visited){
        if (i < 0 || j < 0 || i >= size || j >= size || visited[i][j] || battle[i][j] == '.') return;
        visited[i][j] = true;
        dfs(battle, i+1, j, size, visited);
        dfs(battle, i, j+1, size, visited);
        dfs(battle, i-1, j, size, visited);
        dfs(battle, i, j-1, size, visited);
    }
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        char[][] battle = new char[n][n];
        for (int i=0; i<n; i++){
            String str = sc.next();
            for (int j=0; j<n; j++){
                battle[i][j] = str.charAt(j);
            }
        }
        System.out.println(battleship(battle));
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
