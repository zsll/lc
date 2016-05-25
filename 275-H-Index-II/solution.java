public class Solution {
    public int hIndex(int[] citations) {
        int r = 0;
    	if(citations != null && citations.length > 0) {
    		int l = citations.length;
    		int start = 0, end = l - 1;
    		while(start <= end) {
    			int mid = (start + end)/2;
    			int articleNum = l - mid;
    			if(articleNum > citations[mid]) {	//This is not a valid h index, and valid h is on right

    				start = mid + 1;	//for left is not possible
    			} else {	//articleNum <= citations[mid]  articleNum is valid h, will need to find larger article, which is on left
    	    		r = articleNum;
    				end = mid - 1;
    			}
    		}
    	}
    	return r;
    }
}