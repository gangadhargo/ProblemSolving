import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Contest
 */
public class Subordinates {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n;
    static int[] subTree;
    /**
     * @param args
     */
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        
         n = sc.nextInt();
         subTree = new int[n+2];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=2; i<=n; i++){
            int boss = sc.nextInt();
            graph.get(boss).add(i);
            graph.get(i).add(boss);
        }
        dfs(1, 0);
        
        for(int i=1; i<=n; i++){
            System.out.print(subTree[i]+" ");
        }

    }
    

    private static void dfs(int src, int par) {
        int subOrd = 0;
        for(int i=0; i<graph.get(src).size(); i++){
            int child = graph.get(src).get(i);
            if(child!= par){
                dfs(child, src);
                subOrd+= 1 + subTree[child];
            }
        }
        subTree[src] = subOrd;
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