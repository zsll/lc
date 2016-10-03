public class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF u = new UF(n);
        for(int [] edge : edges) {
            int a = edge[0], b= edge[1];
            if(u.union(a,b)) {//has loop
                return false;
            }
        }
        return u.size == 1;
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