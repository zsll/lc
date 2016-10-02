public class Solution {
    public boolean isMatch(String s, String p) {
        boolean res = true;
        if(s == null || p == null) {
            res = false;
        } else {
            int sLen = s.length(), pLen = p.length();
            boolean [][] dp = new boolean[sLen + 1][pLen + 1];
            dp[0][0] = true;
            for(int j = 1; j <= pLen; j++) {
                char pChar = p.charAt(j - 1);
                if(pChar != '*') {
                    for(int i = 1; i <= sLen; i++) {
                        char sChar = s.charAt(i - 1);
                        if(sChar == pChar || pChar == '?') {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                } else {
                    dp[0][j] = dp[0][j - 1];
                    int k = 0;
                    while(k <= sLen && !dp[k][j - 1]) {
                        k++;
                    }
                    while(k <= sLen) {
                        dp[k][j] = true;
                        k++;
                    }
                }
            }
            res = dp[sLen][pLen];
        }
        return res;
    }
}