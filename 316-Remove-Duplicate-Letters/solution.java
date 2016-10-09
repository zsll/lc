public class Solution {
    public String removeDuplicateLetters(String s) {
        String res = s;
        if(s != null && s.length() > 0) {
            int [] cnt = new int[255];
            for(char c : s.toCharArray()) {
                cnt[c]++;
            }
            char min = 255;
            int minPos = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c < min) {
                    min = c;
                    minPos = i;
                }
                cnt[c]--;
                if(cnt[c] == 0) {
                    break;
                }
            }
            res = min + removeDuplicateLetters(s.substring(minPos + 1).replaceAll(min + "", ""));//NoteNote start from minPos, needs to use replaceAll
        }
        return res;
    }
}