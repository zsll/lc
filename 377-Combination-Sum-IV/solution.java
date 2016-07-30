public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int [] res = {0};
        combinationSum4Helper(nums, target, res);
        return res[0];
    }
    
    public void combinationSum4Helper(int [] nums, int target, int [] res) {
        if(target == 0) {
            res[0]++;
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(target >= nums[i]) {
                    combinationSum4Helper(nums, target - nums[i], res);
                }
            }
        }
    }
}