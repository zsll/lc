public class Solution {
    public boolean isMatch(String s, String p) {
        boolean res = true;
    	if(s == null || p == null) {
    		res = true;
    	} else {
    		int sLen = s.length(), pLen = p.length();
    		boolean [][] dp = new boolean[2][pLen + 1];
    		dp[0][0] = true;
    		for(int i = 1; i <= pLen; i++) {
    			char pChar = p.charAt(i - 1);
    			if(pChar == '*') {
    				dp[0][i] = true; 
    			} else {
    				break;
    			}
    		}

    		
    		/*
    		for(int i = 1; i <= sLen; i++) {
    			for(int j = 1; j <= pLen; j++) {
    				char pChar = p.charAt(j - 1);
    				char sChar = s.charAt(i - 1);
    				dp[i][j] = false;
    				if(sChar == pChar || pChar == '?') {
    					dp[i][j] = dp[i - 1][j - 1];
    				} else if (pChar == '*') {
    					for(int k = 1; k <= i; k++) {
    						if(dp[k][j - 1]) {
    							dp[i][j] = true;
    							break;
    						} 
    					}
    				}
    			}
    		}
    		 * |
    		 * V
    		 * 
    		 * Better
    		 */
    		for(int j = 1; j <= pLen; j++) {
    			char pChar = p.charAt(j - 1);
    			if(pChar != '*') {
    				for(int i = 1; i <= sLen; i++) {
    					dp[i%2][j] = false;
    					char sChar = s.charAt(i - 1);
    					if(sChar == pChar || pChar == '?') {
        					dp[i%2][j] = dp[(i - 1)%2][j - 1];
        				}
    				}
    			} else {
    				int k = 1;
    				for( k = 1; k <= sLen; k++) {
    					if(dp[k%2][j - 1]) {
    						break;
    					} else {
    						dp[k%2][j] = false;
    					}
    				}
    				while(k <= sLen) {
    					dp[k%2][j] = true;
    				}
    			}
    		}
    		res = dp[sLen%2][pLen];
    	}
    	return res;
    }
}