public class Solution {
    public boolean isPalindrome(String s) {
        boolean res = true;
        if(s != null && s.length() > 0) {
            int i = 0, j = s.length() - 1;
            while(i < j) {
                while(!isAlpha(s.charAt(i)) && !isNumber(s.charAt(i)) && i < j) {
                    i++;
                }
                while(!isAlpha(s.charAt(j)) && !isNumber(s.charAt(j)) && i < j) {
                    j--;
                }
                if(i < j && !charEqauls(
                    s.charAt(i), s.charAt(j)
                    )
                ) {
                    res = false;
                    break;
                } 
                
                    i++;
                    j--;
                
            }
        }
        return res;
    }
    
    boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
    
    boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
    
    boolean charEqauls(char a, char b) {
        return isAlpha(a) ? Character.toLowerCase(a) == Character.toLowerCase(b) : a == b;
    }
}