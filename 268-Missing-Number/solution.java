public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = (1 + n) * n / 2;
        for(int i = 0; i < n; i++) {
            total -= nums[i];
        }
        return total;
    }
}