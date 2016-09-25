public class Solution {
    /**
     * There are n minus 1 blocks
     * boolean dp[i][j] means it can reach i th stone with last step j, where j is smaller or equal to i
     * dp[i][j] = true if exist dp[k][j - 1], dp[k][j] ,dp[k][j + 1] is true and distance between ith and kth stone is j, where k is between 1 and i - 1
     * initialization: dp[0][0] = true, the jump actually starts from 1
     * dp[i][0] = false when i > 0
     * dp[1][1] = true if distance between stone 0 and 1 is 1
     * dp[1][i] = false where i > 1
     * 
     */
    public boolean canCross(int[] stones) {
         boolean res = true;
        if(stones != null && stones.length > 1) {
            int len = stones.length;
            boolean [][] dp = new boolean[len][len];
             res = false;
            if(stones[1] - stones[0] == 1) {
                dp[1][1] = true;
                for(int i = 2; i < len; i++) {

                    for(int j = 1; j <= i; j++) {
                        for(int k = 1; k <= i - 1; k++) {
                            if(stones[i] - stones[k] == j && (j - 1 >= 1 && dp[k][j - 1] || dp[k][j] || j + 1 < len && dp[k][j + 1] ) ){
                                dp[i][j] = true;
                                break;
                            }
                        }
                    }
                }
                for(int i = 1; i < dp[len - 1].length; i++) {
                    if(dp[len - 1][i]) {
                        res = true;
                        break;
                    }
                }
            }
        }
        return res;
    }
}