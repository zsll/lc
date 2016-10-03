public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms != null && rooms.length > 0 && rooms[0].length > 0) {
            int h = rooms.length, w = rooms[0].length;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    
                    if(rooms[i][j] == 0) {
                        bfs(rooms, i, j);
                    }
                }
            }
        }
    }
    
    void bfs(int[][] rooms, int i, int j) {
            Queue<Integer> xq = new LinkedList<Integer>();
	            Queue<Integer> yq = new LinkedList<Integer>();
	            Queue<Integer> preDist = new LinkedList<Integer>();	//You may use level by level traversal, or q queue
	            xq.offer(i);
	            yq.offer(j);
	            preDist.offer(0);
	            int h = rooms.length, w = rooms[0].length;
	            boolean [][] v = new boolean[h][w];
	            v[i][j] = true;
	            while(!xq.isEmpty()) {
	                int curX = xq.poll(), curY = yq.poll();
	                int dist = preDist.poll();
	                rooms[curX][curY] = Math.min(rooms[curX][curY], dist);
	                    
	                int [][] dir = {
	                    {0, 1},
	                    {1, 0},
	                    {0, -1},
	                    {-1, 0}
	                };
	                for(int k = 0; k < 4; k++) {
	                    int x = curX + dir[k][0], y = curY + dir[k][1];
	                    if(x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length && !v[x][y] && rooms[x][y] >= 0) {
	                        xq.offer(x);
	                        yq.offer(y);
	                        preDist.offer(dist + 1);
	                        v[x][y] = true;
	                    }
	                }
	                dist++;
            }
        
    }
}