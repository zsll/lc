public class Solution {
    public void wiggleSort(int[] nums) {
        int mid = findKth2(nums, (nums.length + 1)/2);
	        threeWaySort(nums, mid);
	        /**
	         * 
	         * 
	         * 0 1 2 3 4 5 6
	         * 3 6 2 5 1 4 0
	         * 
	         * 0 -> 6
	         * 1 -> 4
	         * 2 -> 2
	         * 3 -> 0
	         * 
	         * So new index = (len/2 - i)*2
	         * len = 7
	         * 
	         * 
	         * 4 -> 5
	         * 5 -> 3
	         * 6 -> 1
	         * 
	         * new = (len - i)*2 - 1
	         * 
	         * NoteNote, the mapping for second half differs for odd/even length
	         * 0 1 2 3 4 5
	         * 2 5 1 4 0 3
	         * len = 6
	         * 0 -> 4
	         * 1 -> 2
	         * 2 -> 0
	         * new index = (len/2 - 1 - i)*2
	         * 
	         * 3 -> 5
	         * 4 -> 3
	         * 5 -> 1
	         * new = (len - i)*2 - 1
	         * 
	         * 
	         */ 
	         remap(nums);
	    }
	    
	    
	    void remap(int [] nums) {
	        for(int i = 0; i < nums.length; i++) {
	            if(nums[i] > 0) {   //So it works for positive numbers
	                int newI = getNewI(nums, i);
	                while(i != newI) {
	                    swap(nums, i, newI);
	                    nums[newI] = 0 - nums[newI];
	                    newI = getNewI(nums, newI);
	                }
	                nums[i] = 0 - nums[i];
	            }
	            
	        }
	        for(int i = 0; i < nums.length; i++) {
	        	nums[i] = 0 - nums[i];
	        }
	    }
	    
	    int getNewI(int [] nums, int i) {
	        if(i > (nums.length - 1)/2) {
	            return (nums.length - i)*2 - 1;
	        } else {
	            return nums.length%2 > 0 ? (nums.length/2 - i)*2 : (nums.length/2 - i - 1)*2;
	        }
	    }
	    
	    void threeWaySort(int [] nums, int mid) {
	        int zEnd = 0, tStart = nums.length - 1;
	        for(int i = 0; i <= tStart; i++) {
	            if(nums[i] < mid) {
	                swap(nums, zEnd, i);
	                zEnd++;
	            } else if(nums[i] > mid) {
	                swap(nums, i, tStart);
	                tStart--;
	                i--;
	            }
	        }
	    }
	    
	    int findKth2(int [] nums, int k) {
	        int start = 0, end = nums.length - 1;
	        while(start <= end) {
	            int m = partition2(nums, start, end);
	            if(m == k - 1) {
	                return nums[m];
	            } else if (m > k - 1) {
	                end = m - 1;
	            } else {
	                start = m + 1;
	            }
	        }
	        return Integer.MAX_VALUE;
	    }
	    
	    int partition2(int [] nums, int start, int end) {
	        int t = nums[start];
	        while(start < end) {
	            while(end > start && nums[end] >= t) {
	                end--;
	            }
	            if(end > start) {
	                nums[start] = nums[end];
	                start++;
	            }
	            while(end > start && nums[start] <= t) {
	                start++;
	            }
	            if(end > start) {
	                nums[end] = nums[start];
	                end--;
	            }
	        }
	        nums[start] = t;
	        return start;
	    }
	    void swap(int [] a, int i, int j) {
	        int t = a[i];
	        a[i] = a[j];
	        a[j] = t;
	    }
}