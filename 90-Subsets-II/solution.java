public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(res, cur, 0, nums);
        return res;
    }
    
    void dfs(List<List<Integer>> res, List<Integer> cur, int pos, int [] nums) {
        res.add(new ArrayList<Integer>(cur));   //NoteNote
        HashSet<Integer> v = new HashSet<Integer>();
        for(int i = pos; pos < nums.length; pos++) {
            if(!v.contains(nums[pos])) {
                cur.add(nums[pos]);
                dfs(res, cur, pos + 1, nums);
                cur.remove(cur.size() - 1);
                v.add(nums[pos]);
            }
        }
        
    }
}