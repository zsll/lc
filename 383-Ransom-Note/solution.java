public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean res = false;
        if(ransomNote != null && magazine != null && magazine.length() >= ransomNote.length()) {
            int [] map = new int[26];
            int len = ransomNote.length();
            for(char c : ransomNote.toCharArray()) {
                map[c - 'a']++;
            }
            for(char c : magazine.toCharArray()) {
                map[c - 'a']--;
                if(map[c - 'a'] >= 0) {
                    len--;
                }
                if(len == 0) {
                    res = true;
                    break;
                }
            }
            
                if(len == 0) {
                    /*
                    Submission Result: Wrong Answer More Details 

Input:
""
""
Output:
false
Expected:
true*/
                    res = true;
                }
        }
        return res;
    }
}