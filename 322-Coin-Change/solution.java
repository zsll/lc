public class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = 0;
        if(amount > 0 && coins != null && coins.length > 0) {
            res = -1;
            int len = coins.length;
            int [] dp = new int[amount + 1];
            for(int i = 1; i <= amount; i++) {
                dp[i] = i + 1;//Integer.MAX_VALUE;	//The problem is that 1 + Integer.MAX_VALUE will become negative, thus smaller than whatever
                for(int j = 0; j < len; j++) {
                    if(i >= coins[j] && dp[i - coins[j]] <= i - coins[j]) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    }
                }
            }
            res = dp[amount] == amount + 1 ? -1 : dp[amount];
        }
        return res;
    }
}