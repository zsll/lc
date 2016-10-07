public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        
        if(nums != null && nums.length > 2) {
            Arrays.sort(nums);
            for(int i = 1; i < nums.length - 1; i++) {
                int start = 0, end = nums.length - 1;
                while(start < i && end > i) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if(sum < target) {
                        res += end - i;
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
}