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
    public boolean isSymmetric(TreeNode root) {
        boolean res = true;
        if(root != null) {
            LinkedList<TreeNode> lQ = new LinkedList<TreeNode>();
            LinkedList<TreeNode> rQ = new LinkedList<TreeNode>();
            lQ.add(root);
            rQ.add(root);
            while(!lQ.isEmpty() && res) {
                LinkedList<TreeNode> lQNext = new LinkedList<TreeNode>();
                LinkedList<TreeNode> rQNext = new LinkedList<TreeNode>();
                while(!lQ.isEmpty() && !rQ.isEmpty()) {
                    TreeNode lCur = lQ.remove(), rCur = rQ.remove();
                    if((lCur == null && rCur == null) || (lCur != null && rCur != null) && (lCur.val == rCur.val)) {
                        if(lCur != null && rCur != null) {
                            lQNext.add(lCur.left);
                            lQNext.add(lCur.right);
                            rQNext.add(rCur.right);
                            rQNext.add(rCur.left);
                        }
                    } else {
                        res = false;
                        break;
                    }
                }
                lQ = lQNext;
                rQ = rQNext;
            }
        }
        return res;
    }
}