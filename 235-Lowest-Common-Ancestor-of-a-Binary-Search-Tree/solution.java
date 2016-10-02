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
        while(root != null) {
            if(root.val >= p.val && root.val <= q.val) {
                break;
            } else if (root.val > q.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}