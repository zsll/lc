public class Solution {
    public int countPrimes(int n) {
        int res = 0;
        if(n > 1) {
            //res = 0; 1 is not a prime?
            int [] p = new int[n];
            
            for(int i = 2; i <= Math.sqrt(n); i++) {
                int count = 2;
                while(i*count < n) {
                    p[i*count] = 1;
                    count++;
                }
            }
            
            for(int i = 2; i < n; i++) {
                if(p[i] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}