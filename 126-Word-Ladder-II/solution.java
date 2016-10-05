public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(wordList != null && wordList.size() > 0 
        && beginWord != null && endWord != null 
        && beginWord.length() > 0 && beginWord.length() == endWord.length()) {
            HashSet<String> v = new HashSet<String>();
            HashSet<String> q = new HashSet<String>();
            HashMap<String, HashSet<String>> pre = new HashMap<String, HashSet<String>>();
            q.add(beginWord);
            boolean found = false;
            while(q.size() > 0 && !found) {
                for(String s : q) {
                    v.add(s);
                }
                HashSet<String> next = new HashSet<String>();
                for(String s : q) {
                    for(int i = 0; i < s.length(); i++) {
                        for(char c = 'a'; c <= 'z'; c++) {
                            if(c != s.charAt(i)) {
                                StringBuffer sb = new StringBuffer(s);
                                sb.setCharAt(i, c);//can't directly toString
                                String newS = sb.toString();
                                if(!v.contains(newS)) {
                                    if(newS.equals(endWord)) {
                                        found = true;
                                        addPre(s, newS, pre);
                                    }
                                    if(wordList.contains(newS)) {
                                        next.add(newS);
                                        addPre(s, newS, pre);
                                    }
                                    
                                }
                            }
                        }
                    }
                }
                q = next;
            }
            if(found) {
                buildPath(pre, beginWord, endWord, res, new ArrayList<String>());
            }
        }
        return res;
    }
    
    void addPre(String s, String newS, HashMap<String, HashSet<String>> pre) {
        if(!pre.containsKey(newS)) {
                                        pre.put(newS, new HashSet<String>());
                                    }
                                    pre.get(newS).add(s);
    }
    
    void buildPath(HashMap<String, HashSet<String>> pre, String beginWord, String cur, List<List<String>> res, List<String> curList) {
        curList.add(0, cur);
        if(beginWord.equals(cur)) {
            res.add(new ArrayList<String>(curList));
        } else {
            for(String s : pre.get(cur)) {
                buildPath(pre, beginWord, s, res, curList);
            }
        }
        curList.remove(0);//notenote
    }
}