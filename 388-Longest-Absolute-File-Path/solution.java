public class Solution {
    public int lengthLongestPath(String input) {
        int res = 0;
        if(input != null && input.length() > 0) {
            String [] lines = input.split("\\n");
            Stack<String> dirStack = new Stack<String>();
            Stack<Integer> spaceStack = new Stack<Integer>();
            int curDirLen = 0;
            for(String line : lines) {
                int spaces = spaceCount(line);
                String s = line.substring(spaces);
                
                    while(!spaceStack.empty() && spaces <=  spaceStack.peek()) {
                        spaceStack.pop();
                        String popped = dirStack.pop();
                        curDirLen -= (popped.length() + 1); //NoteNote there is a '\' between folders
                    }
                if(s.indexOf(".") >= 0) {
                    res = Math.max(curDirLen + s.length(), res);
                } else {
                    curDirLen += (s.length() + 1);
                    spaceStack.push(spaces);
                    dirStack.push(s);
                }
            }
        }
        return res;
    }
    //Find first non space char, which would be the starting space numbers, binary search to find
    int spaceCount(String line) {
        int start = 0, end = line.length() - 1;
        while(start <= end) {
            int mid = start + (end - start >> 1);
            if(line.charAt(mid) != '\t') {   //NoteNote
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
        }
        return start;
    }
}