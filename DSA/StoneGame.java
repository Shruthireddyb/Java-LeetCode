class StoneGame {
    public boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                dp[i][j] = Math.max(p[i] - dp[i + 1][j], p[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}