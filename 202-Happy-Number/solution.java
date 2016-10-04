public class Solution {
    public boolean isHappy(int n) {
        boolean res = true;
        HashSet<Integer> s = new HashSet<Integer>();
        while(n != 1) {
            if(s.contains(n)) {
                res = false;
                break;
            }
            s.add(n);
            n = sumDigit(n);
        }
        return res;
    }
    
    int sumDigit(int n) {
        int res = 0;
        while(n > 0) {
            int digit = n%10;
            n /= 10;
            res += digit*digit;
        }
        return res;
    }
}