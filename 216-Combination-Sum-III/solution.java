public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(k > 0 && n >= k) {
    		List<Integer> curList = new ArrayList<Integer>();
    		combinationSum3Helper(k, n, 0, 1, res, curList);
    	}
    	return res;
    }
    
    void combinationSum3Helper(int k, int remain, int i, int start,  List<List<Integer>> res, List<Integer> curList) {
    	if(remain == 0 && i == k) {
    		//Collections.sort(curList);
    		List<Integer> clone = new ArrayList<Integer>(curList);	//NoteNote: we need a clone!
    		res.add(clone);
    	} else {
    		for(int j = start; j <= Math.min(9, remain); j++) {
    			curList.add(j);
    			combinationSum3Helper(k, remain - j, i + 1, j + 1, res, curList);
    			curList.remove(curList.size() - 1);
    		}
    	}
    }
}