public class Solution {
    //Assume there are k words
    //dp[i] means when starting from word i, how mnay lines it would need and
    //how many spaces it would leave in last line
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";//先用空格连起来
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {//每次一行
            start += cols;
            if (s.charAt(start % l) == ' ') {//start结尾处正好等于空格
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        
        return start / s.length();
    }
}