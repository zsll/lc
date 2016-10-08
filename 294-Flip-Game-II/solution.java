public class Solution {
    public boolean canWin(String s) {
        boolean res = false;
        if(s != null && s.length() > 1) {
            StringBuffer sb = new StringBuffer(s);
            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                    sb.setCharAt(i - 1, '-');
                    sb.setCharAt(i, '-');
                    if(!canWin(sb.toString())) {
                        res = true;
                        break;
                    }
                    sb.setCharAt(i - 1, '+');
                    sb.setCharAt(i, '+');
                }
            }
        }
        return res;
    }
}