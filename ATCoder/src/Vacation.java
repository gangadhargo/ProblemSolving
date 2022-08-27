public class Vacation {
    public static void main(String[] args) {
        int n = 1;
        int[] dp = new int[3];
        //dp[i] = total activity such that we did activity i on the last considered day
        for (int i = 0; i < n; i++) {
            int[] dp1 = new int[3];
            int arr[] = new int[3];
            arr[0] = 100;
            arr[1] = 10;
            arr[2] = 1;
//            for(int j = 0; j < 3; j++){
//                arr[j] =
//            }
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (k != l) {
                        dp1[l] = Math.max(dp1[l], dp[k] + arr[l]);
                    }
                }
            }
            dp = dp1;
        }

        System.out.println(dp[0]);
        System.out.println(dp[1]);
        System.out.println(dp[2]);
    }
}
