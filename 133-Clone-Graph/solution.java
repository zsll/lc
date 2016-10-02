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
        UndirectedGraphNode res = node;
        if(node != null) {
            res = new UndirectedGraphNode(node.label);
            HashMap<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
            m.put(node, res);
            Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
            q.offer(node);
            while(!q.isEmpty()) {
                UndirectedGraphNode cur = q.poll();
                for(UndirectedGraphNode n : cur.neighbors) {
                    if(!m.containsKey(n)) {
                        UndirectedGraphNode nClone = new UndirectedGraphNode(n.label);
                        m.put(n, nClone);
                        q.offer(n);
                    }
                    m.get(cur).neighbors.add(m.get(n));
                }
            }
        }
        return res;
    }
}