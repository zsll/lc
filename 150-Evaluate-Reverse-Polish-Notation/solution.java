public class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        if(tokens != null && tokens.length > 0) {
            Stack<Integer> s = new Stack<Integer>();
            for(String t : tokens) {
                if(isSign(t)) {
                    int num2 = s.pop(), num1 = s.pop();
                    if(t.equals("+")) {
                        s.push(num1 + num2);
                    } else if(t.equals("-")) {
                        s.push(num1 - num2);
                    } else if(t.equals("*")) {
                        s.push(num1 * num2);
                    } else if(t.equals("/")) {
                        s.push(num1 / num2);
                    }
                } else {
                    s.push(Integer.parseInt(t));
                }
            }
            res = s.peek();
        }
        return res;
    }
    
    public boolean isSign(String s) {
        String pattern = "[\\+\\-\\*/]";
        return s.matches(pattern);
    }
}