public class Solution {
    public String removeKdigits(String num, int k) {
        String res = "0";
        if(num != null && num.length() > k && k >= 0) {
            int i = 0;
            StringBuffer sb = new StringBuffer(num);
            while(k > 0) {
                if(i == sb.length() - 1 || sb.charAt(i) > sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    k--;
                    if(i == 0) {
                        i--;
                    } else {
                        i -= 2;
                    }
                }
                i++;
            }
            while(sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            res = sb.toString();
        }
        return res;
    }
}