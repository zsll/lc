public class Solution {
    public int numWays(int n, int k) {
        int res = 0;
        if(n > 0 && k > 0) {
            int [] s = new int[n + 1];
            int [] d = new int[n + 1];
            s[0] = 0; s[1] = 0;//NoteNote the initialization
            d[1] = 0; d[1] = k;//NoteNote the initialization
            for(int i = 2; i <= n; i++) {
                s[i] = d[i - 1];
                d[i] = (s[i - 1] + d[i - 1])*(k - 1);
            }
            res = s[n] + d[n];
        }
        return res;
    }
}