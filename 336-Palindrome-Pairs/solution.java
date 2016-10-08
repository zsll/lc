public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words != null && words.length > 0) {
            HashMap<String, Integer> h = new HashMap<String, Integer>();
            for(int i = 0; i < words.length; i++) {
                h.put(reverse(words[i]), i);
            }
            HashSet<List<Integer>> v = new HashSet<List<Integer>>();
            /**
             * without the hash
             * Input:
["abcd","dcba","lls","s","sssll"]
Output:
[[1,0],[0,1],[0,1],[1,0],[3,2],[2,4]]
Expected:
[[0,1],[1,0],[3,2],[2,4]]
*/
            for(int i = 0; i < words.length; i++) {
                for(int j = 0; j <= words[i].length(); j++) {    //j is length of fisrt half, note needs to cover entire string, it's from 0 to length!
                /**
                 * Submission Result: Wrong Answer More Details 

Input:
["a",""]
Output:
[[1,0]]
Expected:
[[0,1],[1,0]]*/
                    String sub1 = words[i].substring(0, j), sub2 = words[i].substring(j);
                    if(h.containsKey(sub1)) {
                        int k = h.get(sub1);
                        if(k != i && isPalindrome(words[i], j, words[i].length() - 1)) {//NoteNote, k != i
                            List<Integer> l = new ArrayList<Integer>();
                                l.add(i);
                                l.add(k);
                            if(!v.contains(l)) {
                                res.add(l);
                                v.add(l);
                            }
                        }
                    }
                    if(h.containsKey(sub2)) {
                        int k = h.get(sub2);
                        if(k != i && isPalindrome(words[i], 0, j - 1)) {
                            List<Integer> l = new ArrayList<Integer>();
                                l.add(k);
                                l.add(i);
                            if(!v.contains(l)) {
                                res.add(l);
                                v.add(l);
                            }
                        }
                        
                    }
                }
            }
        }
        return res;
    }
    
    String reverse(String word) {
        StringBuffer sb = new StringBuffer(word);
        return new String(sb.reverse());
    }
    
    boolean isPalindrome(String s, int start, int to) {
        boolean res = true;
        while(start < to)  {
            if(s.charAt(start) != s.charAt(to)) {
                res = false;
                break;
            }
            start++;
            to--;
        }
        return res;
    }
}