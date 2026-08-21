public class DistinctSubsequences{
  public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == n) return s.equals(t) ? 1 : 0;
        if (m < n) return 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        
        return dp[n][m];
    }
}