public class Solution {
    public List<String> findItinerary(String[][] tickets) {
         LinkedList<String> res = new LinkedList<String>();
         if(tickets != null && tickets.length > 0 && tickets[0].length == 2) {
             HashMap<String, PriorityQueue<String>> m = new HashMap<String, PriorityQueue<String>>();
             for(int i = 0; i < tickets.length; i++) {
                 if(!m.containsKey(tickets[i][0])) {
                     m.put(tickets[i][0], new PriorityQueue<String>());
                 }
                 m.get(tickets[i][0]).offer(tickets[i][1]);
             }
             
             dfs("JFK", m, res);
         }
         return res;
    }
    
    void dfs(String cur, HashMap<String, PriorityQueue<String>> m, LinkedList<String> res) {
        while(m.containsKey(cur) && !m.get(cur).isEmpty()) {
            dfs(m.get(cur).poll(), m, res);
        }
        res.addFirst(cur);
    }
}