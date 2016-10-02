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
            if(root.left == null && root.right == null) {
                res.add(root.val + "");
            } else {
                List<String> l = binaryTreePaths(root.left);
                for(String s : l) {
                    res.add(root.val + "->" + s);
                }
                List<String> r = binaryTreePaths(root.right);
                for(String s : r) {
                    res.add(root.val + "->" + s);
                }
            }
        }
        return res;
    }
}