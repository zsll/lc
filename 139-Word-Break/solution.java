public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean res = false;
    	if(null == s || 0 == s.length()) {
    		res = true;
    	} else if(dict.size() > 0) {
    		int l = s.length();
    		boolean [] dp = new boolean[l + 1];
    		dp[0] = true;
    		for(int i = 1; i <= l; i++) {
    			for(String d : dict) {
    				if(i >= d.length()) {
    					if(dp[i - d.length()] && 
    							d.equals(s.substring(i - d.length() , i ))) {
    						dp[i] = true;
    						break;
    					}
    				}
    			}
    		}
    		res = dp[l];
    	}
    	return res;
    }
}