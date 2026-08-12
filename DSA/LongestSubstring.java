import java.util.*;
class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int lo = 0, hi = 0;
        int maxLen = 1;
        int n = s.length();

        Set<Character> set = new HashSet<>();
        for (; hi < n; hi++) {
            char cur = s.charAt(hi);
            if (!set.add(cur)) {
                while (lo < hi && s.charAt(lo) != cur) {
                    set.remove(s.charAt(lo));
                    lo++;
                }

                lo++;
            }

            maxLen = Math.max(maxLen, hi - lo + 1);
        }

        return maxLen;
    }
}