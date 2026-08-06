public class MajorityElement {
    public int majorityElement(int[] n) {
        int ele = 0, vote = 0;
        for (int num : n) {
            if (ele == num && vote > 0) {
                vote += 1;
            } else if (vote == 0) {
                ele = num;
                vote = 1;
            } else {
                vote -= 1;
            }
        }
        return ele;
        
    }
}
