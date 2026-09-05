import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subStr = s.substring(i, j);
                if (wordSet.contains(subStr) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        
        return dp[n];
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int lo = 1; lo <= n; lo++) {
            if (!dp[lo - 1]) continue;
            for (String word : wordDict) {
                int hi = lo - 1 + word.length();
                if (hi <= n && s.substring(lo - 1, hi).equals(word)) {
                    dp[hi] = true;
                }
            }
        }
        
        return dp[n];
    }
}