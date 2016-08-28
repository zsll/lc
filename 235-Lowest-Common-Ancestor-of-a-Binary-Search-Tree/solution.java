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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        TreeNode res = null;
        while(root != null) {
            int v = root.val, large = q.val, small = p.val;
            if(v <= large && v >= small) {
                res = root;
                break;
            } else if(v > large) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}