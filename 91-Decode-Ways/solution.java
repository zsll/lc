public class Solution {
    public int numDecodings(String s) {
        int res = 0;
        if(s != null && s.length() > 0) {
            int len = s.length();
            int [] dp = new int[3];
            char [] a = s.toCharArray();
            dp[0] = 1;  //from right, how many ways to decode from i th char to end
            if(canUse1(a, len - 1)) {
                dp[1] = 1;
            }
            for(int i = 2; i <= len; i++) {
                if(canUse1(a,len - i)) {
                    dp[i%3] = dp[(i - 1)%3];
                    if(canUse2(a,len - i)) {
                        dp[i%3] += dp[(i - 2)%3];
                    }
                }else {
                	dp[i%3] = 0;	//NoteNoe
                }
            }
            res = dp[len%3];
        }
        return res;
    }
    
    boolean canUse1(char [] c, int i) {
        return c[i]  >= '1' && c[i] <= '9';
    }
    
    boolean canUse2(char [] c, int i) {
        int sum = c[i + 1] - '1' + 1 + (c[i] - '1' + 1) * 10;
        return sum >= 1 && sum <= 26;
    }
}