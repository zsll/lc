public class Solution {
    public boolean isValid(String s) {
        boolean r = true;
        if(s != null && s.length() > 0) {
        	char [] a = s.toCharArray();
        	Stack<Character> stack = new Stack<Character>();
        	for(int i = 0; i < a.length ; i++) {
        		char c = a[i];
        		if(stack.isEmpty()) {
        			if (c == ')' || c == '}' || c == ']')
        				return false;
        			stack.push(c);
        		} else {
        		char p = stack.peek();
        		if((c == ')' && p == '(' || p == '{' && c=='}'|| c == ']' && p == '[')) {
        			stack.pop();
        		} else {
        			stack.push(c);
        		}
        		}
        	}
        	r = stack.isEmpty();
        }
        return r;
    }
}