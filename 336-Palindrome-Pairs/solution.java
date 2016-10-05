public class Solution {
 	    public List<List<Integer>> palindromePairs(String[] words) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        for (int i = 0; i < words.length; i++) {
	            for (int j = 0; j < words.length; j++) {
	                if (i != j && isPalindrome(words[i], words[j])) {
	                    List<Integer> item = new ArrayList<Integer>();
	                    item.add(i);
	                    item.add(j);
	                    result.add(item);
	                }
	            }
	        }
	        return result;
	    }
	    public boolean isPalindrome(String word1, String word2) {
	        String s = word1 + word2;
	        return isPalindrome(s, 0, s.length() - 1);
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