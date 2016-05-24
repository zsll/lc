public class Solution {
    public int search(int[] A, int target) {
        		if (A == null || A.length == 0)
			return -1;
		int l = 0;
		int r = A.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (A[m] == target)
				return m;
			if (A[m] > A[l]) {
				if (A[m] > target && A[l] <= target) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else if (A[m] < A[l]) {
				if (A[m] < target && A[r] >= target) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			} else if (A[m] > A[r]) {
				if (A[m] > target && A[l] <= target) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else if (A[m] < A[r]) {
				if (A[m] < target && A[r] >= target) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			} else {
			    l++;
			    r--;
			}
		}
		return -1;
    }
}