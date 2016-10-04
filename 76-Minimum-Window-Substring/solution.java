public class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if(!(t == null || s == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())) {
            int minLen = s.length() + 1, minStart = 0, minEnd = 0, inSize = 0, j = 0;  //minEnd = 0 means invalid
            int [] tCnt = new int[255];
            int [] inCnt = new int[255];
            for(int i = 0; i < t.length(); i++) {
                tCnt[t.charAt(i)]++;
            }
            for(int i = 0; i < s.length(); i++) {
                while(inSize < t.length() && j < s.length()) {
                    int c = (int)s.charAt(j);
                    
                        inCnt[c]++;
                        if(inCnt[c] <= tCnt[c]) {
                            inSize++;
                        }
                    
                    j++;
                }
                if(inSize == t.length() && minLen > j - i) {
                    minLen = j - i;
                    minStart = i;
                    minEnd = j;
                }
                int c = (int)s.charAt(i);
                
                    inCnt[c]--;
                    if(inCnt[c] < tCnt[c]) {//NoteNote t[c] > 0, else negative smaller than 0 does not make sense
                        inSize--;
                    }
                
            }
            if(minEnd > 0) {
                res = s.substring(minStart, minEnd);
            }
        }
        return res;
    }
}