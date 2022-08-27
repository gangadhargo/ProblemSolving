package com.practice.B;

import java.io.*;
import java.util.*;

public class MrKitayutasColorfulGraph {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        BMrKitayutasColorfulGraph solver = new BMrKitayutasColorfulGraph();
        solver.solve(1, in, out);
        out.close();
    }

    static class BMrKitayutasColorfulGraph {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt(), m = in.readInt();
            MyWeightedGraph graph = new MyWeightedGraph(n);
            for (int i = 0; i < m; i++) {
                graph.addEdge(in.readInt() - 1, in.readInt() - 1, in.readInt());
            }
            System.out.println(Arrays.deepToString(graph.adj.toArray()));
            int q = in.readInt();
            for (int i = 0; i < q; i++) {
                out.printLine(graph.count(in.readInt() - 1, in.readInt() - 1));
            }


        }

    }

    static class MyWeightedGraph {
        public ArrayList<ArrayList<MyWeightedGraph.Edge>> adj;
        int n;
        long edges;
        long vertices;
        boolean[] vis;

        public MyWeightedGraph(int n) {
            this.n = n;
            edges = vertices = 0;
            vis = new boolean[n];
            adj = new ArrayList<>();
            for (long i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int from, int to, int weight) {
            adj.get(from).add(new MyWeightedGraph.Edge(to, weight));
            adj.get(to).add(new MyWeightedGraph.Edge(from, weight));
        }

        public int count(int u, int v) {
            int count = 0;
            boolean[] visited = new boolean[n];
            HashSet<Integer> hs = new HashSet<>();
            for (MyWeightedGraph.Edge edge : adj.get(u)) {
                Arrays.fill(visited, false);
                visited[u] = true;
                if (dfs2(edge, visited, v) >= 1)
                    hs.add(edge.getWeight());
            }
            return hs.size();
        }

        private int dfs2(MyWeightedGraph.Edge edge, boolean[] visited, int v) {
            visited[edge.getTo()] = true;
            if (edge.getTo() == v) return 1;
            int count = 0;
            for (MyWeightedGraph.Edge it : adj.get(edge.getTo())) {
                if (it.getWeight() == edge.getWeight() && !visited[it.getTo()]) {
                    count += dfs2(it, visited, v);
                }
            }
            return count;

        }

        static class Edge {
            int from = -1;
            int to;
            int weight;

            public Edge(int from, int to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            public Edge(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }

            public int getTo() {
                return to;
            }

            public int getWeight() {
                return weight;
            }

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
        }

    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);

        }

    }
}
