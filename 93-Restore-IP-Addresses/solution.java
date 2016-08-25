public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s != null && s.length() > 3) {
            dfs(s, 0, 0, new StringBuffer(), res);
        }
        return res;
    }
    
    void dfs(String s, int i, int stage, StringBuffer sb, List<String> res) {
        if(i == s.length() && stage == 4) {
            res.add(sb.toString());
        } else if(i < s.length() && stage < 4) {  //notenote
            for(int end = i + 1; end <= Math.min(i + 3, s.length()); end++) {
                int val = Integer.parseInt(s.substring(i, end));
                if(val >= 0 && val <= 255 && Integer.toString(val).equals(s.substring(i, end))) {//Output: ["0.1.0.010","0.1.00.10","0.1.001.0","0.10.0.10","0.10.01.0","0.100.1.0","01.0.0.10","01.0.01.0","01.00.1.0","010.0.1.0"]
                    int len = sb.length();
                    sb.append(s.substring(i, end));
                    if(stage != 3) {
                        sb.append('.');
                    }
                    dfs(s, end, stage + 1, sb, res);
                    sb.setLength(len);
                }
            }
        }
    }
}