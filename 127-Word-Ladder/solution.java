public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int res = 1;
        if(beginWord != null && endWord != null && endWord.length() == beginWord.length() && !beginWord.equals(endWord)) {
            LinkedList<String> q = new LinkedList<String>();
            q.add(beginWord);
            wordList.remove(beginWord);
            boolean found = false;
            while(q.size() > 0 && !found) {
                res++;
                LinkedList<String> next = new LinkedList<String>();
                for(String s : q) {
                    
                    for(int i = 0; i < s.length() && !found; i++) {
                        
                        for(char c = 'a'; c <= 'z' && !found; c++) {
                            StringBuffer sb = new StringBuffer(s);
                            if(c != sb.charAt(i)) {
                                sb.setCharAt(i,c);
                                String newW = new String(sb);
                                if(endWord.equals(newW)) {
                                    found = true;
                                    break;
                                } else if(wordList.contains(newW)) {
                                    wordList.remove(newW);
                                    next.add(newW);
                                }
                            }
                        }
                    }
                    if(found) {
                        break;
                    }
                }
                q = next;
            }
            if(!found) {
                /**
                 * Submission Result: Wrong Answer More Details 

Input:
"hot"
"dog"
["hot","dog"]
Output:
1
Expected:
0
*/
                res = 0;
            }
        }
        return res;
    }
}