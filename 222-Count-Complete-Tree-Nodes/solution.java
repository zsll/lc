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
    public int countNodes(TreeNode root) {
        int res = 0;
        if(root != null) {
            int lHeight = leftHeight(root.left), rHeight = rightHeight(root.right);
            if(lHeight == rHeight) {
                res = (int)Math.pow(2, lHeight + 1) - 1;
            } else {
                res = countNodes(root.left) + countNodes(root.right) + 1;
            }
        }
        return res;
    }
    
    public int leftHeight(TreeNode root) {
        int res = 0;
        while(root != null) {
            root = root.left;
            res++;
        }
        return res;
    }
    
    public int rightHeight(TreeNode root) {
        int res = 0;
        while(root != null) {
            root = root.right;
            res++;
        }
        return res;
    }
}