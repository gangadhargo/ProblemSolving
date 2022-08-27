package topcoder.dp;

public class ZigZag {
    public static void main(String[] args) {
        int[] arr = new int[]{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};
        int n = arr.length;
        int[][] dp = new int[n][n];
        //0th is postive
        //1st is negative
        for(int i =0; i<dp.length; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] - arr[j] > 0){
                    dp[i][0] = Math.max(dp[j][1] + 1, dp[i][0]);
                    max = Math.max(dp[i][0], max);
                }else if(arr[i] - arr[j] < 0){
                    dp[i][1] = Math.max(dp[j][0]+1, dp[j][1]);
                    max = Math.max(dp[i][1], max);
                }
            }
        }
        System.out.println(max);
    }
}

