public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(res, cur, 2, n, true);
        return res;
    }
    
    /**
     * Input:
12
Output:
[[2,2,3],[2,3,2],[2,6],[3,2,2],[3,4],[4,3],[6,2]]
Expected:
[[2,6],[3,4],[2,2,3]]
*/
    void dfs(List<List<Integer>> res, List<Integer> cur, int pre, int n, boolean firstLoop) {
        if(n == 1 && cur.size() > 0) {
            /**
             * Submission Result: Wrong Answer More Details 

Input:
1
Output:
[[]]
Expected:
[]
*/
            res.add(new ArrayList<Integer>(cur)); 
        } else {
            for(int i = pre; i <= n; i++) {
                if(firstLoop && i == n) {
                    break;
                }
                if(n%i == 0) {
                    cur.add(i);
                    dfs(res, cur, i, n/i, false);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}