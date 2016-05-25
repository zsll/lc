public class Solution {
    public int hIndex(int[] citations) {
       int res = 0;
        if(citations != null && citations.length > 0) {
        	Arrays.sort(citations);
        	for(int i = citations.length - 1; i >= 0; i--) {
        		int artNum = citations.length - i;
        		if(citations[i] >= artNum) {
        			res = artNum;
        		} else {
        			break;
        		}
        	}
        }
        return res;
    }
}