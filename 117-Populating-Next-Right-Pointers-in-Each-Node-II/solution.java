/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root != null) {
            if(root.left != null) {
                if(root.right != null) {
                    root.left.next = root.right;
                } else {
                    TreeLinkNode next = root.next;
                    while(next != null) {
                        if(next.left != null) {
                            root.left.next = next.left;
                            break;
                        } else if(next.right != null) {
                            root.left.next = next.right;
                            break;
                        } else {
                            next = next.next;
                        }
                    }
                }
            }
            if(root.right != null) {
                TreeLinkNode next = root.next;
                while(next != null) {
                    if(next.left != null) {
                        root.right.next = next.left;
                        break;
                    } else if(next.right != null) {
                        root.right.next = next.right;
                        break;
                    } else {
                        next = next.next;
                    }
                }
            }
            
            connect(root.right);//NoteNote, reverse the order it would be wrong
            connect(root.left);
        }
    }
}