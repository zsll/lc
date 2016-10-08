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
    public int closestValue(TreeNode root, double target) {
        TreeNode pre = null, suc = null;
        while(root != null) {
            if(target == (double)root.val) {
                return root.val;
            } else if (target < (double)root.val) {
                suc = root;
                root = root.left;
            } else {
                pre = root;
                root = root.right;
            }
        }
        if(pre == null) {
            return suc.val;
        } else if(suc == null) {
            return pre.val;
        } else {
            if(target - pre.val < suc.val - target ) {
                return pre.val;
            } else {
                return suc.val;
            }
        }
    }
}