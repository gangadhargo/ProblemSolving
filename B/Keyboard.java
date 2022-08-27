package com.practice.B;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Keyboard {
    static FastScanner sc = new FastScanner();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        char[][] keyboard = new char[n][m];
        int[] chars = new int[26];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] ch = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                keyboard[i][j] = ch[j];
                if (keyboard[i][j] == 'S') {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(i + 1);
                    arrayList.add(j + 1);
                    list.add(arrayList);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(keyboard[i][j] == 'S') continue;
                int t = Integer.MAX_VALUE;
                for (int k = 0; k<list.size(); k++){
                    int a = list.get(k).get(0) - (i+1);
                    int b = list.get(k).get(1) - (j+1);
                    int f = (int) Math.ceil(Math.sqrt(a*a+b*b));
                    t = Math.min(f,t);
                }
                if(chars[keyboard[i][j] - 'a'] == 0){
                    chars[keyboard[i][j] - 'a'] = t;
                }else if(chars[keyboard[i][j] - 'a'] > t){
                    chars[keyboard[i][j]     - 'a'] = t;
                }
            }
        }

        int q = sc.nextInt();
        char[] word = sc.next().toCharArray();
        int ans = 0;
        for (int i = 0; i<q; i++){
            if(word[i] < 97){
                if(list.size() == 0 || chars[word[i] - 'A'] == 0){
                    ans = -1;
                    break;
                }else if(chars[word[i] - 'A'] > x){
                    ans++;
                }
            }else if(chars[word[i] - 'a'] == 0){
                ans = -1;
                break;
            }
        }
        System.out.println(ans);
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
