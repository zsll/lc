public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        int i = 0;
        while(i < words.length) {
            if(words[i].equals(word1)) {
                l1.add(i);
            } else if(words[i].equals(word2)) {
                l2.add(i);
            }
            i++;
        }
        int j = 0;
        i =0;
        int res = words.length; //NoteNote
        while(i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if(l1.get(i) - l2.get(j) > 0) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}