public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
       List<String> res = new ArrayList<String>();
    	if(s != null && s.length() > 10) {
	    	Map<Character, Integer> h = new HashMap<Character, Integer>();
	    	h.put('A', 0);
	    	h.put('C', 1);
	    	h.put('G', 2);
	    	h.put('T', 3);
	    	/**
	    	 * can't use set:
	    	 * Wrong Answer More Details 

Input:
"AAAAAAAAAAAA"
Output:
["AAAAAAAAAA","AAAAAAAAAA"]
Expected:
["AAAAAAAAAA"]
	    	 */
	    	Map<Integer, Integer> dnaSum = new HashMap<Integer, Integer>();
	    	int sum = 0;
	    	for(int i = 0; i < 10; i++) {
	    		sum = ( sum<<2 | h.get(s.charAt(i)) ) & 0xFFFFF;
	    	}
	    	dnaSum.put(sum, 1);
	    	for(int i = 10; i < s.length(); i++) {
	    		sum = ( sum<<2 | h.get(s.charAt(i)) ) & 0xFFFFF;
	    		if(dnaSum.containsKey(sum) && 1 == dnaSum.get(sum)) {
	    			res.add(s.substring(i - 9, i + 1));
	    		} 
	    		if (!dnaSum.containsKey(sum)) {
	    			dnaSum.put(sum, 1);
	    		} else {
	    			dnaSum.put(sum, 0);	//Should be count plus 1, but does not matter
	    		}
	    		
	    	}
    	}
    	return res;
    }
}