public class Solution {
    public int calculate(String s) {
        int res = 0;
        if(s != null && s.length() > 0) {
            boolean lPos = true;
            Stack<Boolean> stack = new Stack<Boolean>();    //stack top stores global pos
            stack.push(true);
            int cur = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c >= '0' && c <= '9') {
                    cur = cur * 10 + c - '0';
                    if(i == s.length() - 1 || s.charAt(i + 1) < '0' || s.charAt(i + 1) > '9') {
                        if(stack.peek() == lPos) {
                            res += cur;
                        } else {
                            res -= cur;
                        }
                    }
                } else {
                    cur = 0;
                    if(c == '(') {
                        stack.push(stack.peek() == lPos);
                        lPos = true;    //NoteNote, after entering the (, needs to reset lPos
                    } else if(c == ')') {
                        stack.pop();
                    } else if(c == '+') {
                        lPos = true;
                    } else if(c == '-') {
                        lPos = false;
                    }
                }
            }
        }
        return res;
    }
}