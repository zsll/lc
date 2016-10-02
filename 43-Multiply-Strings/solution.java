public class Solution {
    public String multiply(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        if(num1 != null && num2 != null && num1.length() > 0 && num2.length() > 0) {
            int len1 = num1.length(), len2 = num2.length();
            int [] res = new int[len1 + len2];
            
            /**
             * Submission Result: Wrong Answer More Details 

Input:
"98"
"9"
Output:
"801"
Expected:
"882"
             */
            num1 = new String((new StringBuffer(num1)).reverse());
            num2 = new String((new StringBuffer(num2)).reverse());
            for(int i = len1 - 1; i >=0 ; i--) {
                for(int j = len2 - 1; j >= 0; j--) {
                    res[i + j] += (num1.charAt(i) - '0')*(num2.charAt(j) - '0');//NoteNote: should be +=
                }
            }
            for(int i = 0; i < len1 + len2 - 1; i++) {
                //if(i < len1 + len2 - 1) {
                    res[i + 1] += res[i]/10;
                //}
                res[i] %= 10;
            }
            int start = len1 + len2 - 1;
            while(res[start] == 0 && start > 0) {
                start--;
            }
            for(int i = start; i >= 0; i--) {
                sb.append(res[i]);
            }
        }
        return sb.toString();
    }
}