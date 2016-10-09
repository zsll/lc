public class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        if(n > 0) {
            int [][] m = buildRelationMatrix(n, edges);
            HashSet<Integer> v = new HashSet<Integer>();
            for(int i = 0; i < n; i++) {
                if(!v.contains(i)) {
                    bfs(v, m, i);
                    res++;
                }
            }
        }
        return res;
    }
    
    int [][] buildRelationMatrix(int n, int[][] edges) {
        int [][] res = new int[n][n];
        for(int [] e :edges) {
            res[e[0]][e[1]] = 1;
        }
        return res;
    }
    
    void bfs(HashSet<Integer> v, int[][] edges, int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        v.add(start);
        q.offer(start);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i < edges.length; i++) {
                /**
                 * 注意无向图只用一条边表示
                 * Submission Result: Wrong Answer More Details 

Input:
5
[[0,1],[1,2],[3,4]]
Output:
5
Expected:
2
                 */ 
                if((edges[cur][i] == 1 || edges[i][cur] == 1) && !q.contains(i)) {
                    q.offer(i);
                    v.add(i);
                }
            }
        }
    }
}