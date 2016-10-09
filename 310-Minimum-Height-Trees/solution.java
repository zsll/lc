public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if(n > 0 && edges != null) {// && edges.length > 0) { NoteNote this is not necessary
            HashMap<Integer, HashSet<Integer>> h = new HashMap<Integer, HashSet<Integer>>();
            for(int [] e : edges) {
                int a = e[0], b= e[1];
                if(!h.containsKey(a)) {
                    h.put(a, new HashSet<Integer>());
                }
                if(!h.containsKey(b)) {
                    h.put(b, new HashSet<Integer>());
                }
                h.get(a).add(b);
                h.get(b).add(a);
            }
            LinkedList<Integer> q = new LinkedList<Integer>();
            HashSet<Integer> v = new HashSet<Integer>();
            for(int i = 0; i < n; i++) {
                v.add(i);   //To be visited
            }
            /**
                         * Submission Result: Wrong Answer More Details 
    
    Input:
    1
    []
    Output:
    []
    Expected:
    [0]
    NoteNote can't return
    */
            if(v.size() > 2) {  //To be visited
                for(int i = 0; i < n; i++) {
                    if(!h.containsKey(i)) {
                        return res; 
                    }
                    if(h.get(i).size() == 1) {
                        q.offer(i);
                        v.remove(i);
                    }
                }
            
                while(v.size() > 2) {   //NoteNote, so it's not root yet
                    int size = q.size();    //NoteNote, have to use level by level traversal
                    for(int j = 0; j < size; j++) {
                        int cur = q.poll();
                        int onlyNei = h.get(cur).iterator().next();
                        h.get(cur).remove(onlyNei);
                        h.get(onlyNei).remove(cur);
                        if(h.get(onlyNei).size() == 1) {
                            q.offer(onlyNei);
                            v.remove(onlyNei);
                        }
                    }
                }
            }
            for(int i : v) {
                res.add(i);
            }
        }
        return res;
    }
    
}