public class Solution {
    public String removeDuplicateLetters(String s) {
        String res = s;
        if(s != null && s.length() > 1) {
            int [] m = new int[256];
            for(int i = 0; i < s.length(); i++) {
                m[s.charAt(i)]++;
            }
            int pos = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) < s.charAt(pos)) {
                    pos = i;
                }
                if(m[s.charAt(i)] == 1) {
                    break;
                } else {
                    m[s.charAt(i)]--;
                }
            }
            res = s.charAt(pos) + removeDuplicateLetters(s.substring(pos).replace("" + s.charAt(pos), ""));
        }
        return res;
    }
}