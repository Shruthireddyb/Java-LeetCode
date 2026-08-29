public class PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        return helper(nums, sum / 2, new boolean[nums.length]);
    }
    private boolean helper(int[] nums, int target, boolean[] visited) {
        if (target == 0) return true;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            if (visited[i]) continue;
            visited[i] = true;
            if (target - nums[i] >= 0 && helper(nums, target - nums[i], visited)) return true;
            visited[i] = false;
        }
        return false;
    }
    // Backtracking
    public boolean cannPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        return dfs(nums, 0, sum / 2);
    }
    private boolean dfs(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index == nums.length || target < 0) return false;
        if (dfs(nums, index + 1, target - nums[index])) return true;
        // Skip the same values, in case TLE
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) {
            j++;
        }
        return dfs(nums, j, target);
    }
}