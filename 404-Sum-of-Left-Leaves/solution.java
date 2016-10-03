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
    public int sumOfLeftLeaves(TreeNode root) {
        int [] res = {0};
        dfs(root, null, res);
        return res[0];
    }
    
    void dfs(TreeNode cur, TreeNode parent, int [] sum) {
        if(cur != null) {
            if(cur.left == null && cur.right == null && parent != null && parent.left == cur) {
                sum[0] += cur.val;
            } else {
                dfs(cur.left, cur, sum);
                dfs(cur.right, cur, sum);
            }
        }
    }
}