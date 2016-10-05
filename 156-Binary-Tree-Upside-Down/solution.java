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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode res = root;
        if(root != null && root.left != null) {
            TreeNode left = root.left, right = root.right;
            res = upsideDownBinaryTree(left);
            root.left = null;
            root.right = null;
            left.left = right;
            left.right = root;
        }
        return res;
    }
}