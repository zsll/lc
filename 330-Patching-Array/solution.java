public class Solution {
    public int minPatches(int[] nums, int n) {
        int target = 1, i = 0, res = 0;
        while (target <= n) {
            if(i < nums.length && target >= nums[i]) {
                target += nums[i++];
            } else {
                target *= 2;
                res++;
            }
        }
        return res;
    }
}