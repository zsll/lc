/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int res = -1;
	        if(n > 0) {
		        int candidate = 0;
		        for(int i = 1; i < n; i++) {
		        	if(knows(candidate, i)) {
		        		candidate = i;
		        	}
		        }
		        res = candidate;
		        for(int i = 0; i < n; i++) {
		        	if(i != candidate) {
		        		if(knows(candidate, i) || !knows(i, candidate)) {
		        			res = -1;
		        		}
		        	}
		        }
	        }
	        return res;
    }
}