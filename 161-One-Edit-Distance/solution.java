public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        boolean res = true;
        if(sLen < tLen) {
            res = isOneEditDistance(t, s);
        } else {
            if(sLen - tLen > 1) {
                res = false;
            } else {
                int i = 0;
                while(i < tLen && s.charAt(i) == t.charAt(i)) {
                    i++;
                }
                if(i == tLen) {
                    return sLen - tLen == 1;
                } else {
                    int diff = sLen - tLen;
                    if(diff == 0) {
                        i++;
                    }
                    while(i < tLen && s.charAt(i + diff) == t.charAt(i)) {
                        i++;
                    }
                    res = i == tLen;
                }
            }
        }
        return res;
    }
}