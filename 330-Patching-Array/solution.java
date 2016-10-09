public class Solution {
    public int minPatches(int[] nums, int n) {
        int res = 0;
        if(nums != null) {
            long toBePatched = 1;
            int i = 0;
            while(toBePatched <= n) {
                if(i < nums.length && nums[i] <= toBePatched) {
                    toBePatched += nums[i];
                    i++;
                } else {
                    toBePatched = toBePatched*2;
                    res++;
                }
            }
        }
        return res;
    }
}