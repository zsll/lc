public class Solution {
    public void moveZeroes(int[] nums) {
        int end = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(i > end) {
                    nums[end] = nums[i];
                }
                end++;
            }
        }
        for(int i = end; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}