public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
    	if(nums != null && nums.length > 0) {
    		int preS = nums[0], preE = nums[0];
    		for(int i = 1; i < nums.length; i++) {
    			int cur = nums[i];
    			if(cur == preE + 1) {
    				preE = cur;
    			} else {
    				if (preE == preS) {
    					res.add(Integer.toString(preE));
    				} else {
    					res.add(preS + "->" + preE);
    				}
    				preE = cur;
    				preS = cur;
    			}
    		}
    		if (preE == preS) {
    					res.add(Integer.toString(preE));
    				} else {
    					res.add(preS + "->" + preE);
    				}
    	}
    	return res;
    }
}