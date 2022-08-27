package com.practice.B;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Barcode {
    static FastScanner sc = new FastScanner();

    public static void main(String[] args) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        char[][] arr = new char[1005][1005];
        int[] blue = new int[1005];
        int[] white = new int[1005];
        int[][] dp = new int[5][1005];
        int cb, cw;
        for (int i = 1; i <= m; i++) {
            String s = sc.next();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = s.charAt(j-1);
            }
        }
        for (int i = 1; i <= n; i++) {
            cb = 0;
            cw = 0;
            for (int j = 1; j <= m; j++) {
                if (arr[j][i] == '#') {
                    cb++;
                } else {
                    cw++;
                }
            }
            if (i > 1) {
                blue[i] = blue[i - 1] + cb;
                white[i] = white[i - 1] + cw;
            } else {
                blue[i] = cb;
                white[i] = cw;
            }
        }
        System.out.println(Arrays.toString(blue));
        System.out.println(Arrays.toString(white));
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, dp.length));
        dp[1][0] = 0;
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = x; j <= y && j <= i; j++) {
                dp[0][i] = Math.min(dp[0][i], dp[1][i - j] + blue[i] - blue[i - j]);
            }
            for (int j = x; j <= y && j <= i; j++) {
                dp[1][i] = Math.min(dp[1][i], dp[0][i - j] + white[i] - white[i - j]);
            }
        }
        System.out.println(Math.min(dp[0][n], dp[1][n]));

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
