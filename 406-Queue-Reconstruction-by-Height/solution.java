public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = people;
        if(people != null && people.length > 0 && people[0].length == 2) {
            List<int []> l = new ArrayList<int []>();
            PriorityQueue<int []> q = new PriorityQueue<int []>(10, new Comparator<int []>() {
                public int compare(int [] a, int [] b) {
                    if(a[0] != b[0]) {
                        return b[0] - a[0];
                    } else {
                        return a[1] - b[1];
                    }
                }
            });
            for(int [] p : people) {
                q.offer(p);
            }
            while(!q.isEmpty()) {
                int [] a = q.poll();
                l.add(a[1], a);
            }
            for(int i = 0; i < l.size(); i++) {
                res[i] = l.get(i);
            }
        }
        return res;
    }
}