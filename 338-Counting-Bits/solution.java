public class Solution {
    public int[] countBits(int num) {
        int [] dp = new int[num + 1];
        for(int i = 1; i < num + 1; i++) {
            dp[i] = dp[i>>1];
            if(i%2 > 0) {
                dp[i]++;
            }
        }
        return dp;
    }
}