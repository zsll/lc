public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int res = 0;
        if(grid != null && grid.length > 0 && grid[0].length > 0) {
            int h = grid.length, w = grid[0].length, rowKill = 0;
            int [] colKill = new int[w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(j == 0 || grid[i][j - 1] == 'W') {
                        rowKill = 0;
                        int k = j;
                        while(k < w && grid[i][k] != 'W') {
                            if(grid[i][k] == 'E') {
                                rowKill++;
                            }
                            k++;
                        }
                    }
                    if(i == 0 || grid[i - 1][j] == 'W') {
                        colKill[j] = 0;
                        int k = i;
                        while(k < h && grid[k][j] != 'W') {
                            if(grid[k][j] == 'E') {
                                colKill[j]++;
                            }
                            k++;
                        }
                    }
                    if(grid[i][j] == '0') {
                        res = Math.max(res, rowKill + colKill[j]);
                    }
                }
            }
        }
        return res;
    }
}