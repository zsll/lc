public class Solution {
    public double myPow(double x, int n) {
        double ans = biPow(x, n);
        if(n < 0) ans = 1/ans;
        return ans;
    }
    
    public double biPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1 || n == -1) return x;
        double ans = biPow(x, n/2);
        if(n % 2 == 0) {
            return ans * ans;
        } else {
            return ans * ans * x;
        }
    } 
}