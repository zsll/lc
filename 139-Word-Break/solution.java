public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean res = false;
        if(wordDict != null && wordDict.size() > 0) {
            int len = s.length();
            boolean [] dp = new boolean[len + 1];
            dp[0] = true;
            for(int i = 1; i < len + 1; i++) {
                for(String s1 : wordDict) {
                    if(i >= s1.length() && dp[i - s1.length()] && s.substring(i - s1.length(), i).equals(s1)) {
                            dp[i] = true;
                        break;
                    }
                }
            }
            res = dp[len];
        }
        
        return res;
    }
}