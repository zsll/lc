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
    public int rob(TreeNode root) {
        int [] res = dfs(root);
        return res[0];
    }
    
    //0 is max, 1 is max without self
    int [] dfs(TreeNode r) {
        int [] res = {0, 0};
        if(r != null) {
            int [] l = dfs(r.left);
            int [] ri = dfs(r.right);
            res[1] = l[0] + ri[0];
            res[0] = Math.max(res[1], r.val + l[1] + ri[1]);
        }
        return res;
    }
}