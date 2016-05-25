public class Solution {
    public int uniquePaths(int m, int n) {
     int res = 0;
    	if( m > 0 && n > 0) {
        
	        int[][] dp = new int[2][n + 1];
	        
	        // 1st row only 1 path
	        for (int i=1; i<=n; i++)
	            dp[1][i] = 1;
	        
	        // 1st column only 1 path
	        for (int i=2; i<=m; i++)
	            dp[i%2][1] = 1;
	        
	        // for each body node, number of path = paths from top + paths from left
	        for (int i=2; i<=m; i++){
	            for (int j=2; j<=n; j++){
	                dp[i%2][j] = dp[(i-1)%2][j] + dp[i%2][(j-1)];
	            }
	        }
	        res = dp[m%2][n];
    	}
        return res;   
    }
}