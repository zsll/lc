public class Solution {

    int[] nums = null;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int res = -1, found = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                found++;
                if(found == 0) {
                    res = i;
                } else {
                    Random r = new Random();
                    if(r.nextInt(found) == 0) {
                        res = i;
                    }
                }
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */