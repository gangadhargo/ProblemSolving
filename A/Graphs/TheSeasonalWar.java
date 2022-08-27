package com.practice.A.Graphs;

import java.io.*;
import java.util.StringTokenizer;

public class TheSeasonalWar {
    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
    private static int seasonalWar(int[][] arr) {
        int n = arr.length;
        boolean[][] visited = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(arr, i, j, n, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static int dx[] = { 0, 0, 1, -1, -1, 1, -1, 1 }, dy[] = { 1, -1, 0, 0, -1, 1, 1, -1 };
    private static void dfs(int[][] arr, int i, int j, int n, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || arr[i][j] == 0) return;
        visited[i][j] = true;
        for(int k=0; k<8; k++){
            dfs(arr, i + dx[k], j+dy[k], n, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
        }
        System.out.println(seasonalWar(arr));
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
