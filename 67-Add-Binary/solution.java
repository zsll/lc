public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while(i >= 0 && j >= 0) {
            int ai = a.charAt(i) - '0', bj = b.charAt(j) - '0';
            int sum = (ai ^ bj) ^ c;
            c = (ai + bj + c)/2;
            sb.insert(0, sum);
        }
        while(i >= 0) {
            int ai = a.charAt(i) - '0';
            int sum = ai ^ c;
            c = (ai + c)/2;
            sb.insert(0, sum);
        }
        while(j >= 0) {
            int bj = b.charAt(j) - '0';
            int sum = bj ^ c;
            c = (bj + c)/2;
            sb.insert(0, sum);
        }
        return sb.toString();
    }
}