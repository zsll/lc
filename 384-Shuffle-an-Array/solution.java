public class Solution {
int[] original;
    int[] shuffled;  
    Random r;
 
    public Solution(int[] nums) {
        original = nums;
        shuffled = Arrays.copyOf(nums,nums.length);
        r = new Random();
    }
 
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffled=Arrays.copyOf(original, original.length);
        return shuffled;
    }
 
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = shuffled.length;
 
        for(int i=0; i<len; i++){
            int si = r.nextInt(len-i);
            int temp = shuffled[i];
            shuffled[i]=shuffled[si+i];
            shuffled[si+i]=temp;
        }
 
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */