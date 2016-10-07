public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        if(nums1 != null && nums2 != null) {
            /**
             * Len might be 0
             * Submission Result: Wrong Answer More Details 

Input:
[]
[1]
Output:
0.00000
Expected:
1.00000*/
            int total = nums1.length + nums2.length;
            res = find(nums1, nums2, 0, nums1.length - 1, 0, nums2.length -1, total/2 + 1);
            if(total%2 == 0) {
                double res1 = find(nums1, nums2, 0, nums1.length - 1, 0, nums2.length -1, total/2);
                res = (res + res1)/2;
            }
        }
        return res;
    }
    
    public double find(int [] nums1, int [] nums2, int start1, int end1, int start2, int end2, int k) {
        if(start1 > end1) {
            return nums2[start2 + k - 1];
        }
        if(start2 > end2) {
            return nums1[start1 + k - 1];
        }
        int mid1 = (end1 + start1)/2, mid2 = (end2 + start2)/2;
        int first1 = mid1 - start1 + 1, first2 = mid2 - start2 + 1;
        int firstHalfLen = first1 + first2;
        if(first1 + first2 == k) {
            if(nums1[mid1] == nums2[mid2]) {
                return nums1[mid1];
            } else if(nums1[mid1] > nums2[mid2]) {
                return find(nums1, nums2, start1, end1, mid2 + 1, end2, k - first2);
            } else {
                return find(nums1, nums2, mid1 + 1, end1, start2, end2, k - first1);
            }
        } else if (first1 + first2 < k) {
            if(nums1[mid1] == nums2[mid2]) {
                return find(nums1, nums2, mid1 + 1, end1, mid2 + 1, end2, k - first2 - first1);
            } else if(nums1[mid1] > nums2[mid2]) {
                return find(nums1, nums2, start1, end1, mid2 + 1, end2, k - first2);
            } else {
                return find(nums1, nums2, mid1 + 1, end1, start2, end2, k - first1);
            }
        } else {
            if(nums1[mid1] == nums2[mid2]) {
                return find(nums1, nums2, start1, end1 - 1, start2, mid2 - 1, k);
            } else if(nums1[mid1] > nums2[mid2]) {
                return find(nums1, nums2, start1, mid1 - 1, start2, end2, k);
            } else {
                return find(nums1, nums2, start1, end1, start2, mid2 - 1, k);
            }
        }
    }
}