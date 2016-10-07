public class MovingAverage {
    int sum = 0;
    int [] a;
    int start, end;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        a = new int[size];  //NoteNote
        end = 0;
        start = size - 1;
    }
    
    public double next(int val) {
        if(end == start) {
            sum -= a[start];
            start = (start + 1)%(a.length);
            a[end] = val;
            end = (end + 1)%(a.length);
            sum += val;
            return sum*1.0/(a.length);
        } else {
            a[end++] = val;
            sum += val;
            return sum*1.0/end;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */