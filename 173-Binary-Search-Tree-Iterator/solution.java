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

   Stack<TreeNode> s = null;
		//boolean needsToPushLeft = true;
	    public BSTIterator(TreeNode root) {
	    	s = new Stack<TreeNode>();
	        if(root != null) {
	        	s.push(root);
	        	pushLeft();
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !s.empty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	    	int result = -1;
	        if(this.hasNext()) {
	        	TreeNode itr = s.pop();
	        	result = itr.val;
	        	//needsToPushLeft = false;
	        	if(itr.right!=null) {
	        		s.push(itr.right);
	        		//needsToPushLeft = true;

		        	pushLeft();
	        	}
	        } 
	        return result;
	    }

		private void pushLeft() {
			while(s.peek().left != null) {
				s.push(s.peek().left);
			}
		}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */