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
    public int longestConsecutive(TreeNode root) {
        int [] max = {0};
        if(root != null) {
            helperFromRoot(root, max, true);
            //helperFromRoot(root, max, false);
        }
        return max[0];
    }
    
    public int helperFromRoot(TreeNode root, int [] max, boolean desc) {
        int res = 0;
        if(root != null) {
            res = 1;
            int diff = desc ? 1 : -1;
            int l = helperFromRoot(root.left, max, desc);;
            if(root.left != null && root.left.val == root.val + diff) {
                res = 1 + l;
            }
            int r = helperFromRoot(root.right, max, desc);
            if(root.right != null && root.right.val == root.val + diff) {
                res = Math.max(1 + r, res);
            }
            max[0] = Math.max(max[0], res);
        }
        return res;
    }
}