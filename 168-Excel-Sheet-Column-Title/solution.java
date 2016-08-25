public class Solution {
    public String convertToTitle(int n) {
        StringBuffer res = new StringBuffer();
        while(n > 0) {
            int mod = n%26;
            char c = (char)('A' + mod - 1);
            if(mod == 0) {
                c = 'Z';
                n--;
            }
            res.insert(0, c);
            n /= 26;
        }
        return res.toString();
    }
}