public class LRUCache {
    Node dHead = new Node(), dTail = new Node();
    HashMap<Integer, Node> h = new HashMap<Integer, Node>();
    int size = 0, capacity = 0;
    public LRUCache(int capacity) {
        dHead.next = dTail;
        dTail.pre = dHead;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int res = -1;
        if(h.containsKey(key)) {
            Node n = h.get(key);
            leave(n);
            prepend(n);
            res = n.val;
        }
        return res;
    }
    
    public void set(int key, int value) {
        if(h.containsKey(key)) {
            h.get(key).val = value;   //NoteNote: this is update
            get(key);
        } else {
            if(size == capacity) {
                h.remove(dTail.pre.key);
                leave(dTail.pre);
                size--;
            }
            Node n = new Node(value, key);
            h.put(key, n);
            prepend(n);
            size++;
        }
    }
    
    void leave(Node n) {
        n.pre.next = n.next;
        n.next.pre = n.pre;
        n.next = null;
        n.pre = null;
    }
    
    void prepend(Node n) {//firstly delete from tail, so prepend after head
        n.next = dHead.next;
        n.pre = dHead;
        dHead.next.pre = n;
        dHead.next = n;
    }
    
    class Node {
        Node pre, next;
        int val, key;
        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
        
        public Node() {
            this.val = Integer.MAX_VALUE;
            this.key = Integer.MAX_VALUE;
        }
    }
}