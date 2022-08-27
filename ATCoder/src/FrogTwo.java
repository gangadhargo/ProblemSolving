import java.util.Arrays;

public class FrogTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 10};
        int n = arr.length;
        int k = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for(int j = i+1; j<=i+k && j < n; j++) {
                dp[j] = Math.min(dp[j], dp[i] + Math.abs(arr[i] - arr[j]));
            }
        }
        System.out.println(dp[n-1]);
    }
}
