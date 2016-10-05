public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(nums != null) {
            List<Integer> cur = new ArrayList<Integer>();
            HashSet<Integer> v = new HashSet<Integer>();
            dfs(res, cur, v, nums);
        }
        return res;
    }
    
    void dfs(List<List<Integer>>  res, List<Integer> cur, HashSet<Integer> v, int [] nums) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList<Integer>(cur));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(!v.contains(i)) {
                    v.add(i);
                    cur.add(nums[i]);
                    dfs(res, cur, v, nums);
                    v.remove(i);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}