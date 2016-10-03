public class RandomizedSet {

    int size = 0;
    HashMap<Integer, Integer> vToI = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> iToV = new HashMap<Integer, Integer>();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(vToI.containsKey(val)) {
            return false;
        } else {
            vToI.put(val, size);
            iToV.put(size, val);
            size++;
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!vToI.containsKey(val)) {
            return false;
        } else {
            int index = vToI.get(val);
            int valToFill = iToV.get(size - 1);
            
            if(index != size - 1) {
                iToV.remove(size - 1);
                iToV.put(index, valToFill);
                vToI.put(valToFill, index);
                vToI.remove(val);
            } else {
                iToV.remove(size - 1);
                vToI.remove(val);
            }
            size--;
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        return iToV.get(r.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */