import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        int n = num.length;
        for (int i = 0; i < n - 2; i++) {
            if (num[i] > 0) break;
            if (i > 0 && num[i] == num[i - 1]) continue;
            
            int target = 0 - num[i];
            int lo = i + 1, hi = n - 1;
            
            while (lo < hi) {
                int tmpSum = num[lo] + num[hi];
                if (tmpSum == target) {
                    res.add(Arrays.asList(new Integer[]{num[i], num[lo], num[hi]}));
                    lo++;
                    while (lo < hi && num[lo] == num[lo - 1]) lo++;
                    hi--;
                    while (lo < hi && num[hi] == num[hi + 1]) hi--;
                } else if (tmpSum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        
        return res;
    }
}