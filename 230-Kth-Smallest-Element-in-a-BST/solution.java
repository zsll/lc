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
        int res = -1;
        if(root != null && k > 0) {
            Stack<TreeNode> s = new Stack<TreeNode>();
            pushLeft(s, root);
            int count = 0;
            while(!s.empty()) {
                TreeNode cur = s.pop();
                res = cur.val;
                count++;
                if(count == k) {
                    break;
                }
                if(cur.right != null) {
                    pushLeft(s, cur.right);
                }
            }
        }
        return res;
    }
    
    void pushLeft(Stack<TreeNode> s, TreeNode root) {
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }
}