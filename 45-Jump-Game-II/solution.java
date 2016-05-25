public class Solution {
    public int jump(int[] nums) {
        int step = 0;
    if(nums != null && nums.length > 0) {
    	int maxReach = 0,  previousReach = 0;
    	for(int i = 0; i < nums.length; i++) {
   			if(i > previousReach) {
   				step++;
   				previousReach = maxReach;
   			}
    		if(maxReach >= i) {
 			   if(maxReach < i + nums[i]) {
 				   maxReach = i + nums[i];
 			   }
 			   if(maxReach >= nums.length - 1) {
 				  if(nums.length - 1 > previousReach) {
 		   				step++;
 		   			}
 				   break;
 			   }
 		   } else {
 			   step = 0;
 			   break;
 		   }
    	}
    }
    return step;
    }
}