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
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode res = null;
        if(data.length() > 0) {
            String [] val = data.split(",");
            int len = val.length;
            TreeNode [] a = new TreeNode[len];
            for(int i = 0; i < len; i++) {
                a[i] = null;
                if(!val[i].equals("#")) {
                    a[i] = new TreeNode(Integer.parseInt(val[i]));
                }
            }
            int preNull = 0;
            res = a[0];
            for(int i = 0; i < len; i++) {
                if(a[i] == null) {
                    preNull++;
                } else {
                    a[i].left = a[i*2 + 1 - 2*preNull];
                    a[i].right = a[i*2 + 2 - 2*preNull];
                }
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));