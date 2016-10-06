public class Solution {
    public int calculate(String s) {
        long res = 0;
        if(s != null && s.length() > 0) {
            s = s.replaceAll(" ", "");
            String [] number = s.split("[\\+\\-\\*/]");
            String [] signs = s.split("[0-9]+");
            LinkedList<Long> stack = new LinkedList<Long>();
            stack.push(Long.parseLong(number[0]));
            for(int i = 1; i < signs.length; i++) {
                String sign = signs[i];
                if(sign.equals("*") || sign.equals("/")) {
                    long pre = stack.removeLast();
                    if(sign.equals("*") ) {
                        stack.add(pre*Long.parseLong(number[i]));
                    } else {
                        stack.add(pre/Long.parseLong(number[i]));
                    }
                } else {
                    stack.add(Long.parseLong(number[i]));
                }
            }
            for(int i = 0; i < signs.length; i++) {
                String sign = signs[i];
                if(sign.equals("+") || sign.equals("-")) {
                    long first = stack.remove(), sec = stack.remove();
                    if(sign.equals("+") ) {
                        stack.push(first + sec);
                    } else {
                        stack.push(first - sec);
                    }
                }
            }
            res = stack.peek();
        }
        return (int)res;
    }
}