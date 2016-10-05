public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0 || A[0].length == 0 || B[0].length == 0) {
            return null;
        }
        int h = A.length, w = B[0].length;
        int [][] res = new int[h][w];
        
        TreeMap<Integer, TreeMap<Integer, Integer>> a = getHash(A);
        TreeMap<Integer, TreeMap<Integer, Integer>> b = getHash(B);
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(a.containsKey(i)) {
                    for(int nonZeroCol : a.get(i).keySet()) {
                        if(b.containsKey(nonZeroCol) && b.get(nonZeroCol).containsKey(j)) {
                            res[i][j] += a.get(i).get(nonZeroCol)*b.get(nonZeroCol).get(j);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    TreeMap<Integer, TreeMap<Integer, Integer>> getHash(int [][] m) {
        TreeMap<Integer, TreeMap<Integer, Integer>> res = new TreeMap<Integer, TreeMap<Integer, Integer>>();
        int h = m.length, w = m[0].length;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(m[i][j] != 0) {
                    if(!res.containsKey(i)) {
                        res.put(i, new TreeMap<Integer, Integer>());
                    }
                    res.get(i).put(j, m[i][j]);
                }
            }
        }
        return res;
    }
}