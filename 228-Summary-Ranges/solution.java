public class Solution {
    public List<String> summaryRanges(int[] a) {
        List<String> res = new ArrayList<String>();
        if(a != null && a.length > 0) {
            int s = 0;
            int i = 0;
            for(i = 1; i < a.length; i++) {
                if(a[i] > a[i - 1] + 1) {
                    res.add(generateS(a[s], a[i - 1]));
                    s = i;
                }
            }
            res.add(generateS(a[s], a[i - 1]));
        }
        return res;
    }
    
    String generateS(int a, int b) {
        if(a == b) {
            return Integer.toString(a);
        } else {
            return a + "->" + b;
        }
    }
}