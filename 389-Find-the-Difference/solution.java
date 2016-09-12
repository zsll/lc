public class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            int prev = map.get(c);
            map.put(c, prev + 1);
        }
        for(char c : t.toCharArray()) {
            if(!map.containsKey(c)) {
                res = c;
                break;
            }
            int prev = map.get(c);
            if(prev == 1) {
                map.remove(c);
            } else {
                map.put(c, prev - 1);
            }
        }
        return res;
    }
}