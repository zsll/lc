public class Solution {
    public String removeKdigits(String num, int k) {
        String res = "";
        /**
         * Runtime Error Message:
Line 11: java.lang.NumberFormatException: For input string: ""
Last executed input:
"10"
2
         */ 
        if(num != null && k >= 0 && num.length() >= k) {
            String next = num;  //NoteNote the initialization incase k = 0;
            while(k > 0) {
                next = remove1(num);
                k--;
                num = next;
            }
            /**
             * Runtime Error Message:
Line 18: java.lang.NumberFormatException: For input string: "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001001604269216566928220767474713135...
Can't use integer conversion
             */
            /**
             * Submission Result: Wrong Answer More Details 

Input:
"10"
2
Output:
""
Expected:
"0"*/
            
            StringBuffer sb = new StringBuffer(next);
            
            if(sb.length() == 0) {
                sb.append(0);
            }
            while(sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            res = sb.toString();
        }
        return res;
    }
    
    String remove1(String s) {
        StringBuffer sb = new StringBuffer(s);
        int i = 0;
        while(i < sb.length() - 1) {
            if(sb.charAt(i) > sb.charAt(i + 1)) {
                break;
            }
            i++;
        }
        sb.deleteCharAt(i);
        return sb.toString();
    }
}