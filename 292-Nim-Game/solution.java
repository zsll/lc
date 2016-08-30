public class Solution {
    public boolean canWinNim(int n) {
        boolean res = true; //n < 4
        if(n >= 4) {
            boolean [] dp = new boolean[4];
            dp[0] = true;
            dp[1] = true;
            dp[2] = true;
            dp[3] = true;
            for(int i = 4; i <= n; i++) {
                dp[i%4] = false;
                if(dp[(i - 1)%4] == false || dp[(i - 2)%4] == false || dp[(i - 3)%4] == false) {
                    dp[i%4] = true;
                }
            }
            res = dp[n%4];
        }
        return res;
    }
}