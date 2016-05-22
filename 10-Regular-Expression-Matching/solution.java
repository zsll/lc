public class Solution {
    public boolean isMatch(String s, String p) {
        int height = s.length(),width = p.length();
        boolean[][] dp = new boolean[height + 1][width + 1];	//please note the +1
        dp[0][0] = true;	//both empty
        for(int i = 2; i <= width; i++){
            if(i%2 == 0) {
                if(p.charAt(i - 1) == '*') dp[0][i] = true;
                else break;
            }	//initialize the scenario that s is empty, the first column. The rest of the first row would be false
        }
        for(int i = 1; i <= height; i++){	//Please note here we can scan col firstly, the two for loops can swap
            for(int j = 1; j <= width; j++){
                char sChar = s.charAt(i - 1);                
                char pChar = p.charAt(j - 1);
                if(sChar == pChar || pChar == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(pChar == '*'){//if current char is *
                    if(sChar != p.charAt(j - 2) && p.charAt(j - 2) != '.'){//if current char does not match p.charAt(j - 2)*
                        dp[i][j] = dp[i][j - 2];	//Then don't use this ?* part eg. s:bc, p:bca*
                    }else{	//if current char s.charAt(i-1) match p.charAt(j - 2)*
                        dp[i][j] =  dp[i][j - 2] | dp[i - 1][j];	// either don't used it s:bc, p:bca*, or it matches previous s:baa, p:ba* 
                    }
                }
            }
        }
        return dp[height][width];
    }
}