public class Solution {
    public boolean wordPattern(String pattern, String str) {
        boolean res = true;
        if(pattern != null && str != null) {
            String [] s = str.split(" ");//NoteNote
            if(pattern.length() != s.length) {
                res = false;
            } else {
                HashMap<Character, String> h1 = new HashMap<Character, String>();
                HashMap<String, Character> h2 = new HashMap<String, Character>();
                for(int i = 0; i < s.length; i++) {
                    char c = pattern.charAt(i);
                    if(h1.containsKey(c) && !h1.get(c).equals(s[i]) || h2.containsKey(s[i]) && h2.get(s[i]) != c) {
                        res = false;
                        break;
                    }
                    h1.put(c, s[i]);
                    h2.put(s[i], c);
                }
            }
        }
        return res;
    }
}