public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
		int end = nums.length-1;
		
		while(start < end) {
			if(nums[start] < nums[end]) {	//just to make sure it's rotated, else since it's sorted, return nums start
				return nums[start];
			}
			if(end-start==1) {
				return nums[end];
			}
			int mid=(start+end)/2; 
			if(nums[mid]>nums[start] || nums[mid] > nums[end]){
				start=mid; 
			}
			else if (nums[mid]<nums[end] || nums[start] > nums [mid]){
				 end=mid;
			} else {	
				start++;
				end--;
			}
		}
		return nums[start];
    }
}