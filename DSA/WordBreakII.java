import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
  List<String> res = new ArrayList<>();
    Set<String> wordSet;
    public List<String> wordBreak(String s, List<String> wordDict) {
        int[] count = new int[26];
        for (String word : wordDict) {
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
        }
        
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 0) return res;
        }
        
        wordSet = new HashSet<>(wordDict);
        dfs(s, 0, new StringBuilder());
        return res;
    }
    
    private void dfs(String s, int index, StringBuilder cur) {
        int n = s.length();
        if (index == n) {
            res.add(cur.toString());
            return;
        }
        
        for (int i = index; i < n; i++) {
            if (wordSet.contains(s.substring(index, i + 1))) {
                int beforeAdding = cur.length();
                if (beforeAdding == 0) {
                    cur.append(s.substring(index, i + 1));
                } else {
                    cur.append(" ");
                    cur.append(s.substring(index, i + 1));
                }
                dfs(s, i + 1, cur);
                cur.delete(beforeAdding, cur.length());
            }
        }
    }
}