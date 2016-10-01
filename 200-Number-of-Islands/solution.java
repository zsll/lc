public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid != null && grid.length > 0 && grid[0].length > 0) {
            int h = grid.length, w = grid[0].length;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(grid[i][j] == '1') {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
        }
        return res;
    }
    
    void dfs(char [][] grid, int i, int j) {
        grid[i][j] = '0';
        int h = grid.length, w = grid[0].length;
        int [][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };
        for(int k = 0; k < 4; k++) {
            int x = i + dir[k][0], y = j + dir[k][1];
            if(x >= 0 && x < h && y >= 0 && y < w && grid[x][y] == '1') {
                dfs(grid, x, y);
            }
        }
    }
}