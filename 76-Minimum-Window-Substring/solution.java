public class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if(s != null && t != null && t.length() > 0 && s.length() >= t.length()) {
            int [] tCnt = new int[255];
            for(char c : t.toCharArray()) {
                tCnt[c]++;
            }
            int [] inWinCnt = new int[255];
            int j = 0, size = 0;
            for(int i = 0; i < s.length(); i++) {
                while(j < s.length() && size < t.length()) {
                    char c = s.charAt(j);
                    if(tCnt[c] > 0) {
                        inWinCnt[c]++;
                        if(inWinCnt[c] <= tCnt[c]) {
                            size++;
                        }
                    }
                    j++;
                }
                if(size == t.length()) {
                    String sub = s.substring(i, j);
                    if(res.equals("") || sub.length() < res.length()) {
                        res = sub;
                    }
                }
                char c = s.charAt(i);
                if(tCnt[c] > 0) {
                    inWinCnt[c]--;
                    if(inWinCnt[c] < tCnt[c]) {
                        size--;
                    }
                }
            }
        }
        return res;
    }
}