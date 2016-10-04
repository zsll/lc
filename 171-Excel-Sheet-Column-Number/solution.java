public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        if(s != null && s.length() > 0) {
            for(char c : s.toCharArray()) {
                res *= 26;
                res += (c - 'A' + 1);
            }
        }
        return res;
    }
}