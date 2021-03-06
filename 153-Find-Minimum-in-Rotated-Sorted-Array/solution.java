public class Solution {
    	public int findMin(int[] nums) {
		int start = 0;
				int end = nums.length-1;
				if(nums[start] <= nums[end]) {	//just to make sure it's rotated
					return nums[start];
				}
				while(start < end) {
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
						int i = start + 1;
						while( i <= end && nums[i] == nums[i - 1])
						{//NoteNote:
						i++;
						}
						if(i > end) {
							return nums[end];
						}else if (nums[i] > nums[i - 1]){
							return nums[i - 1]; 
						} else {
								return nums[i]; 
						}
					}
				}
				return -1;
	}
    
}