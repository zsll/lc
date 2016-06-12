public class Solution {
    LinkedList<String> result;
    Map<String, PriorityQueue<String>> mp;
    
    public List<String> findItinerary(String[][] tickets) {
        if (tickets==null || tickets.length==0) return new LinkedList<String>();
        result = new LinkedList<String>();
        mp = new HashMap<String, PriorityQueue<String>>();
        for (String[] ticket : tickets) {
            if (!mp.containsKey(ticket[0])) {
                mp.put(ticket[0], new PriorityQueue<String>());
            }
            mp.get(ticket[0]).offer(ticket[1]);
        }
        dfs("JFK");
        return result;
    }
    
    public void dfs(String cur) {
        while (mp.containsKey(cur) && !mp.get(cur).isEmpty()) {
            dfs(mp.get(cur).poll());
        }
        result.addFirst(cur);
    }
}