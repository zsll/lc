public class RandomizedCollection {
    
    HashMap<Integer, HashSet<Integer>> vToI = new HashMap<Integer, HashSet<Integer>>();
    HashMap<Integer, Integer> iToV = new HashMap<Integer, Integer>();
    int size = 0;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = !vToI.containsKey(val);
        if(res) {
            vToI.put(val, new HashSet<Integer>());
            
        }
        vToI.get(val).add(size);
        iToV.put(size, val);
        size++;
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean res = vToI.containsKey(val);
        if(res) {
            int indexToLeave = vToI.get(val).iterator().next();
            vToI.get(val).remove(indexToLeave);
            if(indexToLeave == size - 1) {
                
                iToV.remove(size - 1);
            } else {
                int lastVal = iToV.get(size - 1);
                vToI.get(lastVal).remove(size - 1);
                vToI.get(lastVal).add(indexToLeave);
                iToV.remove(size - 1);
                iToV.put(indexToLeave, lastVal);
            }
            if(vToI.get(val).size() == 0) {
                vToI.remove(val);
            }
            size--;
        }
        return res;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random r = new Random();
        return iToV.get(r.nextInt(size));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */