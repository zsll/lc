public class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        if(words != null && words.length > 0) {
            HashMap<String, Integer> m = new HashMap<String, Integer>();
            for(String s : words) {
                int i = 0;
                for(char c : s.toCharArray()) {
                    i = i | (1 << (c - 'a'));
                }
                m.put(s, i);
            }
            for(int i = 0; i < words.length - 1; i++) {
                for(int j = i + 1; j < words.length; j++) {
                    if((m.get(words[i]) & m.get(words[j])) == 0) {//
                        res = Math.max(words[i].length() * words[j].length(), res);
                    }
                }
            }
        }
        return res;
    }
}