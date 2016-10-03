public class Solution {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        if(nums != null) {
            for(int i = 0; i < nums.length; i++) {
                if(res < 2 || (nums[res - 1] != nums[i] || nums[res - 2] != nums[i]) ) {
                    if(res < i) {
                        nums[res] = nums[i];
                    }
                    res++;
                }
            }
        }
        return res;
    }
}