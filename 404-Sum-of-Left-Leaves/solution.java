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
        return dfsWithParent(root, null);
    }
    
    int dfsWithParent(TreeNode cur, TreeNode par) {
        int res = 0;
        if(cur != null) {
            if(cur.left == null && cur.right == null && par != null && par.left == cur) {
                res += cur.val;
            } else {
                res = dfsWithParent(cur.left, cur) + dfsWithParent(cur.right, cur);
            }
        }
        return res;
    }
}