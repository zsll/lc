public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int res = 0;
        if(nums != null && nums.length > 0) {
            int [] dp = new int[target + 1];
            dp[0] = 1;
            for(int i = 1; i <= target; i++) {
                for(int j = 0; j < nums.length; j++) {
                    if(i >= nums[j]) {
                        dp[i] += dp[i - nums[j]];
                    }
                }
            }
            res = dp[target];
        }
        return res;
    }
}