public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s != null && s.length() > 0 && wordDict != null && wordDict.size() > 0) {
            int len = s.length();
            boolean [] t = new boolean[len + 1];
            t[0] = true;
            boolean [][] d = new boolean[len][len];
            for(int i = 1; i <= len; i++) {
                for(String w : wordDict) {
                    if(i >= w.length()) {
                        if(t[i - w.length()] && s.substring(i - w.length(), i).equals(w) ) {
                            t[i] = true;    //NoteNote we can't break right away
                            d[i - w.length()][i - 1] = true;
                        }
                    }
                }
            }
            List<String> cur = new ArrayList<String>();
            dfs(s, d, 0, res, cur);
        }
        return res;
    }
    
    void dfs(String s, boolean [][] d, int i, List<String> res, List<String> cur) {
        if(i == s.length() ) {
            StringBuffer sb = new StringBuffer();
            for(String c1 : cur) {
                sb.append(c1);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        } else {
            for(int j = 0; j < s.length(); j++) {
                if(d[i][j]) {
                    cur.add(s.substring(i, j + 1));
                    dfs(s, d, j + 1, res, cur);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}