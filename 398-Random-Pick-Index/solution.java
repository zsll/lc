public class Solution {
    int []nums;
        public Solution(int[] nums) {
            this.nums = nums;
        }
        
       

    	public int pick(int target) {
    		int res = -1;
            Random r = new Random();
            int found = 0;
    		for(int i=0;i<nums.length;i++){
    		    
    		    if(target==nums[i]) {
    		        found++;
    		        if(r.nextInt(found) == 0) {
    		            res = i;
    		        }
    		    }
    		}
    		return res;
    	}

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */