public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int h = matrix.length, w = matrix[0].length;
            int [][] dp = new int[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    res = Math.max(res, dfs(dp, matrix, i, j));
                }
            }
        }
        return res;
    }
    
    int dfs(int [][] dp, int[][] matrix, int i, int j) {
        if(dp[i][j] == 0) {
            int [][] dir = {
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
            };
            dp[i][j] = 1;//NoteNote
            for(int k = 0; k < 4; k++) {
                int x = i + dir[k][0], y = dir[k][1] + j;
                if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dfs(dp,matrix,x,y));
                }
            }
        }
        return dp[i][j];
    }
}