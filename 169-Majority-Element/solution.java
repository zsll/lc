public class Solution {
    public int majorityElement(int[] a) {
        int m = a[0], count = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] == m) {
                count++;
            } else {
                if(count == 1) {
                    m = a[i];
                } else {
                    count--;
                }
            }
        }
        return m;
    }
}