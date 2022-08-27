package problems.graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheGreatRevegetation {
    public static void main(String[] args) throws IOException {
        Kattio scanner = new Kattio("TheGreatRevegetation");
        int n = scanner.nextInt();
        int[] indegree = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            indegree[a-1]++;
            indegree[b-1]++;
        }

        int maxdegree = 0;
        System.out.println(Arrays.toString(indegree));
        for (int i = 0; i < n; i++) {
            maxdegree = Math.max(maxdegree, indegree[i]);
        }
        System.out.println(maxdegree+1);
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}


