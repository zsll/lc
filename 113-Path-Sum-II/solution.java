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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        pathSumDFS(root, sum, res, cur);
        return res;
    }
    
    void pathSumDFS(TreeNode root, int sum, List<List<Integer>> res, List<Integer> cur) {
        if(root != null) {
            cur.add(root.val);
            sum -= root.val;
            if(0 == sum && root.left == null && root.right == null) {
                res.add(new ArrayList<Integer>(cur));
            } else {
                pathSumDFS(root.left, sum, res, cur);
                pathSumDFS(root.right, sum, res, cur);
            }
            cur.remove(cur.size() - 1);
        }
    }
}