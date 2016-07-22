public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int [] res = new int[0];
        if(nums1 != null && nums1.length > 0 
        &&nums2 != null && nums2.length > 0) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> l = new ArrayList<Integer>();
            int i = 0, j = 0;
            while(i < nums1.length && j < nums2.length) {
                if(nums1[i] == nums2[j]) {
                    if(l.size() == 0 || l.get(l.size() - 1) < nums1[i]) {//NoteNote Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
                        l.add(nums1[i]);
                    }
                    i++;
                    j++;
                } else if(nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }
                
            }
            res = new int[l.size()];
            for(int k = 0; k < l.size(); k++) {
                res[k] = l.get(k);
            }
        }
        return res;
    }
}