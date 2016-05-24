public class Solution {
    public int findMin(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		while(start < end && nums[start]>nums[end]) {
			if(end-start==1) {
		
				return nums[end];
			
			}
			int mid=(start+end)/2; 
			if(nums[mid]>nums[start]){
			start=mid; 
			}
				else{ end=mid;
			} 
		}
		return nums[start]; 
		}
    
}