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
    public int maxDepth(TreeNode root) {
        int res = 0;
        if(root != null) {
            int l = maxDepth(root.left), r = maxDepth(root.right);
            res = Math.max(l, r) + 1;
        }
        return res;
    }
}