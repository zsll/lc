public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int res = 0;
        if(grid != null && grid.length > 0 && grid[0].length > 0) {
            int h = grid.length, w = grid[0].length;
            int [] colKill = new int[w];
            for(int i = 0; i < h; i++) {
                int rowKill = 0;
                for(int j = 0; j < w; j++) {
                    if(grid[i][j] != 'W') {
                        if(j == 0 || grid[i][j - 1] == 'W') {
                            int k = j;
                            while(k < w && grid[i][k] != 'W') {
                                if(grid[i][k] == 'E') {
                                    rowKill++;
                                }
                                k++;
                            }
                        }
                        if(i == 0 || grid[i - 1][j] == 'W') {
                            int k = i;
                            while(k < h && grid[k][j] != 'W') {
                                if(grid[k][j] == 'E') {
                                    colKill[j]++;
                                }
                                k++;
                            }
                        }
                        if(grid[i][j] == '0') {
                            /**
                             * Submission Result: Wrong Answer More Details 

Input:
["E"]
Output:
2
Expected:
0*/
                            res = Math.max(res, rowKill + colKill[j]);
                        }
                    } else {
                        rowKill = 0;
                        colKill[j] = 0;
                    }
                }
            }
        }
        return res;
    }
}