public class Solution {
    public List<Integer> countSmaller(int[] A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
    if(A != null && A.length > 0) {
	    TreeMap<Integer, Integer> ts = new TreeMap<Integer, Integer>();	//NoteNote Treeset won't be sufficient for there might be duplicate
	    ans.add(0, 0);	//Special handling for first element
	    ts.put(A[A.length - 1], 1);
	    int min = A[A.length - 1];
	    for(int i = A.length - 2; i >= 0; i--) {
	        int res = 0;
	    	if(A[i] > min) {
	    	    for(Map.Entry<Integer, Integer> m : ts.subMap(min, A[i]).entrySet() ){
	    	    	res += m.getValue();
	    	    }
	    	} else {
	    	    min = A[i];
	    	}
	    	ans.add(0, res);
	    	if(!ts.containsKey(A[i])) {
	    		ts.put(A[i], 0);
	    	}
    	    int pre = ts.get(A[i]);
    	    ts.put(A[i], pre + 1);
	    }
    }
    return ans;
    }
}