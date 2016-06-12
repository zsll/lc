public class Solution {
    public boolean increasingTriplet(int[] nums) {
             boolean res = false;
        if(nums != null && nums.length >= 3) {
        	int len = nums.length;
        	int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, 
        			minRight = Integer.MAX_VALUE; //This means minRight is on right of min2, and even smaller than min
        	//Note min2 is always on right of min
        	//So it's not totally equivalent to 2nd minimum
        	for(int i = 0; i < len; i++) {
        		if(nums[i] > min2) {
        			res = true;
        			break;
        		} else if (min2 > nums[i] && nums[i] > min) {
        			min2 = nums[i];
        		} else if (nums[i] > minRight) {
        			min = minRight;
        			min2 = nums[i];
        			minRight = Integer.MAX_VALUE;
        		} else if (nums[i] <= min) {
        			minRight = nums[i];
        		} 
        	}
        }
        return res;
    }
}