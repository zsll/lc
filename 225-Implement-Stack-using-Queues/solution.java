class MyStack {
	    private Queue<Integer> q1 = new LinkedList<Integer>();
	    private Queue<Integer> q2 = new LinkedList<Integer>();
	    
    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        q1.poll();
        q1 = q2;
        q2 = new LinkedList<Integer>();
    }

    // Get the top element.
    public int top() {
        int res = -1;
        while(q1.size() > 0) {
            if(q1.size() == 1) {
                res = q1.peek();
            }
            q2.offer(q1.poll());
        }
        q1 = q2;
        q2 = new LinkedList<Integer>();
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.size() == 0;
    }
}