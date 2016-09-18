public class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> r = new ArrayList<List<Integer>>();
    	List<Integer> c = new ArrayList<Integer>();
    	HashSet<Integer> v = new HashSet<Integer>();
    	combineHelperPermutationStyle(n, k, 1, r, c, v);
    	return r;
    }
    
    void combineHelperPermutationStyle(int n, int k, int start, List<List<Integer>> r, List<Integer> c, HashSet<Integer> v) {
    	if(c.size() == k) {
    	    r.add(new ArrayList<Integer>(c));
    	} else {
    	    for(int i = start; i <= n; i++) {
    	        if(!v.contains(i)) {
    	            c.add(i);
    	            v.add(i);
    	            combineHelperPermutationStyle(n, k, i + 1, r, c, v);
    	            c.remove(c.size() - 1);
    	            v.remove(i);
    	        }
    	    }
    	}
    }
}