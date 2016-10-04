public class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean res = true;
        if(s != null && s.length() > 0) {
            int [] h = new int[255];
            for(char c : s.toCharArray()) {
                h[c]++;
            }
            int odd = 0;
            for(int i = 0; i < 255; i++) {
                if(h[i]%2 == 1) {
                    odd++;
                }
            }
            res = odd <2;
        }
        return res;
    }
}