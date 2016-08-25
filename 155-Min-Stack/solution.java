public class MinStack {

    /** initialize your data structure here. */
    
    Stack<Integer> s, minS;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<Integer>();
        minS = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(minS.empty() || minS.peek() >= x) {
            minS.push(x);
        }
        s.push(x);
    }
    
    public void pop() {
        int a = minS.peek(), b = s.peek();
        if( b == a) {
            minS.pop();
        }
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */