public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int res = 0;
        if(envelopes != null && envelopes.length > 0) {
            Arrays.sort(envelopes, new Comparator<int []>() {
                public int compare(int [] a, int [] b) {
                	if(a[0] != b[0]) {
                		return a[0] - b[0];
                	} else {
                		return b[1] - a[1];
                	}
                }
            });
            int len = envelopes.length;
            int [] b = new int[len + 1];	//b i is the smallest number that a lis of length i can be
            //we can easily prove that this array is ascending
            b[++res] = envelopes[0][1];
            for(int i = 1; i < len; i++) {
            	if(b[res] < envelopes[i][1]) {
            		b[++res] = envelopes[i][1];
            	} else {
            		int toUpdate = findFirstGTIndex(b, res, envelopes[i][1]);
            		b[toUpdate] = envelopes[i][1];
            	}
            }
        }
        return res;
    }
    
    int findFirstGTIndex(int [] b, int end, int target) {
    	int start = 0;
    	while(start <= end) {
    		int mid = (end - start >> 1) + start;
    		if(b[mid] >= target) {
    			end = mid - 1;
    		} else {
    			start = mid + 1;
    		}
    	}
    	return start;
    }
}