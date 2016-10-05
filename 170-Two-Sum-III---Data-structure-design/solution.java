public class TwoSum {

HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(!m.containsKey(number)) {
	        m.put(number, 0);
	    }
	    int pre = m.get(number);
	    m.put(number, pre + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    boolean res = false;
	    if(m.size() >0) {
    	    for(int i : m.keySet()) {
    	        if(value - i == i) {
    	            if(m.get(i) > 1) {
    	                res = true;
    	                break;
    	            }
    	        } else {
    	            if(m.containsKey(value - i)) {
    	                res = true;
    	                break;
    	            }
    	        }
    	    }
	    }
	    return res;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);