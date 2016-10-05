public class Solution {
    public int rob(int[] nums) {
        int res = 0;
        if(nums != null && nums.length > 0) {
            int len = nums.length;
            int [] dp = new int[3];
            dp[1] = nums[0];
            for(int i = 2; i <= len; i++) {
                dp[i%3] = Math.max(dp[(i - 1)%3], nums[i - 1] + dp[(i - 2)%3]);
            }
            res = dp[len%3];
        }
        return res;
    }
}