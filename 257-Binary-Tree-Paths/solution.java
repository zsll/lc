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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root != null) {
            List<String> l = binaryTreePaths(root.left);
            List<String> r = binaryTreePaths(root.right);
            for(String s : l) {
                res.add(root.val + "->" + s);
            }
            for(String s : r) {
                res.add(root.val + "->" + s);
            }
            if(res.size() == 0) {
                res.add(root.val + "");
            }
        }
        return res;
    }
}