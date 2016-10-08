public class Solution {
    public void wiggleSort(int[] nums) {
        int mid = findKth(nums, (nums.length + 1)/2);
        threeWaySort(nums, mid);
        /**
         * 0 1 2 3 4 5 6
         * 0 4 1 5 2 6 3
         * 
         * 0 -> 0
         * 1 -> 2
         * 2 -> 4
         * 3 -> 6
         * 
         * So new index = i*2
         * 
         * 4 -> 1
         * 5 -> 3
         * 6 -> 5
         * len - new = 2*(len - i)
         * new = len - 2*(len - i) = 2*i - len
         */ 
         remap(nums);
    }
    
    void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
    }
    
    int getNewI(int [] nums, int i) {
        if(i <= (nums.length - 1)/2) {
            return i*2;
        } else {
            return 2*i - nums.length;
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
    
    int findKth(int [] nums, int k) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int m = partition(nums, start, end);
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
    
    int partition(int [] nums, int start, int end) {
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
                nums[end] = nums[end];
                end--;
            }
        }
        nums[start] = t;
        return start;
    }
}