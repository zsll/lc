public class Solution {
    public String shortestPalindrome(String s) {
        String res = s;
        if(s != null && s.length() > 0) {
            int len = s.length();
            int i = (len - 1)/2, j = (len )/2;  //NoteNote
            boolean moveI = i == j;
            while(i >= 0) {
                if(isParlindrome(s, i, j)) {
                    break;
                }
                if(moveI) {
                    i --;
                    moveI = false;
                } else {
                    j--;
                    moveI = true;
                }
            }
            StringBuffer sb = new StringBuffer();
            while(i > 0) {
                i--;j++;
            }
            for(int k = len - 1; k > j; k--) {
                sb.append(s.charAt(k));
            }
            return sb.append(s).toString();
        }
        return res;
    }
    
    boolean isParlindrome(String s, int i, int j) { //expanding from i and j, if i can reach 0 
        boolean res = true;
        while(i >= 0 && s.charAt(i) == s.charAt(j)) {
            i--; j++;
        }
        return i < 0;
    }
}