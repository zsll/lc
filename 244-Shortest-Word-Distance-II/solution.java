public class WordDistance {

    HashMap<String, List<Integer>> m = new HashMap<String, List<Integer>>();
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++) {
            if(!m.containsKey(words[i])){
                m.put(words[i], new ArrayList<Integer>());
            }
            m.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = m.get(word1);
        List<Integer> l2 = m.get(word2);
        int i= 0, j = 0;
        int res = Integer.MAX_VALUE;
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

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");