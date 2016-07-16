public class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> r= new ArrayList<List<Integer>>();
        if(n > 0 && n >= k) {
        	int [] a = new int[n];
        	for(int i = 0; i< n; i++) {
        		a[i] = i + 1;
        	}
        	List<Integer> c = new ArrayList<Integer>();
        	combineHelper(a, k, 0, r, c);
        }
        return r;
    }
    
    void combineHelper(int [] a, int k, int pos, List<List<Integer>> r, List<Integer> c) {
    	if(pos == k) {
    		List<Integer> c2 = new ArrayList<Integer>(c);
    		r.add(c2);
    	}
    	int start = 0;
    	if(c.size() > 0) {
    		start = c.get(c.size() - 1);
    	}
    	for(int i= start; i < a.length; i++) {
    		c.add(a[i]);
    		combineHelper(a, k, pos + 1, r, c);
    		c.remove(pos);
    	}
    }
}