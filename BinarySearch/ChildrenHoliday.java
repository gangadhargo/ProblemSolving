package com.practice.BinarySearch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ChildrenHoliday {
    static int m, n;
    static int[] t, y, z;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        m = sc.nextInt();
        n = sc.nextInt();
        t = new int[n];
        y = new int[n];
        z = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            z[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int minTime = -1;
        int maxTime = (int) 1e9;
        while (minTime+1 < maxTime){
            int time = minTime+(maxTime - minTime)/2;
            if(good(time)){
                maxTime = time;
            }else{
                minTime = time;
            }
        }

        System.out.println(maxTime);

        int[] ans = new int[n];
        for (int i=0; i<n; i++){
            ans[i] = countMaxBalloons(t[i], z[i], y[i], maxTime);
        }
        int totalBalloons = 0;
        for(int i=0; i<n; i++){
            if(totalBalloons+ans[i] <= m){
                System.out.print(ans[i]+" ");
                totalBalloons+= ans[i];
            }else{
                if(totalBalloons == m){
                    System.out.print(0+" ");
                }else{
                    System.out.print(m-totalBalloons+" ");
                    totalBalloons = m;
                }
            }
        }
    }

    public static int countMaxBalloons (int t, int z, int y, int time){
        int batchTime = (z*t)+y;
        int batches = (time/batchTime);
        int remTime = (time % batchTime);
        int totalBalloons = 0;
        totalBalloons+= batches*z;
        if(remTime!= 0){
            if(remTime/t >= z){
                totalBalloons+=z;
            }else{
                totalBalloons+= (remTime/t);
            }
        }
        return totalBalloons;
    }
    public static boolean isPossible(int t, int z, int y, int balloons, int time){
        int batchTime = (t * z) + y;
        int batches = balloons/z;
        boolean ok = (balloons%z == 0) ? true : false;
        int currTime = 0;
        if(ok){
            batches-= 1;
            currTime = (batchTime * batches) + (z*t);
        }else{
            currTime = (batchTime * batches) + ((balloons % z) * t);
        }
        return currTime <= time;
    }
    public static boolean good(int mid) {
        int totalBalloons = 0;
        for (int i=0; i<n; i++){
            int lo = 0;
            int hi = (int) 1e9;
            while(lo+1 < hi){
                int balloons =  lo+(hi-lo)/2;
                if(isPossible(t[i], z[i], y[i], balloons, mid)){
                    lo = balloons;
                }else {
                    hi = balloons;
                }
            }
            totalBalloons+= lo;
        }
        return totalBalloons>=m;
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
