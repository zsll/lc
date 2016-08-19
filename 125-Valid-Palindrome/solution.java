public class Solution {
    public boolean isPalindrome(String s) {
        
    	 
        if(s == null) return false;
        if(s.length() < 2) return true;
 
        char[] charArray = s.toCharArray();
        int len = s.length();
 
        int i=0;
        int j=len-1;
 
        while(i<j){
            char left = charArray[i], right = charArray[j];
 
            while(i<j && !isAlpha(left) && !isNum(left)){
                left =  charArray[++i];
            }
 
            while(j>i && !isAlpha(right) && !isNum(right)){
                right = charArray[--j];
            }
            if(!isSame(left, right)){
                return false;
            }
 
            i++;
            j--;
        }
        return true;
    }
 
    public  boolean isAlpha(char a){
        if((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')){
            return true;
        }else{
            return false;
        }
    }
 
    public  boolean isNum(char a){
        if(a >= '0' && a <= '9'){
            return true;
        }else{
            return false;
        }
    }
 
    public  boolean isSame(char a, char b){
        if(isNum(a) && isNum(b)){
            return a == b;
        }else if(Character.toLowerCase(a) == Character.toLowerCase(b)){	//NoteNote: Character.toLowerCase
            return true;
        }else{
            return false;
        }
    }
}