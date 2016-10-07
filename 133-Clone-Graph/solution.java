/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode res = null;
        if(node != null) {
            HashMap<UndirectedGraphNode, UndirectedGraphNode> h = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
            Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
            res = new UndirectedGraphNode(node.label);
            h.put(node, res);
            q.offer(node); 
            while(!q.isEmpty()) {
                UndirectedGraphNode cur = q.poll();
                for(UndirectedGraphNode n : cur.neighbors) {
                    if(h.containsKey(n)) {
                        h.get(cur).neighbors.add(h.get(n));
                    } else {
                        UndirectedGraphNode newN = new UndirectedGraphNode(n.label);
                        h.get(cur).neighbors.add(newN);
                        h.put(n, newN);
                        q.offer(n);
                    }
                }
            }
        }
        return res;
    }
}