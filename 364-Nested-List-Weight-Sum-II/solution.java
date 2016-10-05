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
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int res = 0;
        if(nestedList != null && nestedList.size() > 0) {
            LinkedList<NestedInteger> q = new LinkedList<NestedInteger>();
            for(NestedInteger i : nestedList) {
                q.add(i);
            }
            int unweighted = 0; //sum of all integers in list
            while(q.size() > 0) {
                LinkedList<NestedInteger> next = new LinkedList<NestedInteger>();
                for(NestedInteger i : q) {
                    if(i.isInteger()) {
                        unweighted += i.getInteger();
                    } else {
                        next.addAll(i.getList());
                    }
                }
                res += unweighted;
                q = next;
            }
        }
        return res;
    }
}