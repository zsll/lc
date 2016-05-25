public class Solution {
    public boolean canJump(int[] nums) {
        boolean res = true;
   if(nums != null && nums.length > 0) {
	   int maxReach = 0;
	   for(int i = 0; i < nums.length; i++) {
		   if(maxReach >= i) {
			   if(maxReach < i + nums[i]) {
				   maxReach = i + nums[i];
			   }
			   if(maxReach >= nums.length) {
				   break;
			   }
		   } else {
			   res = false;
		   }
	   }
   }
   return res;
    }
}