public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(res, cur, 0, nums);
        return res;
    }
    
    void dfs(List<List<Integer>> res, List<Integer> cur, int pos, int [] nums) {
        res.add(new ArrayList<Integer>(cur));
        for(int i = pos; pos < nums.length; pos++) {
            cur.add(nums[pos]);
            dfs(res, cur, pos + 1, nums);
            cur.remove(cur.size() - 1);
        }
        
    }
}