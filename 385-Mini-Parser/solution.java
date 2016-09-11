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
            //Create new NestedInteger when 1. start of number, hitting a [
            boolean prevCharIsNumber = false;
            boolean isNeg = false;
            for(char c : s.toCharArray()) {
                if (c >= '0' && c <= '9' || c == '-'){
                    int prev = 0;
                    if(!prevCharIsNumber) {
                        res = new NestedInteger(0);
                        if(!stack.empty()) {
                            stack.peek().getList().add(res);
                        }
                    } else { //NoteNote
                        prev = res.getInteger();
                    }
                    if(c == '-') {
                        isNeg = true;
                    } else {
                        if(isNeg) {
                            res.setInteger((int)(prev * 10 - (c - '0')));
                        } else {
                            res.setInteger((int)(prev * 10 + (c - '0')));
                        }
                    }
                    prevCharIsNumber = true;
                } else {
                    isNeg = false;
                    prevCharIsNumber = false;
                    if(c == '[') {
                        res = new NestedInteger();
                        if(!stack.empty()) {
                            stack.peek().getList().add(res);
                        }
                        stack.push(res);
                    } else if(c == ']') {
                        res = stack.pop();//last popped one would definitely be result
                    }
                }
            }
        }
        return res;
    }
}