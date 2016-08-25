public class Solution {
    public int majorityElement(int[] a) {
        int m = a[0], count = 1;
        for(int i = 1; i < a.length; i++) {
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