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
    public List<List<Integer>> verticalOrder(TreeNode root) {  
    	List<List<Integer>> res = new ArrayList<>();
    	if(root != null) {
	    Queue<TreeNode> q = new LinkedList<TreeNode>();
	    Queue<Integer> q2 = new LinkedList<Integer>();
	    q.offer(root);
	    q2.offer(0);
	    HashMap<Integer, List<Integer>> h = new HashMap<Integer, List<Integer>>();
	    int maxL = 0, minL = 0;
	    while(!q.isEmpty()) {
	        TreeNode n = q.poll();
	        int level = q2.poll();
	        if(!h.containsKey(level)) {
	            h.put(level, new ArrayList<Integer>());
	            maxL = Math.max(maxL, level);
	            minL = Math.min(minL, level);
	        }
	        h.get(level).add(n.val);
	        if(n.left != null) {
	            q.offer(n.left);
	            q2.offer(level - 1);
	        }
	        if(n.right != null) {
	            q.offer(n.right);
	            q2.offer(level + 1);
	        }
	    }
	    for(int i = minL; i <= maxL; i++) {
	        res.add(h.get(i));
	    }
}
	    return res;
    }
}