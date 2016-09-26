public class Solution {
    /**
     * 

dp1 i means max length of wiggle sequence before ending with i, and previous diff is positive

dp2 i means max length of wiggle sequence before ending with i, and previous diff is negative


dp1 i equals max of dp2 j + 1, j = 0 ... i - 1, and num j is larger than num i
dp2 i equals max of dp1 j + 1, j = 0 ... i - 1, and num j is smaller than num i
*/
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length==0)
	        return 0;
	    if(nums.length<2){
	        return nums.length;
	    }    
	 
	    int count=1;
	 
	 
	    for(int i=1, j=0; i<nums.length; j=i, i++){
	        if(nums[j]>nums[i]){
	            count++;
	            while(i<nums.length-1 && nums[i]>=nums[i+1]){
	                i++;
	            }
	        } else if(nums[j]<nums[i]){
	            count++;
	            while(i<nums.length-1 && nums[i]<=nums[i+1]){
	                i++;
	            }
	        }
	    }
	 
	    return count;
    }
}