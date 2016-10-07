public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if(positions != null && positions.length > 0 && positions[0].length == 2) {
            boolean [][] v = new boolean[m][n];
            int island = 0;
            UF uf = new UF(m*n);
            for(int [] p : positions) {
                int i = p[0], j = p[1];
                if(i >= 0 && i < m && j >=0 && j < n && !v[i][j] ) {
                    v[i][j] = true;
                    island++;
                    int [][] dir = {
                        {0, 1},
                        {1, 0},
                        {-1, 0},
                        {0, -1}
                    };
                    for(int k = 0; k < 4; k++) {
                        int x = i + dir[k][0], y = j + dir[k][1];
                        if(x >= 0 && x < m && y >= 0 && y < n && v[x][y]) {
                            if(uf.union(i*n + j, x*n + y)) {
                                island--;
                            }
                        }
                    }
                }
                res.add(island);
            }
        }
        return res;
    }
    
    class UF {
        int [] a;
        public UF(int n) {
            a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = i;
            }
        }
        
        public int findCompressed(int i) {
            int p = a[i];
            while(p != a[p]) {
                p = a[p];
            }
            while(i != p) {
                int n = a[i];
                a[i] = p;
                i = n;
            }
            return p;
        }
        
        public boolean union(int i, int j) {
            int ip = findCompressed(i), jp = findCompressed(j);
            if(ip == jp) {
                return false;
            } else {
                a[ip] = jp;
                return true;
            }
        }
    }
}