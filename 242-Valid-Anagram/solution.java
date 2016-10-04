public class Solution {
    public boolean isAnagram(String s, String t) {
        boolean res = false;
        if(s != null && t != null && s.length() == t.length()) {
            int [] h = new int[255];
            for(int i = 0; i < s.length(); i++) {
                h[s.charAt(i)]++;
                h[t.charAt(i)]--;
            }
            res = true;
            for(int i = 0; i < s.length(); i++) {
                if(h[s.charAt(i)] != 0) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
}