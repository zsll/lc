public class Solution {
    public int maxSubArray(int[] nums) {
        int res = 0;
        if(nums != null && nums.length > 0) {
            int sum = nums[0];
            res = sum;
            for(int i = 1; i < nums.length; i++) {
                sum = Math.max(sum + nums[i], nums[i]);
                res = Math.max(sum, res);
            }
        }
        return res;
    }
}