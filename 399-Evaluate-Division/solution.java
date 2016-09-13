public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    	double[] res = new double[queries.length];
    	HashMap<String [], Double> valueMap = new HashMap<String [], Double>();
        HashMap<String, List<String []>> startToResult = new HashMap<String, List<String []>>();
        for(int i = 0; i < values.length; i++) {
        	String [] reverse = new String[2];
        	reverse[0] = equations[i][1];
        	reverse[1] = equations[i][0];
        	valueMap.put(equations[i], values[i]);
        	valueMap.put(reverse, 1.0/values[i]);
        	if(!startToResult.containsKey(equations[i][0])) {
        		startToResult.put(equations[i][0], new ArrayList<String []>());
        	}
        	startToResult.get(equations[i][0]).add(equations[i]);
        	if(!startToResult.containsKey(equations[i][1])) {
        		startToResult.put(equations[i][1], new ArrayList<String []>());
        	}
        	startToResult.get(equations[i][1]).add(reverse);
        }
        for(int i = 0; i < queries.length; i++) {
        	HashSet<String> visited = new HashSet<String>();
			res[i] = dfs(valueMap, startToResult, queries[i][0], queries[i][1], visited);
        	
        }
        return res;
    }
    
    double dfs(HashMap<String [], Double> valueMap, HashMap<String, List<String []>> startToResult, String start, String end, HashSet<String> visited) {
    	double res = -1.0;
    	if(!visited.contains(start)) {
	    	visited.add(start);
	    	if(start.equals(end) && startToResult.containsKey(start)) {
	    		res = 1.0;
	    	} else if (startToResult.containsKey(start)){
	    		List<String []> endEq = startToResult.get(start);
	    		for(String [] nextEq : endEq) {
	
	    			double nextRes = dfs(valueMap, startToResult, nextEq[1], end, visited);
	
	    			if(nextRes != -1.0) {
	    				res = valueMap.get(nextEq) * nextRes;
	    				break;
	    			}
	    		}
	    	}
    	}
    	return res;
    }
}