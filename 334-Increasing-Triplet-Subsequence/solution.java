public class Solution {
    public boolean increasingTriplet(int[] nums) {
        boolean res = false;
        if(nums != null && nums.length > 2) {
            int rightMin = Integer.MAX_VALUE, min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for(int i : nums) {
                if(i > min2) {
                    res = true;
                    break;
                } else if(i > min) {
                    min2 = i;
                } else if(i > rightMin) {
                    min = rightMin;
                    rightMin = Integer.MAX_VALUE;
                    min2 = i;
                } else  {
                    rightMin = i;
                }
            }
        }
        return res;
    }
}