/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger res = null;
        if(s != null && s.length() > 0) {
            Stack<NestedInteger> stack = new Stack<NestedInteger>();
            int num = 0;
            boolean isNeg = false;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if( c == '-') {
                    isNeg = true;
                } if (c >= '0' && c <= '9') {
                    num = isNeg ? num * 10 - (c - '0') : num * 10 + c - '0';
                } else {
                    if(i > 0 && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                        NestedInteger n = new NestedInteger(num);
                        if(res == null) {
                            res = n;
                        }
                        //if(!stack.empty()) {
                        else {
                            stack.peek().getList().add(n);
                        }
                        num = 0;
                        isNeg = false;
                    }
                    if(c == '[') {
                        
                        NestedInteger n = new NestedInteger();
                        if(res == null) {
                            res = n;
                        }
                        //if(!stack.empty()) {
                        else {
                            stack.peek().getList().add(n);
                        }
                        stack.push(n);
                    } else if(c == ']') {
                        stack.pop();
                    }
                }
            }
            if(s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9') {
                /**
                 * Submission Result: Runtime Error More Details 

Last executed input:
"324"*/
NestedInteger n = new NestedInteger(num);
                        if(res == null) {
                            res = n;
                        }
            }
        }
        return res;
    }
}