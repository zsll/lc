public class Solution {
    public int numDecodings(String s) {
        int res = 0;
        if(s != null && s.length() > 0) {
            int [] dp = new int[3];
            dp[0] = 1;
            char [] a = s.toCharArray();
            for(int i = 1; i <= s.length();i++) {
                dp[i%3] = 0;
                if(dp[(i - 1)%3] == 0 && dp[(i - 2)%3] == 0) {
                    break;
                }
                if(canUse1(a, i - 1)) {
                    dp[i%3] += dp[(i - 1)%3];
                }
                
                if(i > 1 && canUse2(a, i - 1)) {
                    dp[i%3] += dp[(i - 2)%3];
                }
            }
            res = dp[s.length()%3];
        }
        return res;
    }
    
    boolean canUse1(char [] a, int i) {
        return a[i] >= '1' && a[i] <= '9';
    }
    
    boolean canUse2(char [] a, int i) {
        int sum = (a[i - 1] - '0')*10 + a[i] - '0';
        return canUse1(a, i - 1) && sum >= 1 && sum <= 26;
    }
}