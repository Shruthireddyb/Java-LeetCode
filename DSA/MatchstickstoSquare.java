import java.util.*;

public class MatchstickstoSquare {
  public boolean makesquare(int[] nums) {
        if (nums.length == 0) return false;
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) return false;
        return dfs(nums, 0, 0, sum / 4, 1, new boolean[n]);
    }
    private boolean dfs(int[] nums, int index, int tmp, int target, int group, boolean[] visited) {
        if (group == 4) return true;
        if (tmp > target) return false;
        if (target == tmp) return dfs(nums, 0, 0, target, group + 1, visited);
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            if (dfs(nums, i + 1, tmp + nums[i], target, group, visited)) return true;
            visited[i] = false;
        }
        return false;
    }
}