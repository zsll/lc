public class RandomizedCollection {
 
    HashMap<Integer, HashSet<Integer>> valToIndex = new HashMap<Integer, HashSet<Integer>>();    //key is val, value is set of index
    HashMap<Integer, Integer> indexToVal = new HashMap<Integer, Integer>();    //key is index, value is val
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            boolean res = !valToIndex.containsKey(val);
            if(res) {
                HashSet<Integer> q = new HashSet<Integer>();
                valToIndex.put(val, q);
            } 
            int size = indexToVal.size();
            valToIndex.get(val).add(size);
            indexToVal.put(size, val);
            return res;
        }
        
        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            boolean res = valToIndex.containsKey(val);
                if(res) {
                    int size = indexToVal.size(); 
                    int indexToLeave = valToIndex.get(val).iterator().next(); //NoteNote
                    int lastVal = indexToVal.get(size - 1);
                    valToIndex.get(val).remove(indexToLeave);
                    if(valToIndex.get(val).size() == 0) {
                        valToIndex.remove(val);
                    }
                    if(indexToLeave != size - 1) {  //We can move last of that element to the pos of the val to be deleted
                        indexToVal.put(indexToLeave, lastVal);
                        indexToVal.remove(size - 1);
                        valToIndex.get(lastVal).remove(size - 1);
                        valToIndex.get(lastVal).add(indexToLeave);
                    } else {
                        indexToVal.remove(indexToLeave);
                    }
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
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */