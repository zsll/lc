public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        dfs(res, sb, n, n);
        return res;
    }
    
    void dfs(List<String> res, StringBuffer sb, int left, int right) {
        if(left == 0 && right == 0) {
            res.add(new String(sb));
        } else {
            if(left - 1 >= 0) {
                sb.append('(');
                dfs(res, sb, left - 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            if(right - 1 >= left) {
                sb.append(')');
                dfs(res, sb, left, right - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}