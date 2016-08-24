public class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        if(nums != null && nums.length > 0) {
            int max = nums[0], min = nums[0];
            res = max;
            for(int i = 1; i < nums.length; i++) {
                int preMax = max;
                max = Math.max(Math.max(nums[i], max*nums[i]), min*nums[i]);
                min = Math.min(Math.min(nums[i], min*nums[i]), preMax*nums[i]);
                res = Math.max(res, max);
            }
        }
        return res;
    }
}