public class Solution {
    //f i j is the cost to guess from i to j
    //when j - i = 0, is 0
    //when j - i = 1, is i
    //else k scan from i to j, if I guess k, 
    //if correct, it's 0, If not max would be Max of f[i, k - 1] ,  f[k + 1, j] + k
    public int getMoneyAmount(int n) {
        int res = 0;
        if(n > 1) {
            int [][] dp = new int[n + 1][n + 1];
            for(int i = 1; i <= n; i++) {
                dp[i][i] = 0;
                if(i < n) {
                    dp[i][i + 1] = i;
                }
            }
            for(int diff = 2; diff < n; diff++) {
                for(int row = 1; row + diff <= n; row++) {
                    int col = diff + row;
                    dp[row][col] = Integer.MAX_VALUE;
                    for(int k = row; k <= col; k++) {
                        if(k == row) {
                            dp[row][col] = Math.min(dp[row][col], k + dp[k + 1][col]);
                        } else if (k == col) {
                            dp[row][col] = Math.min(dp[row][col], k + dp[row][k - 1]);
                        } else {
                            dp[row][col] = Math.min(dp[row][col], Math.max(k + dp[row][k - 1], k + dp[k + 1][col]));
                        }
                    }
                }
            }
            res = dp[1][n];
        }
        return res;
    }
}