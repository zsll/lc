public class Solution {

  public List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(k > 0 && n >= k) {
    		List<Integer> curList = new ArrayList<Integer>();
    		combinationSum3Helper(k, n, 1, res, curList);
    	}
    	return res;
    }
    
    /**
     * Note note i can be ignored for it equals curList length
     * @param k
     * @param remain
     * @param i
     * @param start
     * @param res
     * @param curList
     */
    void combinationSum3Helper(int k, int remain, int start,  List<List<Integer>> res, List<Integer> curList) {
    	if(curList.size() == k) {
	    	if(remain == 0) {
	    		//Collections.sort(curList);
	    		List<Integer> clone = new ArrayList<Integer>(curList);	//NoteNote: we need a clone!
	    		res.add(clone);
	    	}
    	} else {
    	//} else if (remain >= start) {
    		for(int j = start; j <= Math.min(9, remain); j++) {
    			curList.add(j);
    			combinationSum3Helper(k, remain - j,  j + 1, res, curList);
    			curList.remove(curList.size() - 1);
    		}
    	}
    }
}