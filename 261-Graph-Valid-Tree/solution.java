public class Solution {
    public boolean validTree(int n, int[][] edges) {/*
        UF u = new UF(n);
        for(int [] edge : edges) {
            int a = edge[0], b= edge[1];
            if(u.union(a,b)) {//has loop
                return false;
            }
        }
        return u.size == 1;
        NoteNote: only bfs is not sufficient, you have to make sure you visited everyone!
        */
        HashMap<Integer, Integer> v = new HashMap<Integer, Integer>();
        v.put(0, 1);    //1 is queued, 2 is visited
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        int [][] m = build( n,  edges);
        
        while(!q.isEmpty()) {
            Integer cur = q.poll();
            for(int nei = 0; nei < n; nei++) {
                if(m[cur][nei] == 0) {
                    continue;
                }
                if(v.containsKey(nei) && v.get(nei) == 1) {
                    return false;
                }
                if(!v.containsKey(nei)) {
                    q.offer(nei);
                     v.put(nei, 1);
                }
            }
            v.put(cur, 2);
        }
        return v.size() == n;
    }
    
    int [][] build(int n, int[][] edges) {
        int [][] m = new int[n][n];
        for(int [] e : edges) {
            m[e[0]][e[1]] = 1;
            m[e[1]][e[0]] = 1;
        }
        return m;
    }
    
    class UF {
        int [] p = null;
        int size = 0;
        public UF(int n) {
            p = new int[n];
            for(int i = 0; i < n; i++) {
                p[i] = i;
            }
            size = n;
        }
        
        int findCompress(int i) {
            int pre = p[i];
            while(pre != p[pre]) {
                pre = p[pre];
            }
            int cur = i;
            while(cur != pre) {
                int n = p[cur];
                p[cur] = pre;
                cur = n;
            }
            return pre;
        }
        
        boolean union(int i, int j) {
            int a = findCompress(i), b = findCompress(j);
            if(a == b) {
                return true;    //has loop
            } else {
                p[a] = b;
                size--;
            }
            return false;
        }
    }
}