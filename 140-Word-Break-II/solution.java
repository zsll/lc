public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(wordDict != null && wordDict.size() > 0) {
            int len = s.length();
            boolean [] dp = new boolean[len + 1];
            boolean [][] t = new boolean[len][len]; //t i j means from i to j is a word
            dp[0] = true;
            for(int i = 1; i < len + 1; i++) {
                for(String s1 : wordDict) {
                    if(i >= s1.length() && dp[i - s1.length()]) {	//NoteNote, substring using i, not i + 1
                        if(s.substring(i - s1.length(), i).equals(s1)) {
                            dp[i] = true;
                            t[i - s1.length()][i - 1] = true;
                        }
                    }
                }
            }
            if(dp[len]) {
                StringBuffer sb = new StringBuffer();
                dfs(t, sb, res, s, 0);
            }
        }
        return res;
    }
    
    void dfs(boolean [][] t, StringBuffer sb, List<String> res, String s, int pos) {
        if(pos == s.length()) {
            res.add(new String(sb));
        } else {
            for(int i = pos; i < s.length(); i++) {
                if(t[pos][i]) {
                    String s1 = s.substring(pos, i + 1);
                    int originalLen = sb.length();
                    sb.append(pos == 0 ? s1 : " " + s1);
                    dfs(t, sb, res, s, i + 1);
                    sb.setLength(originalLen);
                }
            }
        }
    }
}