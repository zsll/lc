public class Solution {
    public String reverseVowels(String s) {
        String res = s;
        if(s != null && s.length() > 1) {
            int i = findVowel(s, 0, true);
            int j = findVowel(s, s.length() - 1, false);
            StringBuffer sb = new StringBuffer(s);
            while(i < j) {
                char c = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, c);
                
                 i = findVowel(s, i + 1, true);
                 j = findVowel(s, j - 1, false);
            }
            res = sb.toString();
        }
        return res;
    }
    
    int findVowel(String s, int startPos, boolean forward) {
        int res = startPos;
        if(s != null && startPos >= 0 && startPos < s.length()) {
            HashSet<Character> se = new HashSet<Character>();
            se.add('a');
            se.add('i');
            se.add('o');
            se.add('e');
            se.add('u');
            se.add('A');
            se.add('I');
            se.add('O');
            se.add('E');
            se.add('U');
            if(forward) {
                while(startPos < s.length() && !se.contains(s.charAt(startPos)) ) {
                    startPos++;
                }
            } else {
                while(startPos >= 0 && !se.contains(s.charAt(startPos)) ) {
                    startPos--;
                }
            }
            res = startPos;
        }
        return startPos;
    }
}