public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    boolean res = true;
    	if(numCourses > 1) {
    		Map<Integer, Set<Integer>> m = new HashMap<Integer, Set<Integer>>(); //key is dependency
        	for(int i = 0; i < numCourses; i++) {
        		m.put(i, new HashSet<Integer>());
        	}
        	for(int i = 0; i < prerequisites.length; i++) {
        		int dep = prerequisites[i][1];
        		int c = prerequisites[i][0];
        		m.get(dep).add(c);
        	}
        	HashSet<Integer> visited = new HashSet<Integer>();
        	HashSet<Integer> queued = new HashSet<Integer>();
        	for(int i : m.keySet()) {
        		
        		if(search(visited, queued, m, i) == false)
        			res = false;
        	}
    	}
    	return res;
    }
    
    //return false if contains loop
    boolean  search(HashSet<Integer> visited, HashSet<Integer> queued, Map<Integer, Set<Integer>> m, int n) {
    	if(queued.contains(n)) {
    		return false;
    	} else if(visited.contains(n)) {
			return true;
		} else {
    		queued.add(n);
    		for(int i : m.get(n)) {
    			if(search(visited, queued, m, i) == false)
    			    return false;
    		}
    		queued.remove(n);
    		visited.add(n);
    		return true;
    	}
    }
}