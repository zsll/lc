public class Solution {
    public int lengthLongestPath(String input) {
        int res = 0;
        if(input != null && input.length() > 0) {
            String [] strs = input.split("\n");    //NoteNote this is different from /d or /., /+ /*, does not have to escape, since it's one char
            Stack<LevelString> stack = new Stack<LevelString>();
            for(String s : strs) {
                int level = getLevel(s);
                while(!stack.empty() && stack.peek().level >= level) {
                    stack.pop();
                }
                /*String curPath = s.trim();Submission Result: Wrong Answer More Details 
                NoteNote, can't do trim for file name might start with spaces (WTF)

Input:
"dir\n        file.txt"
Output:
12
Expected:
16
*/
                String curPath = s.substring(level);
                boolean isFile = false;
                if(curPath.split("\\.").length >= 2) {  //is file
                    isFile = true;
                }
                if(!stack.empty()) {
                   curPath = stack.peek().s + "/" + curPath;
                }
                if(curPath.length() > res && isFile) {
                    res = curPath.length();
                }
                LevelString cur = new LevelString(level, curPath);
                stack.push(cur);
            }
        }
        return res;
    }
    
    int getLevel(String s) {
        int res = 0;
        while(res < s.length() && s.charAt(res) == '\t') {
            res++;
        }
        return res;
    }
    
    class LevelString { //Stores 1. how many \t are in front, called level 2. cur string
        int level;
        String s;
        public LevelString(int level, String s) {
            this.level = level;
            this.s = s;
        }
    }
}