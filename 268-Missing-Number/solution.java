public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        if(nums != null && nums.length > 0) {
            repos(nums);
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != i+1) {
                    res = i + 1;
                    break;
                }
            }
        }
        return res;
    }
    
    //put number i to pos i - 1
    void repos(int [] nums) {
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i], newPos = val - 1;
            while(newPos >= 0 && newPos < val && newPos != i && nums[newPos] != val) {
                swap(nums, newPos, i);
                val = nums[i];
                newPos = val - 1;
            }
        }
    }
    
    void swap(int [] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}