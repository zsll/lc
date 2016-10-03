public class Solution {
    public int hIndex(int[] citations) {
        //"A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
        int res = 0;
        if(citations != null && citations.length > 0) {
            int len = citations.length;
            int [] h = new int[len + 1];    //0 - len. That is the range of h index
            for(int i : citations) {
                int c = Math.min(i, len);
                h[c]++;
            }
            int pre = 0;
            for(int i = len; i >= 0; i--) {
                if(h[i] + pre >= i) {
                    res = i;
                    break;
                }
                pre += h[i];
            }
        }
        return res;
    }
}