/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        HashMap<Integer, List<Integer>> h = new HashMap<Integer, List<Integer>> ();
        dfs(root, h);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i : h.keySet()) {
            res.add(h.get(i));
        }
        return res;
    }
    
    int dfs(TreeNode r, HashMap<Integer, List<Integer>> h) {
        if(r == null) {
            return 0;
        } else {
            int lH = dfs(r.left, h);
            int rH = dfs(r.right, h);
            int res = Math.max(lH, rH) + 1;
            if(!h.containsKey(res)) {
                h.put(res, new ArrayList<Integer>());
            }
            h.get(res).add(r.val);
            return res;
        }
    }
}