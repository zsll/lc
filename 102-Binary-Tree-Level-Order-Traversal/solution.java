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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root != null) {
            LinkedList<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            while(q.size() > 0) {
                List<Integer> l = new ArrayList<Integer>();
                LinkedList<TreeNode> next = new LinkedList<TreeNode>();
                for(TreeNode cur : q) {
                    l.add(cur.val);
                    if(cur.left != null) {
                        next.add(cur.left);
                    } 
                    if(cur.right != null) {
                        next.add(cur.right);
                    }
                }
                res.add(l);
                q = next;
            }
        }
        return res;
    }
}