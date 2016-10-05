public class Solution {
    public int maxProduct(int[] nums) {
        int res = 0;
        if(nums != null && nums.length > 0) {
            int max = nums[0], min = nums[0];
            res = nums[0];
            for(int i = 1; i < nums.length; i++) {
                int preMax = max;
                max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
                min = Math.min(nums[i], Math.min(nums[i] * preMax, nums[i] * min));
                res = Math.max(res, max);
            }
        }
        return res;
    }
}