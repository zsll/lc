public class Solution {
    public int strStr(String haystack, String needle) {
        int res = -1;
        if(needle.length() == 0) {
            res = 0;
        } else if (haystack.length() >= needle.length()) {
            for(int i = 0; i < haystack.length() && res == -1; i++) {
                int j = 0;
                for(; j < needle.length() && i + j < haystack.length(); j++) {
                    if(needle.charAt(j) != haystack.charAt(i + j)) {
                        break;
                    }
                }
                if(j == needle.length()) {
                    res = i;
                }
            }
        }
        return res;
    }
}