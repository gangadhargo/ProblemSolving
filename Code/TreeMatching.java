import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeMatching {
    static int[] dp1;
    static int[] dp2;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        dp1 = new int[n];
        dp2 = new int[n];
        for(int i=0; i<n-1; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(0, 0);
        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));
        System.out.println(Math.max(dp1[0], dp2[0]));
    }
    private static void dfs(int u, int p) {
        for(int i=0; i<graph.get(u).size(); i++){
            int node = graph.get(u).get(i);
            if(node == p) continue;
            dfs(node, u);
            dp2[u] += Math.max(dp1[node], dp2[node]);
        }

        for(int i=0; i<graph.get(u).size(); i++){
            int node = graph.get(u).get(i);
            if(node == p) continue;
            dp1[u] = Math.max(dp1[u], 1 + dp2[u] + dp2[node] - Math.max(dp1[node], dp2[node]));

        }

    }
    static class FastScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;
 
        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }
 
        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
 
            return tokenizer.nextToken("\n");
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
         
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
    }
}
