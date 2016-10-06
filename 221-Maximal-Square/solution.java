public class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int h = matrix.length, w = matrix[0].length;
            int [][] dp = new int[2][w + 1];
            for(int i = 1; i <= h; i++) {
                for(int j = 1; j <= w; j++) {
                    dp[i%2][j] = 0;
                    if(matrix[i - 1][j - 1] == '1') {
                        dp[i%2][j] = Math.min(dp[(i - 1)%2][j - 1], Math.min(dp[(i - 1)%2][j], dp[i%2][j - 1])) + 1;
                        res = Math.max(res, dp[i%2][j]*dp[i%2][j]);
                    }
                }
            }
        }
        return res;
    }
}