public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 != null && nums2 != null && nums1.length > 0 && nums2.length > 0 && k > 0) {
            int len1 = nums1.length, len2 = nums2.length;
            PriorityQueue<PosVal> pq = new PriorityQueue<PosVal>(k, new Comparator<PosVal> () {
                 public int compare(PosVal a, PosVal b) {
                     return a.v - b.v;
                 }
                
            });
            HashSet<Integer> v = new HashSet<Integer>();
            PosVal pv = new PosVal(0, 0, nums1, nums2);
            v.add(0);
            pq.offer(pv);
            int count = 0;
            while(pq.size() > 0 && count < k) {
                pv = pq.poll();
                int [] t = {nums1[pv.x], nums2[pv.y]};
                res.add(t);
                if(pv.x + 1 < len1 && !v.contains((pv.x + 1) * len2 + pv.y)) {
                    pq.offer(new PosVal(pv.x + 1, pv.y, nums1, nums2));
                    v.add((pv.x + 1) * len2 + pv.y);
                }
                if(pv.y + 1 < len2 && !v.contains((pv.x) * len2 + pv.y + 1)) {
                    pq.offer(new PosVal(pv.x, pv.y + 1, nums1, nums2));
                    v.add((pv.x) * len2 + pv.y + 1);
                }
                count++;
            }
        }
        return res;
    }
    
    class PosVal {
        int x, y, v;
        public PosVal(int x, int y, int [] nums1, int [] nums2) {
            this.x = x;
            this.y = y;
            this.v = nums1[x] + nums2[y];
        }
    }
}