public class Solution {
    public int uniquePaths(int m, int n) {
        int res = 0;
    	if(m > 0 && n > 0) {
    	    int [][] dp = new int[2][n];
    	    for(int i = 0; i < n; i++) {
    	        dp[0][i] = 1;
    	    }
    	    for(int i = 1; i < m; i++) {
    	        dp[i%2][0] = 1;
    	        for(int j = 1; j < n; j++) {
    	            dp[i%2][j] = dp[(i - 1)%2][j] + dp[i%2][j - 1];
    	        }
    	    }
    	    res = dp[(m - 1)%2][n - 1];
    	}
        return res;   
    }
}