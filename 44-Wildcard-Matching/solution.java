public class Solution {
    public boolean isMatch(String s, String p) {
                if (s == null){
            return p == null;
        }
        if (p == null){
            return s == null;
        }

        int m = p.length();
        int n = s.length();

        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;
        for (int i = 1; i <= m; i++){
            if (p.charAt(i-1) == '*'){
                int j = n + 1;
                for (int k = 0; k <= n; k++){
                    if (dp[i-1][k]){
                        j = k;
                        break;
                    }
                }
                for ( ; j <= n ; j++){
                    dp[i][j] = true;
                }
            }
            else{
                for (int j = 1; j <= n; j++){
                    if (dp[i-1][j-1] && (p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?')){
                        dp[i][j] = true;
                    }
                }
            }

            dp[i][0] = dp[i-1][0] && (p.charAt(i-1) == '*');
        }

        return dp[m][n];
    }
}