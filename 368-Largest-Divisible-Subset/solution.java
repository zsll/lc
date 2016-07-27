public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums != null && nums.length > 0) {
            Arrays.sort(nums);
            int len = nums.length;
            ArrayList<ArrayList<Integer>> subSet = new ArrayList<ArrayList<Integer>>();
            subSet.add(new ArrayList<Integer>());
            subSet.get(0).add(nums[0]);
            for(int i = 1; i < len; i++) {
                subSet.add(new ArrayList<Integer>());
                subSet.get(i).add(nums[i]);
                for(int j = 0; j <= i - 1; j++) {
                    if(nums[i]%nums[j] == 0 && subSet.get(j).size() + 1 > subSet.get(i).size()) {
                        subSet.get(i).clear();
                        subSet.get(i).addAll(subSet.get(j));
                        subSet.get(i).add(nums[i]);
                    } 
                }
            }
            for(int i = 0; i < len; i++) {
                if(subSet.get(i).size() > res.size()) {
                    res = subSet.get(i);
                }
            }
        }
        return res;
    }
}