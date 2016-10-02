public class Solution {
    public boolean isValid(String s) {
        boolean res = true;
        if(s != null && s.length() > 0) {
            Stack<Character> stack = new Stack<Character>();
            for(char c : s.toCharArray()) {
                if(stack.empty() && (c == ')' || c == '}' || c == ']')) {
                    res = false;
                    break;
                } else {
                    if((c == ')' && stack.peek() == '(')
                        || (c == ']' && stack.peek() == '[')
                        || (c == '}' && stack.peek() == '{')) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                }
            }
            res = res && stack.empty();
        }
        return res;
    }
}