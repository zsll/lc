public class PhoneDirectory {

    BitSet b; 
    int lowestAvailable = 0;
    int max;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        b = new BitSet(maxNumbers);   //NoteNote
        this.max = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(lowestAvailable==max) return -1;
        b.set(lowestAvailable);//NoteNote
        int res = lowestAvailable;
        lowestAvailable=b.nextClearBit(lowestAvailable);//NoteNote
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return b.get(number) == false;  //NoteNote
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(b.get(number) != false) {
            b.clear(number);    //NoteNote
            if(number<lowestAvailable){
                lowestAvailable=number;
            }
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */