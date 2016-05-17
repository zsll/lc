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
        TreeNode result = null;
        if(root != null) {
            if(p.val > q.val) {
                result = lowestCommonAncestor(root, q, p);
            } else if (p.val <= root.val && root.val <= q.val) {
                result = root;
            } else if (root.val > q.val) {
                result = lowestCommonAncestor(root.left, p, q);
            } else {
                result = lowestCommonAncestor(root.right, p, q);
            }
        }
        return result;
    }
}