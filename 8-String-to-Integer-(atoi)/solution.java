public class Solution {
    public int myAtoi(String str) {
        long res = 0;
        if(str != null && str.length() > 0) {
            int i = 0;
            /*
            Submission Result: Wrong Answer More Details 

Input:
"    010"
Output:
0
Expected:
10
            */
            str = str.trim();
            boolean isNeg = false;
            if(str.charAt(i) == '-') {
                isNeg = true;
                i++;
            } else if(str.charAt(i) == '+') {
                i++;
            }
            
            while(i < str.length()) {
                if(str.charAt(i) <'0' || str.charAt(i) >'9') {
                    /*
                    Submission Result: Wrong Answer More Details 

Input:
"+-2"
Output:
-28
Expected:
0
                    */
                    break;
                }
                
                res *= 10;
                if(!isNeg) {
                    res += (str.charAt(i) - '0');
                    if(res > Integer.MAX_VALUE) {
                        res = Integer.MAX_VALUE;
                        break;
                    }
                }else {
                    res -= (str.charAt(i) - '0');
                    if(res < Integer.MIN_VALUE) {
                        res = Integer.MIN_VALUE;
                        break;
                    }
                }
                i++;
            }
        }
        return (int)res;
    }
}