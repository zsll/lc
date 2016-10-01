public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits != null && digits.length() > 0) {
            StringBuffer sb = new StringBuffer();
            dfs(digits, sb, res, 0);
        }
        return res;
    }
    
    void dfs(String digits, StringBuffer sb, List<String> res, int pos) {
        if(pos == digits.length()) {
            res.add(sb.toString());
        } else {
            char [][] key = {
                { ' '},//key 0
                { '?'},//key 1
                { 'a','b','c'},//key 2
                { 'd','e','f'},//key 3
                { 'g','h','i'},//key 4
                { 'j','k','l'},//key 5
                { 'm','n','o'},//key 6
                { 'p','q','r','s'},//key 7
                { 't','u','v'},//key 8
                { 'w','x','y','z'}//key 9
            };
            int d = digits.charAt(pos) - '0';
            for(char c : key[d]) {
                sb.append(c);
                dfs(digits, sb, res, pos + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}