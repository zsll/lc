public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        if(num1 != null && num2 != null) {
            int i = 1, c = 0;
            int l1 = num1.length(), l2 = num2.length();
            while(l1 - i >= 0 && l2 - i >= 0) {
                int n1 = (int)(num1.charAt(l1 - i) - '0');
                int n2 = (int)(num2.charAt(l2 - i) - '0');
                sb.insert(0, (n1 + n2 + c)%10 );
                c = (n1 + n2 + c)/10;
                i++;
            }
            while(l1 - i >= 0) {
                int n1 = (int)(num1.charAt(l1 - i) - '0');
                sb.insert(0, (n1 + c)%10 );
                c = (n1 + c)/10;
                i++;
            }
            while(l2 - i >= 0) {
                int n2 = (int)(num2.charAt(l2 - i) - '0');
                sb.insert(0, (n2 + c)%10 );
                c = (n2 + c)/10;
                i++;
            }
            if(c != 0) {
                sb.insert(0, 1);
            }
        }
        return sb.toString();
    }
}