public class Solution {
    public int hIndex(int[] citations) {
        int res = 0;
        if(citations != null && citations.length > 0) {
            int start = 0, end = citations.length - 1;
            while(start <= end) {
                int mid = start + (end - start >>1);
                int articleNumberThatHasMoreCi = citations.length - mid;    //how many articles has more ci than citations[mid]
                /*
                "A scientist has index h if h of his/her N papers have at least h citations each, 
and the other N − h papers have no more than h citations each."
                */
                if(articleNumberThatHasMoreCi > citations[mid]) {  //invalid case, see example below
                    start = mid + 1;
                } else {    //articleNumberThatHasMoreCi >= citations[mid]
                    end = mid - 1;
                }
                res = citations.length - start;
            }
        }
        return res;
    }
    
     /**
      * 1 1 2 100
      * 
      * answer should be 2
      */
}