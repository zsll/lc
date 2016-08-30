public class Solution {
    public void moveZeroes(int[] nums) {
        int to = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[to++] = nums[i];
            }
        }
        for(int i = to; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}