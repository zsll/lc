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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> l = new ArrayList<Integer>();
        if(root != null && k > 0) {
            Stack<TreeNode> predecessorStack = new Stack<TreeNode>();
            Stack<TreeNode> successorStack = new Stack<TreeNode>();
            while(root != null) {
                if((double)root.val == target) {
                    /**
                     * Submission Result: Wrong Answer More Details 

Input:
[3,2,4,1]
2.000000
3
Output:
[2,3,4]
Expected:
[2,1,3]*/
                    successorStack.push(root);
                    predecessorStack.push(root);
                    break;
                } else if(root.val > target) {
                    successorStack.push(root);
                    root = root.left;
                } else {
                    predecessorStack.push(root);
                    root = root.right;
                }
            }
            while(k > 0 && !predecessorStack.empty() && !successorStack.empty()) {
                if(target - predecessorStack.peek().val == 0.0 && successorStack.peek().val - target == 0.0) {
                    TreeNode n = predecessorStack.pop();
                    pushRight(predecessorStack, n.left);
                    n = successorStack.pop();
                    pushLeft(successorStack, n.right);
                    l.add(0, n.val);
                } else if(target - predecessorStack.peek().val < successorStack.peek().val - target) {//NoteNote, merge
                    TreeNode n = predecessorStack.pop();
                    pushRight(predecessorStack, n.left);
                    l.add(0, n.val);
                } else {
                    TreeNode n = successorStack.pop();
                    pushLeft(successorStack, n.right);
                    l.add(n.val);
                }
                k--;
            }
            while(k > 0 && !predecessorStack.empty()) {
                TreeNode n = predecessorStack.pop();
                pushRight(predecessorStack, n.left);
                l.add(0, n.val);
                k--;
            }
            
            while(k > 0 && !successorStack.empty()) {
                TreeNode n = successorStack.pop();
                pushLeft(successorStack, n.right);
                l.add(n.val);
                k--;
            }
        }
        return l;
    }
    
    void pushLeft(Stack<TreeNode> s, TreeNode r) {
        while(r != null) {
            s.push(r);
            r = r.left;
        }
    }
    
    void pushRight(Stack<TreeNode> s, TreeNode r) {
        while(r != null) {
            s.push(r);
            r = r.right;
        }
    }
}