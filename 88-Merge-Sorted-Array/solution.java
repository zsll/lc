public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[m - i - 1] >= nums2[n - j - 1]) {
                nums1[m + n - (i + j) - 1] = nums1[m - i - 1];
                i++;
            } else {
                nums1[m + n - (i + j) - 1] = nums2[n - j - 1];
                j++;
            }
        }
        while(i < m) {
            nums1[m + n - (i + j) - 1] = nums1[m - i - 1];
            i++;
        }
        while(j < n) {
            nums1[m + n - (i + j) - 1] = nums2[n - j - 1];
            j++;
        }
    }
}