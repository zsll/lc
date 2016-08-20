public class Solution {
    public boolean isMatch(String s, String p) {
        boolean res = true;
    	if(s == null || p == null) {
    		res = true;
    	} else {
    		int sLen = s.length(), pLen = p.length();
    		boolean [][] dp = new boolean[sLen + 1][2];
    		dp[0][0] = true;
    		for(int j = 1; j <= pLen; j++) {
    			char pChar = p.charAt(j - 1);
    			if(pChar != '*') {
    				for(int i = 0; i <= sLen; i++) {
    					if(i == 0) {
    						dp[i][j%2] = false;
    						continue;
    					} else {
	    					dp[i][j%2] = false;
	    					char sChar = s.charAt(i - 1);
	    					if(sChar == pChar || pChar == '?') {
	        					dp[i][j%2] = dp[(i - 1)][(j - 1)%2];
	        				}
    					}
    				}
    			} else {
    				int k = 0;
    				for( k = 0; k <= sLen; k++) {
    					if(dp[k][(j - 1)%2]) {
    						break;
    					} else {
    						dp[k][j%2] = false;
    					}
    				}
    				while(k <= sLen) {
    					dp[k][j%2] = true;
    					k++;
    				}
    			}
    		}
    		res = dp[sLen][pLen%2];
    	}
    	return res;
    }
}