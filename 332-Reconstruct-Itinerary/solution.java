public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets != null && tickets.length > 0 && tickets[0].length == 2) {
            HashMap<String, PriorityQueue<String>> m = build(tickets);
            dfs("JFK", m, res);
        }
        return res;
    }
    
    void dfs(String start, HashMap<String, PriorityQueue<String>> m, List<String> res) {
        if(m.containsKey(start)) {
            while(!m.get(start).isEmpty()) {
                String next = m.get(start).poll();
                dfs(next, m, res);
            }
        }
        res.add(0, start);
    }
    
    HashMap<String, PriorityQueue<String>> build(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> res = new HashMap<String, PriorityQueue<String>>();
        for(String [] t : tickets) {
            String from = t[0], to = t[1];
            if(!res.containsKey(from)) {
                res.put(from, new PriorityQueue<String>());
            }
            res.get(from).offer(to);
        }
        return res;
    }
}