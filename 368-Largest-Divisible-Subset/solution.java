public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums != null && nums.length > 0) {
            Arrays.sort(nums);
            int max = 0;
            int len = nums.length;
            HashMap<Integer, List<Integer>> h = new HashMap<Integer, List<Integer>>();    //Key is index, value is subset it belongs to
            for(int j = 0; j < len; j++) {
                h.put(j, new ArrayList<Integer>());
                h.get(j).add(nums[j]);
                for(int i = 0; i < j; i++) {
                    if(nums[j]%nums[i] == 0) {
                        if(h.get(i).size() + 1 > h.get(j).size()) {
                            h.get(j).clear();
                            h.get(j).add(nums[j]);
                            h.get(j).addAll(h.get(i)); 
                        }
                    }
                }
                
                if(h.get(j).size() > max) {
                    max = h.get(j).size();
                    res = h.get(j);
                }
            }
        }
        return res;
    }
}