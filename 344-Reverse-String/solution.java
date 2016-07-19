public class Solution {
    public String reverseString(String s) {
        String res = s;
        if(s != null && s.length() > 1) {
            StringBuffer sb = new StringBuffer(s);
            int i = 0, j = sb.length() - 1;
            while (i < j) {
                char c = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, c);
            }
            res = sb.toString();
        }
        return res;
    }
}