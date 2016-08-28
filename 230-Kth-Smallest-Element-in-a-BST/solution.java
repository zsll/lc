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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0, res = -1;
        if(root != null) {
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(root);
            boolean pushLeft = true;
            while(!s.empty()) {
                while(pushLeft && s.peek().left != null) {
                    s.push(s.peek().left);
                }
                pushLeft = false;
                TreeNode c = s.pop();
                res = c.val;
                count++;
                if(count == k) {
                    break;
                }
                if(c.right != null) {
                    s.push(c.right);
                    pushLeft = true;
                }
            }
        }
        return res;
    }
}