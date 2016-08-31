public class Solution {
    public int maxProduct(String[] words) {
        //NoteNote since maximum chars a word can contain is 26, can use an integer as hash to represent the chars a word contains
        int res = 0;
        if(words != null && words.length > 0) {
            int len = words.length;
            int [] b = new int[len];
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < words[i].length(); j++) {
                    b[i] |= 1 << (words[i].charAt(j) - 'a');
                }
            }
            for(int i = 0; i < len; i++) {
                for(int j = i + 1; j < len; j++) {
                    if((b[i] & b[j]) == 0) {
                        res = Math.max(words[i].length() * words[j].length(), res);
                    }
                }
            }
        }
        return res;
    }
}