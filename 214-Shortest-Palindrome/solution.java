public class Solution {
    public String shortestPalindrome(String s) {
        StringBuffer sb = new StringBuffer(s);
        if(s.length() > 0) {
            int len = s.length(), maxPLenFrom0 = 1;
            boolean [][] dp = new boolean[len][len];    //from i to j is palindrome
            for(int i = 0; i < len; i++) {
                dp[i][i] = true;
                if(i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                    if(i == 0) {
                        maxPLenFrom0 = 2;
                    }
                }
            }
            for(int ij = 3; ij <= len; ij++) {  //ij is length from i to j
                for(int col = ij - 1; col < len; col++) {
                    int row = col - ij + 1;
                    if(s.charAt(row) == s.charAt(col) && dp[row + 1][col - 1]) {
                        dp[row][col] = true;
                        if(row == 0) {
                            maxPLenFrom0 = ij;
                        }
                    }
                }
            }
            for(int i = 0; i < len - maxPLenFrom0; i++) {
                char c = s.charAt(len - i - 1);
                sb.insert(i, c);
            }
        }
        return sb.toString();
    }
}