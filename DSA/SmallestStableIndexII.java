public class SmallestStableIndexII {
    public int firstStableIndex(int[] nu, int k) {
        int n = nu.length;
        int[] minValue = new int[n];
        minValue[n - 1] = nu[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minValue[i] = Math.min(minValue[i + 1], nu[i]);
        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, nu[i]);
            if (maxValue - minValue[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}