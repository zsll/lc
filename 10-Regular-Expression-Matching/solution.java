public class Solution {
    public boolean isMatch(String s, String p) {
        boolean res = false;
        if(s != null && p != null) {
            int h = s.length(), w = p.length();
            boolean [][] dp = new boolean[2][w + 1];
            for(int i = 0; i <= h; i++) {
                for(int j = 0; j <= w; j++) {
                    dp[i%2][j] = false;
                    if(i == 0 && j == 0) {
                        dp[i%2][j] = true;
                    } else if(i == 0) {
                        dp[i%2][j] = (j > 1 && p.charAt(j - 1) == '*' && p.charAt(j - 2) != '*' && dp[i%2][j - 2]);
                    } else if(j == 0) {
                        dp[i%2][j] = false;
                    } else {
                        if(p.charAt(j - 1) != '*') {
                            dp[i%2][j] = (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) && dp[(i - 1)%2][j - 1];
                        } else {
                            if(j >=2 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.' ) ) {
                                dp[i%2][j] = dp[i%2][j - 2] | dp[(i - 1)%2][j];
                            } else if(j >= 2) {
                                dp[i%2][j] = dp[i%2][j - 2];
                            }
                        }
                    }
                }
            }
            res = dp[h%2][w];
        }
        return res;
    }
}