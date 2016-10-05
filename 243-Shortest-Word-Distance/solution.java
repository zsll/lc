public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                l1.add(i);
            } else if(words[i].equals(word2)) {
                l2.add(i);
            }
        }
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        while(i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if(res == 0) break;
            if(l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}