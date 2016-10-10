public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        if(matrix != null && matrix.length > 0) {
            int h = matrix.length, w = matrix[0].length;
            HashSet<Integer> v1 = new HashSet<Integer>();
            Queue<Integer> q1 = new LinkedList<Integer>();
            HashSet<Integer> v2 = new HashSet<Integer>();
            Queue<Integer> q2 = new LinkedList<Integer>();
            for(int i = 0; i < h; i++) {
                q1.offer(i*w);
                v1.add(i*w);
                q2.offer(i*w + w - 1);
                v2.add(i*w + w - 1);
            }
            for(int i = 1; i < w - 1; i++) {
                q1.offer(i);
                v1.add(i);
                q2.offer((h - 1)*w + i);
                v2.add((h - 1)*w + i);
            }
            q1.offer(w - 1);    //These two points exist in both
            q2.offer((h- 1) * w);
            v1.add(w - 1);    //These two points exist in both
            v2.add((h- 1) * w);
            
            
            bfs(q1, v1, matrix);
            bfs(q2, v2, matrix);
            
            for(int i : v1) {
                if(v2.contains(i)) {
                    int row = i / w, col = i % w;
                    int [] l = {row, col};
            res.add(l);
                }
            }
        }
        return res;
    }
    
    void bfs(Queue<Integer> q, HashSet<Integer> v, int[][] matrix) {
        int [][] dir = {
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
            };
            int h = matrix.length, w = matrix[0].length;
        while(!q.isEmpty()) {
            
                int cur = q.poll();
                int i = cur/w, j = cur%w;
                for( int k = 0; k < 4; k++) {
                    int x = i + dir[k][0], y = j + dir[k][1];
                    if(x >= 0 && x < h && y >= 0 && y < w && !v.contains(x*w + y) && matrix[x][y] >= matrix[i][j]) {
                        q.offer(x*w + y);
                        v.add(x*w + y);
                    }
                }
        }
    }
}