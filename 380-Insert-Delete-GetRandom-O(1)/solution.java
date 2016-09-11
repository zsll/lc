public class RandomizedSet {

    HashMap<Integer, Integer> indexToVal = new HashMap<Integer, Integer>();    //key is index, value is value
    HashMap<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();    //key is val, value is index
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = !valToIndex.containsKey(val);
        if(res) {
            int size = indexToVal.size();
            valToIndex.put(val, size);
            indexToVal.put(size, val);
        }
        return res;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean res = valToIndex.containsKey(val);
        if(res) {
            int size = indexToVal.size(); 
            int indexToLeave = valToIndex.get(val);
            int lastVal = indexToVal.get(size - 1);
            if(indexToLeave != size - 1) {  //We can move last of that element to the pos of the val to be deleted
                indexToVal.put(indexToLeave, lastVal);
                indexToVal.remove(size - 1);
                valToIndex.put(lastVal, indexToLeave);
            } else {
                indexToVal.remove(indexToLeave);
            }
            valToIndex.remove(val);
        }
        return res;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int i = r.nextInt(indexToVal.size());
        return indexToVal.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */