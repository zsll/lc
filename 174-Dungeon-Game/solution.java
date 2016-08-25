public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int h = dungeon.length, w = dungeon[0].length;
        int [][] dp = new int[h][w];
        dp[h - 1][w - 1] = minHP(1 - dungeon[h - 1][w - 1]);
        for(int j = w - 2; j >= 0; j--) {
            dp[h - 1][j] = minHP(dp[h - 1][j + 1] - dungeon[h - 1][j]);
        }
        for(int i = h - 2; i >= 0; i--) {
            dp[i][w - 1] = minHP(dp[i + 1][w - 1] - dungeon[i][w - 1]);
            for(int j = w - 2; j >= 0; j--) {
                dp[i][j] = Math.min(minHP(dp[i + 1][j] - dungeon[i][j]), minHP(dp[i][j + 1] - dungeon[i][j]));
            }
        }
        return dp[0][0];
    }
    
    int minHP(int val) {
        return Math.max(val, 1);
    }
}