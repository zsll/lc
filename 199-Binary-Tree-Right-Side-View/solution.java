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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<Integer>();
        if(root != null) {
            LinkedList<TreeNode> l = new LinkedList<TreeNode>();
            l.add(root);
            while(l.size() > 0) {
                LinkedList<TreeNode> next = new LinkedList<TreeNode>();
                for(int i = 0; i < l.size(); i++) {
                    TreeNode c = l.get(i);
                    if(i == l.size() - 1) {
                        res.add(c.val);
                    }
                    if(c.left != null) {
                        next.add(c.left);
                    }
                    if(c.right != null) {
                        next.add(c.right);
                    }
                }
                l = next;
            }
        }
        return res;
    }
}