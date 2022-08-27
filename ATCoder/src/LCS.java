public class LCS {
    public static void main(String[] args) {
        String a = "abed";
        String b = "ac";
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        //dp[i][j] max total length so far

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}
