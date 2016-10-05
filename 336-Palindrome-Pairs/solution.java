public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        //brutal force is O N by N by m, where m is the average length
        //If we firstly get the pre/suffix map, complexity would be O N by m
        //Then scan each word, see if its reverse is prefix or suffix, complexity would be O N m
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(words != null && words.length > 0) {
            HashMap<String, Set<Integer>> preToIdx = new HashMap<String, Set<Integer>>();
            HashMap<String, Set<Integer>> sufToIdx = new HashMap<String, Set<Integer>>();
            for(int i = 0; i < words.length; i++) {
                String word = words[i];
                for(int j = 0; j <= word.length(); j++) {
                    /**
                     * Input:
["a",""]
Output:
[]
Expected:
[[0,1],[1,0]]

NoteNote, j is the substring length, it starts from 0, not zero, so empty string would be pre and suffix of all words
*/
                    String pre = word.substring(0, j), suf = word.substring(word.length() - j, word.length());
                    if(!preToIdx.containsKey(pre)) {
                        preToIdx.put(pre, new HashSet<Integer>());
                    }
                    preToIdx.get(pre).add(i);
                    if(!sufToIdx.containsKey(suf)) {
                        sufToIdx.put(suf, new HashSet<Integer>());
                    }
                    sufToIdx.get(suf).add(i);
                }
            }
            for(int i = 0; i < words.length; i++) {
                StringBuffer sb = new StringBuffer(words[i]);
                String reverse = new String(sb.reverse());
                if(preToIdx.containsKey(reverse)) {
                    for(Integer j : preToIdx.get(reverse)) {
                        if(i != j) {
                            if(isPalindrome(words[j], reverse.length(), words[j].length() - 1)) {
                                List<Integer> l = new ArrayList<Integer>();
                                l.add(j);
                                l.add(i);
                                if(res.indexOf(l) == -1) {
                                    /**
                                     * Submission Result: Wrong Answer More Details 

Input:
["abcd","dcba","lls","s","sssll"]
Output:
[[1,0],[0,1],[0,1],[1,0],[2,4],[3,2]]
Expected:
[[0,1],[1,0],[3,2],[2,4]]*/
                                    res.add(l);
                                }
                            }
                        }
                    }
                }
                if(sufToIdx.containsKey(reverse)) {
                    for(Integer j : sufToIdx.get(reverse)) {
                        if(i != j) {
                            if(isPalindrome(words[j], 0, words[j].length() - words[i].length() - 1)) {
                                List<Integer> l = new ArrayList<Integer>();
                                l.add(i);
                                l.add(j);
                                if(res.indexOf(l) == -1) {
                                    res.add(l);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    
    boolean isPalindrome(String s, int start, int end) {
        boolean res = true;
        while(start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if(start < end) {
            res = false;
        }
        return res;
    }
}