public class Solution {
    public int numIslands(char[][] grid) {
        int h = grid.length, r = 0;
        if(h > 0) {
        	int w = grid[0].length;
        	if(w > 0) {
        		for(int i = 0; i < w*h; i++) {
        			int row = i/w, col = i%w;
        			if(grid[row][col] == '1') {
        				BFSTraversal(grid, row, col);
        				r++;
        			}
        		}
        	}
        }
        return r;
    }
    
    private void BFSTraversal(char[][] grid, int r, int c) {
    	int h = grid.length, w = grid[0].length;
    	List<Integer> q = new LinkedList<Integer>();
    	q.add(r); q.add(c);
    	while(q.size() > 0) {
    		int cr = q.remove(0), cc = q.remove(0);
    		if(cr > 0 && grid[cr - 1][cc] == '1') {
    			q.add(cr - 1);q.add(cc);
    			grid[cr - 1][cc] = '0';
    		}
    		if(cr < h - 1 && grid[cr + 1][cc] == '1') {
    			q.add(cr + 1);q.add(cc);
    			grid[cr + 1][cc] = '0';
    		}
    		if(cc > 0 && grid[cr][cc - 1] == '1') {
    			q.add(cr);q.add(cc - 1);
    			grid[cr][cc - 1] = '0';
    		}
    		if(cc < w - 1 && grid[cr][cc + 1] == '1') {
    			q.add(cr);q.add(cc + 1);
    			grid[cr][cc + 1] = '0';
    		}
    	}
    	
    }
}