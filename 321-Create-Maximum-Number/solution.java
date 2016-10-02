public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int [] res = new int[k];
        for(int i = 0; i <= k; i++) {    //pick i numbers from one, pick k - i numbers from the other
            int [] a1 = pick(nums1, i);
            int [] a2 = pick(nums2, k - i);
            if(a1 != null && a2 != null) {
                int [] a3 = merge(a1, a2);
                if(compare(res, a3) < 0) {
                    res = a3;
                }
            }
        }
        return res;
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
                } else if(i + k == l1) {
                    /** Special handling when equals, needs to go to next unequal pos,
                     * we should move the unfinished
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
                    res[i + j] = a2[j++];
                } else {
                    res[i + j] = a1[i++];
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