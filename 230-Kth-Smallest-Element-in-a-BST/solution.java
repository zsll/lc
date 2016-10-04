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
        if(root != null) {
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(root);
            pushLeft(s);
            int count = 0;
            while(!s.empty()) {
                TreeNode cur = s.pop();
                count++;
                if(count == k) {
                    res = cur.val;
                    break;
                }
                if(cur.right != null) {
                    s.push(cur.right);
                    pushLeft(s);
                }
            }
        }
        return res;
    }
    
    void pushLeft(Stack<TreeNode> s) {
        while(s.peek().left != null) {
            s.push(s.peek().left);
        }
    }
}