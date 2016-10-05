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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(root != null) {
            LinkedList<TreeNode> q = new LinkedList<TreeNode>();
            int odd = 0;
            q.add(root);
            while(!q.isEmpty()) {
                LinkedList<TreeNode> next = new LinkedList<TreeNode>();
                List<Integer> l = new ArrayList<Integer>();
                for(TreeNode t : q) {
                    if(odd%2 == 0) {
                        l.add(t.val);
                    } else {
                        l.add(0, t.val);
                    }
                    if(t.left != null) {
                        next.add(t.left);
                    }
                    if(t.right != null) {
                        next.add(t.right);
                    }
                    
                }
                odd++;
                res.add(l);
                q = next;
            }
        }
        return res;
    }
}