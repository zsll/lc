public class Solution {
    /**
     * 

dp1 i means max length of wiggle sequence before ending with i, and previous diff is positive

dp2 i means max length of wiggle sequence before ending with i, and previous diff is negative


dp1 i equals max of dp2 j + 1, j = 0 ... i - 1, and num j is larger than num i
dp2 i equals max of dp1 j + 1, j = 0 ... i - 1, and num j is smaller than num i
*/
    public int wiggleMaxLength(int[] nums) {
        int res = 0;
        if(nums != null && nums.length > 0) {
            
                res = 1;
                int len = nums.length;
                int [] dp1 = new int[len];
                int [] dp2 = new int[len];
                dp1[0] = 1;
                dp2[0] = 1;
                for(int i = 1; i < len; i++) {
                    for(int j = 0; j < i; j++) {
                        if(nums[j] > nums[i]) {
                            dp1[i] = Math.max(dp1[i], dp2[j] + 1);
                        } else if (nums[j] < nums[i]) {
                            dp2[i] = Math.max(dp2[i], dp1[j] + 1);
                        }
                    }
                    res = Math.max(res, dp1[i]);
                    res = Math.max(res, dp2[i]);
                }
            
        }
        return res;
    }
}