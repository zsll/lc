public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(res, cur, candidates, 0, target);
        return res;
    }
    
    void dfs(List<List<Integer>> res, List<Integer> cur, int [] candidates, int pos, int target) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(cur));
        } else if (target > 0) {
            for(int i = pos; i < candidates.length; i++) {
                cur.add(candidates[i]);
                dfs(res, cur, candidates, i, target - candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }
}