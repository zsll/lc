public class Solution {
public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        restoreIpAddressesHelper(s, 0, 0, new StringBuffer(), res);
        return res;
    }
    
    //pos is length at s, stage is 1 - 4, existing part in sb
    void restoreIpAddressesHelper(String s, int pos, int stage, StringBuffer sb, List<String> res) {
        if(pos == s.length() && stage == 4) {
            res.add(new String(sb));
        } else if (pos < s.length() && stage < 4) {
            for(int end = pos + 1; end <= pos + 3; end++) {
                if(end <= s.length()) {
                    String subS = s.substring(pos, end);
                    if(subS.charAt(0) == '0' && subS.length() > 1) {
                        /**
                         * Submission Result: Wrong Answer More Details 

Input:
"0000"
Output:
[]
Expected:
["0.0.0.0"]
*/
                        break;
                    }
                    int value = Integer.parseInt(subS);
                    
                    if(value >= 0 && value <= 255) {  //To prevent cases like 025, 00, 
                        int len = sb.length();
                        if(stage > 0) {
                            sb.append(".");
                        }
                        sb.append(subS);
                        restoreIpAddressesHelper(s, end, stage + 1, sb, res);
                        sb.setLength(len);  //NoteNote, set length should be pos plus stage, needs to set to original length
                    }
                }
            }
        }
    }
}