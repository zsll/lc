/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root != null) {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer(root);
            while(!q.isEmpty()) {
                TreeNode cur = q.poll();
                if(cur == null) {
                    sb.append("#");
                } else {
                    sb.append(cur.val);
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode res = null;
        if(data != null && data.length() > 0) {
            String [] a = data.split(",");
            TreeNode [] t = new TreeNode[a.length];
            for(int i = 0; i < a.length; i++) {
                String v = a[i];
                if(!v.equals("#")) {
                    t[i] = new TreeNode(Integer.parseInt(v));
                }
            }
            int preNull = 0;
            for(int i = 0; i < t.length; i++) {
                if(t[i] == null) {
                    preNull++;
                } else {
                    t[i].left = t[i * 2 + 1 - 2*preNull];
                    t[i].right = t[i * 2 + 2 - 2*preNull];
                }
            }
            res = t[0];
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));