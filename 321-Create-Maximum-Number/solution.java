public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
            int[] res1 = solve(nums1, i);
            int[] res2 = solve(nums2, k - i);
            int[] res = new int[k];
            int pos1 = 0, pos2 = 0, tpos = 0;

            while (pos1 < res1.length || pos2 < res2.length) {
                res[tpos++] = compare(res1, pos1, res2, pos2) ? res1[pos1++] : res2[pos2++];
            }

            if (!compare(ans, 0, res, 0))
                ans = res;
        }

        return ans;
    }

    /**
     * NoteNote 9 8 7 > 1 2
     * 4 5 < 4 5 1
     * @param nums1
     * @param start1
     * @param nums2
     * @param start2
     * @return
     */
    public boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
        for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
            if (nums1[start1] > nums2[start2]) return true;
            if (nums1[start1] < nums2[start2]) return false;
        }
        return start1 != nums1.length;
    }
    int compare(int [] a1, int [] a2) {
        int i = 0;
        int l1 = a1.length, l2 = a2.length;
        while(i < l1 && i < l2 && a1[i] == a2[i]) {
            i++;
        }
        if(i < l1 && i < l2) {
            return a1[i] - a2[i];
        } else if(i == l1) {
            return -1;
        } else {
            return 1;
        }
    }
    public int[] solve(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && //Can minus
            		len - 1 + nums.length - i >= k && //remaining number plus existing len can compose a total length of K
            		res[len - 1] < nums[i]) {	//can pick up current number
                len--;
            }
            if (len < k)
                res[len++] = nums[i];
        }
        return res;
    }
    
    int [] merge(int [] a1, int [] a2) {
        int l1 = a1.length, l2 = a2.length;
        int [] res = new int[l2 + l1];
        int i = 0, j = 0;
        while(i < l1 && j < l2) {
            if(a1[i] < a2[j]) {
                res[i + j] = a2[j++];
            } else if(a1[i] > a2[j]) {
                res[i + j] = a1[i++];
            } else {
                int k = 1;
                while(i + k < l1 && j + k < l2 && a1[i + k] == a2[j + k]) {
                    k++;
                }
                if(i + k < l1 && j + k < l2) {
                    if(a1[i+k] < a2[j+k]) {
                        res[i + j] = a2[j++];
                    } else {
                        res[i + j] = a1[i++];
                    }
                } else if(i + k == l1 && j+k < l2 && a1[i] > a2[j+k] 
                    || j + k == l2 && i + k < l1 && a2[j] < a1[i+k]) {
                    /** Special handling when equals, needs to go to next unequal pos,
                     * if next that position is end, consider the following case
                     * 9 0
                     * 9
                     * since 9 is larger than 0, we should advance second
                     * 
                     * but if it's
                     * 1 8
                     * 1
                     * 
                     * we should advance first
                     * 
                     * Submission Result: Wrong Answer More Details 

Input:
[2,5,6,4,4,0]
[7,3,8,0,6,5,7,6,2]
15
Output:
[7,3,8,2,5,6,4,4,0,0,6,5,7,6,2]
Expected:
[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]
*/
                    res[i + j] = a1[i++];
                } else {
                    res[i + j] = a2[j++];
                }
            }
        }
        while(i < l1) {
            res[i + j] = a1[i++];
        }
        while(j < l2) {
            res[i + j] = a2[j++];
        }
        return res;
    }
    //from just one array, pick up k numbers to form a large number
    int [] pick(int [] a, int k) {
        if(k > a.length) {
            return null;
        }
        
        int [] res = new int[k];
        int prePickedPos = -1, len = a.length;
        for(int i = 0; i < k; i++) {
            int maxPos = prePickedPos + 1;
            for(int j = prePickedPos + 2; len - j >= k - i; j++) {
                if(a[j] > a[maxPos]) {
                    maxPos = j;
                }
            }
            res[i] = a[maxPos];
            prePickedPos = maxPos;
        }
        return res;
    }
}