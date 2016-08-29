public class Solution {
    public boolean increasingTriplet(int[] nums) {
        boolean res = false;
        if(nums != null && nums.length >= 3) {
            int len = nums.length;
            Integer min = null, min2 = null, minRight = null;
            for(int i : nums) {
                if(min == null) {
                    min = i;
                } else {
                    if(min2 == null) {
                        if(i > min) {
                            min2 = i;
                        } else {
                            min = i;
                        }
                    } else {
                        if(i > min2) {
                            res = true;
                            break;
                        } else {
                            if(minRight != null) {
                                if(i > minRight) {
                                    min = minRight;
                                    min2 = i;
                                    minRight = null;
                                } else {
                                    minRight = i;
                                }
                            } else {
                                if(i > min) {
                                    min2 = i;
                                } else {
                                    minRight = i;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}