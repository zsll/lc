public class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int aL = a != null? a.length : 0;
    	int bL = b != null? b.length :0;
    	if((aL + bL)%2 > 0) {
    		return kthSmallestSum(a, b, (aL + bL)/2 + 1);
    	} else {
    		int t1 = kthSmallestSum(a, b, (aL + bL)/2 );
    		int t2 = kthSmallestSum(a, b, (aL + bL)/2 + 1);
    		return (double)(t1 + t2)/2;//NoteNote convert
    	}
    }
    
    
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
    	int result = 0;
    	if(A != null && B != null && A.length + B.length >= 0 && k <= A.length + B.length) {
    		result = kthSmallestSumHelper(A, B, k, 0, A.length - 1, 0, B.length - 1);
    	}
    	return result;
    }
    
    public int kthSmallestSumHelper(int[] a, int[] b, int k, int aStart, int aEnd, int bStart, int bEnd) {
        // Write your code here
    	if(aStart > aEnd) {
    		return b[bStart + k - 1];
    	}
    	if(bStart > bEnd) {
    		return a[aStart + k - 1];
    	}
    	int aMid = (aEnd - aStart)/2 + aStart;
    	int bMid = (bEnd - bStart)/2 + bStart;
    	
    	int firstHalfLen = (aMid - aStart + 1) + (bMid - bStart + 1);
    	
    	if(k == 1) {
    	    return Math.min(a[aStart], b[bStart]);
    	}
    	
    	if (k == firstHalfLen) {
    		if(a[aMid] == b[bMid]) {
    			return a[aMid];
    		} else if(a[aMid] > b[bMid]) {
    			return kthSmallestSumHelper(a, b, k - (bMid - bStart + 1 ), aStart, aMid, bMid + 1, bEnd);
    		} else {
    			return kthSmallestSumHelper(a, b, k - (aMid - aStart + 1 ), aMid + 1, aEnd, bStart, bMid);
    		}
    	} else if(k < firstHalfLen) {
    		if(a[aMid] == b[bMid]) {
    			return kthSmallestSumHelper(a, b, k, aStart, aMid - 1, bStart, bMid - 1);
    		} else if(a[aMid] > b[bMid]) {
    			return kthSmallestSumHelper(a, b, k, aStart, aMid - 1, bStart, bEnd);
    		} else {
    			return kthSmallestSumHelper(a, b, k, aStart, aEnd, bStart, bMid - 1);
    		}	
    	} else {
    		if(a[aMid] == b[bMid]) {
    			return kthSmallestSumHelper(a, b, k - firstHalfLen, aMid + 1, aEnd, bMid + 1, bEnd);
    		} else if(a[aMid] > b[bMid]) {
    			return kthSmallestSumHelper(a, b, k - (bMid - bStart + 1), aStart, aEnd, bMid + 1, bEnd);
    		} else {
    			return kthSmallestSumHelper(a, b, k - (aMid - aStart + 1), aMid + 1, aEnd, bStart, bEnd);
    		}
    	}
    }
}