public class Solution {
    public int shortestDistance(int[][] grid) {
        int res = -1;
        if(grid != null && grid.length > 0 && grid[0].length > 0) {
            int h = grid.length, w = grid[0].length;
            int [][] v = new int[h][w];
            int [][] dist = new int[h][w];
            int index = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(grid[i][j] == 1) {
                        bfs(grid, v, dist, i, j, index++);
                    }
                }
            }
            res = Integer.MAX_VALUE;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(grid[i][j] == 0 && v[i][j] == index) {
                        res = Math.min(res, dist[i][j]);
                    }
                }
            }
            if(res == Integer.MAX_VALUE) {
                res = -1;
            }
        }
        return res;
    }
    
    void bfs(int [][] grid, int [][] v, int [][] dist, int i, int j, int index) {
        
            Queue<Integer> xQ = new LinkedList<Integer>();
            Queue<Integer> yQ = new LinkedList<Integer>();
            Queue<Integer> dQ = new LinkedList<Integer>();
            xQ.offer(i);
            yQ.offer(j);
            dQ.offer(0);
            while(!xQ.isEmpty()) {
                int x = xQ.poll(), y = yQ.poll(), d = dQ.poll();
                int [][] dir = {
                    {0, 1},
                    {1, 0},
                    {-1, 0},
                    {0, -1}
                };
                for(int k = 0 ; k < 4; k++) {
                    int x1 = x + dir[k][0], y1 = y + dir[k][1];
                    if(x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] == 0 && v[x1][y1] == index) {
                        xQ.offer(x1);
                        yQ.offer(y1);
                        dQ.offer(d + 1);
                        v[x1][y1]++;
                        dist[x1][y1] += (d + 1);
                    }
                }
            }
        
    }
}