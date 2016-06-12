public class Solution {
    public boolean increasingTriplet(int[] nums) {
                boolean res = false;
        if(nums != null && nums.length >= 3) {
        	int len = nums.length;
        	int [] left = new int[len];
        	int [] right = new int [len];
        	left[0] = nums[0];
        	for(int i = 1; i < len; i++) {
        		left[i] = Math.min(left[i - 1], nums[i]);
        	}
        	right[len - 1] = nums[len - 1];
        	for(int i = len - 2; i >= 0; i--) {
        		right[i] = Math.max(right[i + 1], nums[i]);
        	}
        	for(int i = 1; i < len - 1; i++) {
        		if(nums[i] > left[i] && nums[i] < right[i]) {
        			res = true;
        			break;
        		}
        	}
        }
        return res;
    }
}