public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                l1.add(i);
            } else if(words[i].equals(word2)) {
                l2.add(i);
            }
        }
        int res = Integer.MAX_VALUE;
        if(!word1.equals(word2)) {
            int i = 0, j = 0;
            while(i < l1.size() && j < l2.size()) {
                res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
                if(res == 0) break;
                if(l1.get(i) < l2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
        } else {
            int pre = l1.get(0);
            for(int i = 1; i < l1.size(); i++) {
                res = Math.min(res, l1.get(i) - pre);
                pre = l1.get(i);
            }
        }
        return res;
    }
}