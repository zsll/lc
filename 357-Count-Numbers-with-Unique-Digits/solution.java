public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //f1 10, f2 9*(10 - 1) + 1
        //3 9*9*(10 -2) + f2 ... fi 9*9*...(11 - i) + f i - 1
        int res = 0;
        if(n == 0) {
            res = 1;    //NoteNote
        }
        
        if(n >= 1 && n < 11) {
            int [] f = new int[n + 1];
            f[1] = 10;
            if(n > 1) {
                f[2] = 91;
                int base = 81;
                for(int i = 3; i <= n; i++) {
                    base *= (11 - i);
                    f[i] = f[i - 1] + base;
                }
            }
            res = f[n];
        }
        return res;
    }
}