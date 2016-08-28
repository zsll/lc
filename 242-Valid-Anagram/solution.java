public class Solution {
    public boolean isAnagram(String s, String t) {
        boolean res = true;
        if(s == null && t != null || s != null && t == null) {
            res = false;
        } else if (s != null && t != null) {
            if(s.length() != t.length()) {
                res = false;
            } else {
                int [] sh = new int[256];
                int [] th = new int[256];
                for(int i = 0; i < s.length(); i++) {
                    sh[(int)s.charAt(i)]++;
                    th[(int)t.charAt(i)]++;
                }
                for(int i = 0; i < s.length(); i++) {
                    if(sh[(int)s.charAt(i)] != th[(int)s.charAt(i)]) {
                        res = false;
                    }
                }
            }
        }
        return res;
    }
}