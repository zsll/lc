public class Solution {
    public int maxCoins(int[] nums) {
        int res = 0;
        if(nums != null && nums.length > 0) {
            int len = nums.length;
            int [] a = new int[len + 2];
            len += 2;
            for(int i = 1; i < len - 1; i++) {
                a[i] = nums[i - 1];
            }
            a[0] = 1;
            a[len - 1] = 1;
            int [][] dp = new int[len][len];
            for(int diff = 2; diff < len; diff++) {
                for(int row = 0; row + diff < len; row++) {
                    int col = row + diff;
                    for(int k = row + 1; k < col; k++) {
                        dp[row][col] = Math.max(dp[row][col], dp[row][k] + dp[k][col] + a[k]*a[row]*a[col]);
                    }
                }
            }
            res = dp[0][len - 1];
        }
        return res;
    }
}