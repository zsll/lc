public class Solution {
    public String toHex(int num) {
        StringBuffer sb = new StringBuffer();
        char [] a = {'0','1', '2', '3', '4','5','6', '7', '8', '9','a','b', 'c', 'd', 'e','f'};
        for(int i = 0; i < 8; i++) {
            int index = num & 0xf;
            sb.insert(0, a[index]);
            num = num >>>4;
        }
        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}