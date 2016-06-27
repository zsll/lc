public class Solution {
    public int hIndex(int[] citations) {
     int r = 0;
    	//if(citations != null && citations.length > 0) {
    		int l = citations.length;
    		int start = 0, end = l - 1;
    		//To find first max article number so that article number is smaller than or equal to citation:
    		/**
    		 *Note that when hIndexAscendingOrder, article number that is larger than i is in descending order
    		 *The citations is ascending
0 1 3 5 6
While the article number is descending
The articles larger than or equal to 0 (c[i]) is 5, 
larger than or equal to 1 (c[i]) is 4,
larger than or equal to 3 is 3, 
larger than or equal to 5 is 2,
larger than or equal to 6 is 1

Note that the article number is descending, so there will be a intersection to make sure that citation number is larger than
or equal to article number, and we need to find the max of it
We can let left equals 5 (corresponding index is length 5 minus left), right equals 1 (corresponding index is length 5 minus right)
So when getting mid, we know the article number that is larger than ci[mid] is (5 minus mid)
if ci[mid] >= 5 minus mid, it's a valid candidate
We can try end equals mid minus 1
    		 */
    		while(start <= end) {
    			int mid = (start + end)/2;
    			int articleNum = l - mid;
    			if(articleNum > citations[mid]) {	//This is not a valid h index, and valid h is on right

    				start = mid + 1;	//for left is not possible
    			} else {	//articleNum <= citations[mid]  articleNum is valid h, will need to find larger article, which is on left
    	    		//r = articleNum;
    				end = mid - 1;
    			}
    		}
    	//}
    	return l - start;   
    }
}