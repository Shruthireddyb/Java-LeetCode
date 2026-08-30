import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        if (index == nums.length) {
            res.add(cur);
            return;
        }
        
        cur.add(nums[index]);
        helper(res, cur, nums, index + 1);
        cur.remove(cur.size() - 1);
        
        while (index + 1 < nums.length && nums[index + 1] == nums[index]) {
            index++;
        }
        helper(res, cur, nums, index + 1);
    }
}