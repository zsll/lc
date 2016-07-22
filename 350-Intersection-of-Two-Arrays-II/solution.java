public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int [] res = new int[0];    //NoteNote
        if(nums1 != null && nums1.length > 0 
        &&nums2 != null && nums2.length > 0) {
        HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();
        for(int i : nums1) {
            if(!h1.containsKey(i)) {
                h1.put(i, 0);
            }
            int count = h1.get(i);
            h1.put(i, count + 1);
        }
        List<Integer> l = new ArrayList<Integer>();
        
        for(int i : nums2) {
            if(h1.containsKey(i)) {
                l.add(i);
            int count = h1.get(i);
            h1.put(i, count - 1);
            if(h1.get(i) == 0) {
                h1.remove(i);
            }
            }
        }
         res = new int[l.size()];
        for(int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        }
        return res;
    }
}