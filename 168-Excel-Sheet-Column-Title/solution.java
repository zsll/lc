public class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while(n > 0) {
            if(n%26 == 0) {
                sb.insert(0, 'Z');
                n--;
            } else {
                sb.insert(0,(char)(n%26 - 1 + 'A'));
            }
            n /= 26;
        }
        return sb.toString();
    }
}