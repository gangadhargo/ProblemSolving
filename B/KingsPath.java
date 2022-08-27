package com.practice.B;

import javafx.util.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class KingsPath {
    static FastScanner sc = new FastScanner();
    static int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    static HashMap<Pair<Integer, Integer>, Integer> map = new HashMap();

    private static int bfs(int x, int y, int x1, int y1) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Pair<Integer, Integer> pair = new Pair<>(x, y);
        queue.offer(pair);
        map.put(pair, 0);
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pa = queue.poll();
            int a = pa.getKey();
            int b = pa.getValue();
            if (a == x1 && b == y1) {
                return map.get(pa);
            }
            for (int j = 0; j < 8; j++) {
                Pair<Integer, Integer> nextPair = new Pair<>(a + dir[j][0], b + dir[j][1]);
                if (map.containsKey(nextPair) && map.get(nextPair) == -1) {
                    map.put(nextPair, map.get(pa) + 1);
                        queue.offer(nextPair);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j <= b; j++) {
                Pair<Integer, Integer> pair = new Pair<>(r, j);
                map.put(pair, -1);
            }
        }
        Pair<Integer, Integer> pa = new Pair<>(x1, y1);
        if (map.containsKey(pa) && map.get(pa) != -1) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(bfs(x0, y0, x1, y1));
        }
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
