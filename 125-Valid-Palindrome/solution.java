public class Solution {
    public boolean isPalindrome(String s) {
        boolean res = true;
        if(s != null && s.length() > 0) {
            int i = 0, j = s.length() - 1;
            while(i < j) {
                while(!isAlpha(s.charAt(i)) && i < j) {
                    i++;
                }
                while(!isAlpha(s.charAt(j)) && i < j) {
                    j--;
                }
                if(i < j && !charEqauls(
                    s.charAt(i), s.charAt(j)
                    )
                ) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
    
    boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
    
    boolean charEqauls(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}