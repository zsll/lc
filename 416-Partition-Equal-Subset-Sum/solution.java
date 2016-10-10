public class Solution {
    public boolean canPartition(int[] nums) {
        boolean res = false;
        if(nums != null && nums.length > 0) {
            int sum = sum(nums);
            if(sum%2 == 0) {
                int len = nums.length;
                int half = sum/2;
                boolean [][] f = new boolean[len + 1][half + 1];
                for(int i = 0; i <= len; i++) {
                    f[i][0] = true; //can always sum up to 0
                    for(int j = 1; j <= half; j++) {
                        if(i == 0) {
                            f[i][j] = false;
                        } else {
                            f[i][j] = f[i - 1][j] || j >= nums[i - 1] && f[i - 1][j - nums[i - 1]];
                        }
                    }
                }
                res = f[len][half];
            }
        }
        return res;
    }
    
    int sum(int [] nums) {
        int res = 0;
        for(int i : nums) {
            res += i;
        }
        return res;
    }
}