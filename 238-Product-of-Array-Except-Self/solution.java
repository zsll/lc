public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] res = new int[len];
        int left = 1, right = 1;
        for(int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }
        for(int i = 0; i < nums.length; i++) {
            res[i] *= left;
            res[len - i - 1] *= right;
            left *= nums[i];
            right *= nums[len - i - 1];
        }
        return res;
    }
}