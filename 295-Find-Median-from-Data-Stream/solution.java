public class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        rebalance();
    }

    // Returns the median of current data stream
    public double findMedian() {
        double res = 0;
        int total = minHeap.size() + maxHeap.size();
        if(total%2 > 0) {
            res = 0.0 + maxHeap.peek();
        } else {
            res = (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return res;
    }
    
    void rebalance() {
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();