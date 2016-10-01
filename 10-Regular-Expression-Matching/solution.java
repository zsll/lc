public class Solution {
    public boolean isMatch(String s, String p) {
        int h = s.length(), w = p.length();
        boolean [][] dp = new boolean[2][w + 1];
        for(int i = 0; i <= h; i++) {
            for(int j = 0; j <= w; j++) {
                dp[i%2][j] = false;
                if(j == 0 && i == 0) {
                    dp[i%2][j] = true;
                } else if (i == 0) {
                    if(j >= 2 && dp[i][j - 2] && p.charAt(j - 1) == '*' && p.charAt(j - 2) != '*') {
                        dp[i%2][j] = true;
                    }
                } else if (j > 0 ) {    //Note Note
                    if(p.charAt(j - 1) != '*') {
                        if(s.charAt(i - 1) == p.charAt(j - 1) ||  p.charAt(j - 1) == '.') {
                            dp[i%2][j] = dp[(i - 1)%2][j - 1];
                        }
                    } else {
                        if(j >= 2) {    //NoteNote, else must be false
                            if(p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.' ) {
                                dp[i%2][j] = dp[i%2][j - 2] || dp[(i - 1)%2][j];
                            } else {
                                dp[i%2][j] = dp[i%2][j - 2];
                            }
                        }
                    }
                }
            }
        }
        return dp[h%2][w];
    }
}