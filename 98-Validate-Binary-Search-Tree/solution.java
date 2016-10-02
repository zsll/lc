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
    public boolean isValidBST(TreeNode root) {
        boolean res = true;
        Integer pre = null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(root != null) {
            s.push(root);
            root = root.left;
        }
        while(!s.empty()) {
            TreeNode cur = s.pop();
            if(pre != null && cur.val <= pre) {
                res = false;
                break;
            } else {
                pre = cur.val;
            }
            root = cur.right;
            while(root != null) {
                s.push(root);
                root = root.left;
            }
        }
        return res;
    }
}