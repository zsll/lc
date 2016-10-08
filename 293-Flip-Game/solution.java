public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s != null && s.length() > 1) {
            for(int i = 0; i < s.length() - 1; i++) {
                
            StringBuffer sb = new StringBuffer(s);
                if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                    sb.setCharAt(i, '-');
                    sb.setCharAt(i + 1, '-');
                    res.add(new String(sb));
                }
            }
        }
        return res;
    }
}