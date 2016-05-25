public class Solution {
    public int hIndex(int[] citations) {
       int res = 0;
    	if(citations != null && citations.length > 0) {
    		int len = citations.length;
    		int [] cnt = new int[len + 1];
    		for(int i = 0; i < len; i++) {
    			int index = citations[i] > len ? len : citations[i];
    			cnt[index]++;
    		}
    		int artNum = 0;
    		for(int i = len; i >= 0; i--) {
    			artNum += cnt[i];
    			if(artNum < i) {
    				;//res = artNum;	//Not needed
    			} else { //from i, artNum >= i, So we know there are at least i articles cited i times or higher
    				res = i;
    				break;
    			}
    		}
    	}
    	return res;
    }
}