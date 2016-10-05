public class Solution {
    
    public boolean isNumber(String s) {
        String pattern = "\\s*[+-]?(\\d*\\.?\\d+|\\d+\\.?\\d*)(e[+-]?\\d+)?\\s*";  //NoteNote, . needs to be escaped using \\
        return s.matches(pattern);
    }
}