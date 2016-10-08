public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 != null && nums2 != null && k > 0 && nums1.length > 0 && nums2.length > 0) {
            PriorityQueue<PosV> pq = new PriorityQueue<PosV>(10, new Comparator<PosV>() {
                public int compare(PosV a, PosV b) {
                    return a.val - b.val;
                }
            });
            HashSet<Integer> v = new HashSet<Integer>();
            int h = nums1.length, w = nums2.length;
            int i = 0, j = 0;
            pq.offer(new PosV(i, j, nums1[i] + nums2[j]));
            v.add(i * w + j);
            while(!pq.isEmpty()) {
                PosV cur = pq.poll();
                int [] p = {nums1[cur.i], nums2[cur.j]};
                res.add(p);
                if(res.size() == k) {
                    break;
                }
                i = cur.i;
                j = cur.j;
                if(i + 1 < h && !v.contains( (i + 1)*w + j)) {
                    pq.offer(new PosV(i + 1, j, nums1[i + 1] + nums2[j]));
                    v.add((i + 1)*w + j);
                }
                if(j + 1 < w && !v.contains( i*w + j + 1)) {
                    pq.offer(new PosV(i, j + 1, nums1[i] + nums2[j + 1]));
                    v.add(i*w + j + 1);
                }
            }
        }
        return res;
    }
    
    class PosV {
        int i, j, val;
        public PosV(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}