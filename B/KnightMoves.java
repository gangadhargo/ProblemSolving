package com.practice.B;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class KnightMoves {
    static FastScanner sc = new FastScanner();
    static int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};
    static int d[][] = new int[10][10];

    private static boolean isValid(int r, int c) {
        return (r >= 0 & c >= 0 && r < 8 && c < 8);
    }

    private static int bfs(int sr, int sc, int tr, int tc) {
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                d[i][j] = -1;
            }
        }
        d[sr][sc] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sr);
        queue.offer(sc);
        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();
            if (r == tr && c == tc) return d[r][c];
            for (int i = 0; i < 8; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc)) continue;
                if (d[nr][nc] == -1) {
                    d[nr][nc] = d[r][c] + 1;
                    queue.offer(nr);
                    queue.offer(nc);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            int move = bfs(s1.charAt(1) - '1', s1.charAt(0) - 'a', s2.charAt(1) - '1', s2.charAt(0) - 'a');
            System.out.println("To get from "+ s1 +" to "+ s2 +" takes "+ move +" knight moves.");
        }
        //System.out.println(ans);
    }

    static class FastScanner {
        InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }

        private int readByte() {
            if (hasNextByte())
                return buffer[ptr++];
            else
                return -1;
        }

        private boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr]))
                ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public char[] nextCA() {
            return next().toCharArray();
        }

        public long nextLong() {
            if (!hasNext())
                throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while (true) {
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                } else if (b == -1 || !isPrintableChar(b)) {
                    return minus ? -n : n;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
                throw new NumberFormatException();
            return (int) nl;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIA(int N) {
            int[] a = new int[N];
            for (int i = 0; i < N; i++) a[i] = this.nextInt();
            return a;
        }

        public int[] nextIA(int N, boolean flag) {
            int[] a = new int[N];
            for (int i = 0; i < N; i++) a[i] = this.nextInt() - 1;
            return a;
        }

        public long[] nextLA(int N) {
            long[] a = new long[N];
            for (int i = 0; i < N; i++) a[i] = this.nextLong();
            return a;
        }

        public double[] nextDA(int N) {
            double[] a = new double[N];
            for (int i = 0; i < N; i++) a[i] = this.nextDouble();
            return a;
        }

        public boolean[][] bgrid(int H, int W, char c) {
            boolean[][] a = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                char[] s = this.nextCA();
                for (int j = 0; j < W; j++) a[i][j] = s[j] == c;
            }
            return a;
        }

        public long[][] nextLongMatrix(int height, int width) {
            long[][] mat = new long[height][width];
            for (int h = 0; h < height; h++)
                for (int w = 0; w < width; w++) {
                    mat[h][w] = this.nextLong();
                }
            return mat;
        }

        public int[][] nextIntMatrix(int height, int width) {
            int[][] mat = new int[height][width];
            for (int h = 0; h < height; h++)
                for (int w = 0; w < width; w++) {
                    mat[h][w] = this.nextInt();
                }
            return mat;
        }

        public double[][] nextDoubleMatrix(int height, int width) {
            double[][] mat = new double[height][width];
            for (int h = 0; h < height; h++)
                for (int w = 0; w < width; w++) {
                    mat[h][w] = this.nextDouble();
                }
            return mat;
        }

        public char[][] nextCharMatrix(int height, int width) {
            char[][] mat = new char[height][width];
            for (int h = 0; h < height; h++) {
                String s = this.next();
                for (int w = 0; w < width; w++) {
                    mat[h][w] = s.charAt(w);
                }
            }
            return mat;
        }
    }
}
