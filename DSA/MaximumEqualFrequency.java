public class MaximumEqualFrequency {
    public int maxEqualFreq(int[] nu) {
        int[] count = new int[100001];
        int[] freq = new int[100001];

        int n = nu.length;
        for (int i = 0; i < n; i++) {
            count[nu[i]]++;
            freq[count[nu[i]]]++;
        }

        for (int i = n - 1; i > 0; i--) {
            if (count[nu[i]] * freq[count[nu[i]]] == i) {
                return i + 1;
            }

            freq[count[nu[i]]]--;
            count[nu[i]]--;

            if (count[nu[i - 1]] * freq[count[nu[i - 1]]] == i) {
            return i + 1;
            }
        }

        return 1;
    }
}
