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
        if(root == null){  //NoteNote
		            return;  
		        }  
		          
		        // 左节点非空，连接右节点  
		        if(root.left != null){  //NoteNote: Since this is a perfect binary tree
		            root.left.next = root.right;  

			        //NoteNote: 借助root.next处理5连6的情况  
			        if(root.next!=null){  
			            root.right.next = root.next.left;  
			        } 
		        }  
		           
		          
		        connect(root.right);
		        connect(root.left);  
    }
}