public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
            int res = 1;
            if(obstacleGrid != null && obstacleGrid.length > 0 && obstacleGrid[0].length > 0) {
                int height = obstacleGrid.length, width = obstacleGrid[0].length;
                int [][] dp = new int[2][width];
                for(int i = 0; i < height; i++) {
                    for(int j = 0; j < width; j++) {
                        if(obstacleGrid[i][j] == 0) {
                            if(i == 0 && j == 0) {
                                dp[i%2][j] = 1;
                            } else if(j == 0) {
                                dp[i%2][j] = dp[(i - 1)%2][j];
                            } else if (i == 0) {
                                dp[i%2][j] = dp[i%2][j - 1];
                            } else {
                                dp[i%2][j] = dp[(i - 1)%2][j] + dp[i%2][j - 1];
                            }
                        } else {
                        	dp[i%2][j] = 0;	//NoteNote: for a rolling dp array, we need this step to MAKE SURE EVERY POSITION IS COVERED
                        }
                    }
                }
                res = dp[(height - 1)%2][width - 1];
            }
            return res;
    }
}