public class Solution {
    public int numSquares(int n) {
        int res = 0;
        if(n > 0) {
            int [] t = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                t[i] = i;   //max possible
                int j = 1;
                while(j*j <= i) {
                    t[i] = Math.min(t[i], 1 + t[i - j*j]);
                }
            }
            res = t[n];
        }
        return res;
    }
}