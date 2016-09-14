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
public String serialize(TreeNode root) {
        // write your code here
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(q.size() > 0) {
            TreeNode c = q.poll();
            if(sb.length() > 0) {
                sb.append(',');
            }
            if(c == null) {
                sb.append('#');
            } else {
                sb.append(c.val);
                q.offer(c.left);
                q.offer(c.right);
            }
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;    //NoteNote
        }
        // write your code here
        String [] sA = data.split(","); //NoteNote, use "", not ''
        int l = sA.length;
        TreeNode [] tA = new TreeNode[l];
        for(int i = 0; i < l; i++) {
            String s = sA[i];
            if(s.equals("#")) {
                tA[i] = null;
            } else {
                tA[i] = new TreeNode(Integer.parseInt(s));
            }
        }
        int preNullNum = 0;
        for(int i = 0; i < l; i++) {
            if( tA[i] == null) {
                preNullNum++;
                continue;
            }
            boolean isLeft = true;
            int leftChildIndex = i*2 + 1 - preNullNum * 2;//NoteNote: have to make a second scan to find children
            int rightChildIndex = i*2 + 2 - preNullNum * 2;
            if(leftChildIndex >= l) {
                break;
            }
            tA[i].left = tA[leftChildIndex];
            if(rightChildIndex >= l) {
                break;
            }
            
            tA[i].right = tA[rightChildIndex];
        }
        return tA[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));