public class Solution {
    /**
     *  Use dp[i][j] denotes the min amount of money we need to pay by guessing from i to j, j >= i
     *  dp[i][i] equals 0
     *  dp[i][i + 1] equals i
     *  dp[i][j] equals Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j])), k > i && k < j
     *  result is dp 1 n
     */
    public int getMoneyAmount(int n) {
        int res = 0;
        if(n > 1) {
            int [][] dp = new int[n + 1][n + 1];
            for(int i = 1; i <= n; i++) {
                dp[i][i] = 0;
                if(i < n) { //NoteNote
                    dp[i][i + 1] = i;
                }
            }
            for(int len = 3; len <= n; len++) {
                for(int start = 1; start <= n - len + 1; start++) {
                    int end = start + len - 1;
                    dp[start][end] = Integer.MAX_VALUE;
                    for(int k = start + 1; k < end; k++) {
                        dp[start][end] = Math.min(dp[start][end], k + Math.max(dp[start][k - 1], dp[k + 1][end]));
                    }
                }
            }
            res = dp[1][n];
        }
        return res;
    }
}