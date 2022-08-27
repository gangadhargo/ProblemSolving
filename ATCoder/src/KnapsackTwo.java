public class KnapsackTwo {
    public static void main(String[] args) {
        int n = 0;
        int w = 0;
        int[][] dp = new int[n+1][w+1];
        //dp[i] = maximum total value of items with total weight capacity
        for(int i = 0; i< n; i++){
//            3 8
//            3 30
//            4 50
//            5 60

            int item = 0;
            int weight = 0;
            for(int j = 0; j<=w; j++){
                if(weight <= w) {
                    dp[i+1][j] = Math.max(dp[i][j], dp[i][j-weight] + item);
                }else{
                    dp[i+1][j] = dp[i][j];
                }
            }
        }
        System.out.println(dp[n][w]);
    }
}
