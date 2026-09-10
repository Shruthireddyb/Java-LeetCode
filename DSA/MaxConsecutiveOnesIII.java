public class MaxConsecutiveOnesIII {
  public int longestOnes(int[] A, int K) {
        int n = A.length;
        int preSum = 0;
        int res = 0;
        int lo = 0;
        for (int hi = 0; hi < n; hi++) {
            preSum -= (A[hi] == 1 ? 0 : 1);

            if (preSum + K < 0) {
                while (lo < hi && A[lo] == 1) {
                    lo++;
                }
                preSum += 1;
                lo++;
            }

            res = Math.max(res, hi - lo + 1);
        }

        return res;
    }
}