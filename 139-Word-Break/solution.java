public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean res = false;
        if(s != null && wordDict != null) {
            int len = s.length();
            boolean [] dp = new boolean[len + 1];
            dp[0] = true;
            for(int i = 1; i <= len; i++) {
                for(String s1 : wordDict) {
                    if(i >= s1.length() && dp[i - s1.length()] && s.substring(i - s1.length(), i).equals(s1)) {
                        dp[i] = true;
                    }
                }
            }
            res = dp[len];
        }
        return res;
    }
}