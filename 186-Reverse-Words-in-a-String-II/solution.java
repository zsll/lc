public class Solution {
    public void reverseWords(char[] s) {
        if(s != null && s.length > 1) {
            reverse(s, 0, s.length - 1);
            int start = 0, end = 0;
            while(end < s.length) {
                start = findStart(s, end);
                end = findEnd(s, start);
                if(end < s.length) {
                   reverse(s, start, end);
                   end++;   //to find next start
                   /**
                    * Submission Result: Time Limit Exceeded  More Details 

Last executed input:
"a b"*/
                }
            }
        }
    }
    
    void reverse(char [] s, int start, int end) {
        while(start < end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }
    
    int findStart(char [] s, int start) {
        while(start < s.length && !(start == 0 && s[start] != ' ' || s[start] != ' ' && s[start - 1] == ' ')) {
            start++;
        }
        return start;
    }
    
    
    int findEnd(char [] s, int start) {
        while(start < s.length && !(start == s.length - 1 && s[start] != ' ' || s[start] != ' ' && s[start + 1] == ' ')) {
            start++;
        }
        return start;
    }
}