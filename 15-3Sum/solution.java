public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums != null && nums.length > 0) {
            Arrays.sort(nums);
            for(int i = 1; i < nums.length - 1; i++) {
                int left = 0, right = nums.length - 1;
                if(nums[i] == nums[i - 1]) {
                    left = i - 1;
                }
                while(left < i && right > i) {
                    int sum = nums[left] + nums[right] + nums[i];
                    if(sum == 0) {
                        if((left == 0 || nums[left] != nums[left - 1]) && (right == nums.length - 1 || nums[right] != nums[right + 1])) {
                            List<Integer> l = new ArrayList<Integer>();
                            l.add(nums[left]);
                            l.add(nums[i]);
                            l.add(nums[right]);
                            res.add(l);
                        }
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}