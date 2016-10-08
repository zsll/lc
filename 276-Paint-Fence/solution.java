public class Solution {
    public int numWays(int n, int k) {
        int res = 0;
        if(n > 0 && k > 0) {
            int [] s = new int[2];
            int [] d = new int[2];
            s[0] = 0; s[1] = 0;//NoteNote the initialization
            d[1] = 0; d[1] = k;//NoteNote the initialization
            for(int i = 2; i <= n; i++) {
                s[i%2] = d[(i - 1)%2];
                d[i%2] = (s[(i - 1)%2] + d[(i - 1)%2])*(k - 1);
            }
            res = s[n%2] + d[n%2];
        }
        return res;
    }
}