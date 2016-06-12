public class Solution {
    public int coinChange(int[] coins, int amount) {
        int r = amount == 0 ? 0 :-1;
        if(coins.length > 0 && amount > 0) {
        	int [] dp = new int[amount + 1];
//NoteNote: initialization
        	for(int i = 1; i < amount + 1; i++) {
        		dp[i] = Integer.MAX_VALUE;	//some impossible value, meaning making i amount is not possible
        	}
        	for(int i = 1; i < amount + 1; i++) {
        		for(int j = 0; j < coins.length; j++) {
	        		if(i >= coins[j] && dp[i - coins[j]] <= i - coins[j]) {
	        			dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
	        		}
        		}
        	}
        	if(dp[amount] <= amount) {
        		r = dp[amount];
        	}
        }
        return r;
    }
}