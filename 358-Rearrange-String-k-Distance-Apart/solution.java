public class Solution {
    public String rearrangeString(String str, int k) {
        String res = "";
        if(str != null) {
            int len = str.length(), i = 0;
            int [] count = new int[26];
            int [] nextValidPos = new int[26];
            char [] a = new char[len];
            for(char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            while(i < len) {
                char c = find(count, nextValidPos, i);
                if(c == 0) {
                    break;
                }
                a[i] = c;
                count[c - 'a']--;
                nextValidPos[c - 'a'] += k;
                i++;
            }
            if(i == len) {
                res = new String(a);
            }
        }
        return res;
    }
    
    char find(int [] count, int [] nextValidPos, int pos) {
        char c = 0;
        int maxValidCount = Integer.MIN_VALUE;
        for(int i = 0; i < count.length; i++) {
            if(nextValidPos[i] <= pos && maxValidCount <= count[i] && count[i] > 0) {
                maxValidCount = count[i];
                c = (char)(i + 'a');
            }
        }
        return c;
    }
}