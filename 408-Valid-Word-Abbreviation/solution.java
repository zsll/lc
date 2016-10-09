public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        boolean res = false;
        if(word != null && word.length() > 0 && abbr != null && abbr.length() > 0) {
        	int i = 0, j = 0;
        	res = true;
        	int cur = 0;
        	while(i < word.length() && j < abbr.length()) {
        	    if(!isN(abbr.charAt(j))) {
        	        if(abbr.charAt(j) != word.charAt(i)) {
        	            res = false;
        	            break;
        	        }
        	        cur = 0;
        	        i++;
        	        j++;
        	    } else {
        	        if(cur == 0 && abbr.charAt(j) == '0') {
        	    		/**
        	    		 * Submission Result: Wrong Answer More Details 

Input:
"a"
"01"
Output:
true
Expected:
false
        	    		 */
        	    		res = false;
        	    		break;
        	    	}
        	        cur = cur*10 + abbr.charAt(j) - '0';
        	        if(j == abbr.length() - 1 || !isN(abbr.charAt(j + 1))) {
        	            i += cur;
        	        }
        	        j++;
        	    }
        	}
        	res = res && abbr.length() == j && i == word.length();
        }
        return res;
    }
    
    boolean isN(char c) {
        return c >= '0' && c <= '9';
    }
}