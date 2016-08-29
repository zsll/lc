public class Solution {
    public boolean increasingTriplet(int[] nums) {
        boolean res = false;
        if(nums != null && nums.length >= 3) {
            int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
            for(int i : nums) {
                if(i > min2) {
                    res = true;
                    break;
                } else if (i > min) {
                    min2 = i;
                } else if (i > minRight) {
                    min = minRight;
                    min2 = i;
                    minRight = Integer.MAX_VALUE;
                } else {
                    minRight = i;   //first step
                }
            }
        }
        return res;
    }
}