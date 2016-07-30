public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 != null && nums1.length > 0 && nums2 != null && nums2.length > 0 && k > 0) {
            PriorityQueue<PosVal2> q = new PriorityQueue<PosVal2>(10, new Comparator<PosVal2>() {
                @Override
                public int compare(PosVal2 a, PosVal2 b) {
                    return Integer.compare(a.val, b.val);
                }
            });
            HashSet<Integer> visited = new HashSet<Integer>();
            PosVal2 cur = new PosVal2(0, 0, nums1[0] + nums2[0]);
            q.offer(cur);
            int width = nums2.length;
            visited.add(encodePos(0,0,width));
            for(int i = 0; i < k; i++) {
                PosVal2 min = q.poll();
                if(min == null) {
                    break;  //NoteNote
                }
                int[] t = new int[2];
                t[0] = nums1[min.row];
                t[1] = nums2[min.col];
                res.add(t);
                if(min.row + 1 < nums1.length && !visited.contains(encodePos(min.row + 1, min.col, width))) {
                    cur = new PosVal2(min.row + 1, min.col, nums1[min.row + 1] + nums2[min.col]);
                    q.offer(cur);
                    visited.add(encodePos(min.row + 1, min.col, width));
                }
                if(min.col + 1 < nums2.length && !visited.contains(encodePos(min.row , min.col + 1, width))) {
                    cur = new PosVal2(min.row , min.col + 1, nums1[min.row ] + nums2[min.col + 1]);
                    q.offer(cur);
                    visited.add(encodePos(min.row, min.col + 1, width));
                }
            }
        }
        return res;
    }
    
    int encodePos(int row, int col, int width) {
        return row*width + col;
    }
    
    class PosVal2 {
        int row, col, val;
        public PosVal2(int i, int j, int val) {
            this.row = i;
            this.col = j;
            this.val = val;
        }
        
        
    }
}