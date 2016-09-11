public class Solution {

    int[] nums;
    int[] shuffled;
    public Solution(int[] nums) {
        this.nums = nums;
        shuffled=Arrays.copyOf(nums, nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int i = nums.length - 1;
        		Random r = new Random();
        		while(i > 0) {
            		int j = r.nextInt(i + 1);
            		swap(shuffled, i, j);
            		i--;
        		}
        return shuffled;
    }
    
    void swap(int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */