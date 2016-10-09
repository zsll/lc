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
        if(num != null && k >= 0 && num.length() > k) {
            String next = num;  //NoteNote the initialization incase k = 0;
            while(k > 0) {
                next = remove1(num);
                k--;
                num = next;
            }
            res = Integer.toString(Integer.parseInt(next));
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