/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> s = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = s.pop();
        pushLeft(res.right);
        return res.val;
    }
    
    void pushLeft(TreeNode n) {
        while(n != null) {
            s.push(n);
            n = n.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */