public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int h = dungeon.length, w = dungeon[0].length;
        int [][] dp = new int[2][w];
        dp[(h - 1)%2][w - 1] = minHP(1 - dungeon[h - 1][w - 1]);
        for(int j = w - 2; j >= 0; j--) {
            dp[(h - 1)%2][j] = minHP(dp[(h - 1)%2][j + 1] - dungeon[h - 1][j]);
        }
        for(int i = h - 2; i >= 0; i--) {
            dp[i%2][w - 1] = minHP(dp[(i + 1)%2][w - 1] - dungeon[i][w - 1]);
            for(int j = w - 2; j >= 0; j--) {
                dp[i%2][j] = Math.min(minHP(dp[(i + 1)%2][j] - dungeon[i][j]), minHP(dp[i%2][j + 1] - dungeon[i][j]));
            }
        }
        return dp[0][0];
    }
    
    int minHP(int val) {
        return Math.max(val, 1);
    }
}