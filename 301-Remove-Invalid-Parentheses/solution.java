public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        int [] maxLen = {0};
        dfs(s, 0, 0, 0, sb, res, maxLen);
        return res;
    }
    
    void dfs(String s, int i, int usedLeft, int usedRight, StringBuffer sb, List<String> res, int [] maxLen) {
        if(i == s.length() && usedLeft == usedRight && (maxLen[0] == 0 || sb.length() == maxLen[0])
            && res.indexOf(new String(sb)) == -1
            /**
             * Input:
"()())()"
Output:
["()()()","()()()","(())()"]
Expected:
["(())()","()()()"]
*/
        ) {
            res.add(new String(sb));
            maxLen[0] = sb.length();
        } else if (i < s.length()) {    //NoteNote this if
            char c = s.charAt(i);
            if(c == '(') {
                sb.append(c);
                dfs(s, i + 1, usedLeft + 1, usedRight, sb, res, maxLen);
                sb.deleteCharAt(sb.length() - 1);
                dfs(s, i + 1, usedLeft, usedRight, sb, res, maxLen);
            } else if (c == ')') {
                if(usedRight < usedLeft) {
                    sb.append(c);
                    dfs(s, i + 1, usedLeft, usedRight + 1, sb, res, maxLen);
                    sb.deleteCharAt(sb.length() - 1);
                }
                dfs(s, i + 1, usedLeft, usedRight, sb, res, maxLen);
            } else {
                sb.append(c);
                dfs(s, i + 1, usedLeft, usedRight, sb, res, maxLen);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}