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
	        int i = 0;
	        int j = word2.length() - 1;
	        while (i < word1.length() && j >= 0) {
	            if (word1.charAt(i) != word2.charAt(j)) {
	                return false;
	            }
	            i += 1;
	            j -= 1;
	        }
	        if (word1.length() < word2.length()) {
	            i = 0;
	            while (i < j) {
	                if (word2.charAt(i) != word2.charAt(j)) {
	                    return false;
	                }
	                i += 1;
	                j -= 1;
	            }
	        } else if (word1.length() > word2.length()) {
	            j = word1.length() - 1;
	            while (i < j) {
	                if (word1.charAt(i) != word1.charAt(j)) {
	                    return false;
	                }
	                i += 1;
	                j -= 1;
	            }
	        }
	        return true;
	    }
	    
}