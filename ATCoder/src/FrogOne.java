import java.util.Arrays;

public class FrogOne {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 10, 60, 10, 60, 50};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if(i+1 <n) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + Math.abs(arr[i] - arr[i + 1]));
            }
            if(i+2 < n){
                dp[i + 2] = Math.min(dp[i + 2], dp[i] + Math.abs(arr[i] - arr[i + 2]));
            }
        }
        System.out.println(dp[n-1]);
    }
}
