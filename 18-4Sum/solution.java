public class Solution {
    public List<List<Integer>> fourSum(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
    	HashMap<Integer, ArrayList<TwoSumPosition>> hm = new HashMap<Integer, ArrayList<TwoSumPosition>>();
    	for(int i = 0; i < a.length - 1; i++) {
    		for(int j = i + 1; j < a.length; j++) {
    			int sum = a[i] + a[j];
    			TwoSumPosition tsp = new TwoSumPosition(sum, i, j);
    			if(!hm.containsKey(sum)) {
    				hm.put(sum, new ArrayList<TwoSumPosition>());
    			}
    			hm.get(sum).add(tsp);
    		}
    	}
    	for(int i = 0; i < a.length - 1; i++) {
    		for(int j = i + 1; j < a.length; j++) {
    			int sum = a[i] + a[j];
    			int otherSum = target - sum;
    			if(hm.containsKey(otherSum)) {
    				ArrayList<TwoSumPosition> sumPosList = hm.get(sum);
    				ArrayList<TwoSumPosition> otherPosList = hm.get(otherSum);
    				for(TwoSumPosition sumPos : sumPosList) {
    					for(TwoSumPosition otherSumPos : otherPosList) {
        					if(sumPos.p1 != otherSumPos.p1 && sumPos.p1 != otherSumPos.p2 &&
        							sumPos.p2 != otherSumPos.p1 && sumPos.p2 != otherSumPos.p2) {
        						List<Integer> valid = new ArrayList<Integer>();
        						valid.add(sumPos.p1);
        						valid.add(sumPos.p2);
        						valid.add(otherSumPos.p1); 
        						valid.add(otherSumPos.p2);
        						result.add(valid);
        					}
    					}
    				}
    			}
    		}
    	}
    	return result;
    }
    
    class TwoSumPosition {
    	int sum, p1, p2;
    	public TwoSumPosition(int sum, int p1, int p2) {
    		this.sum = sum;
    		this.p1 = p1;
    		this.p2 = p2;
    	}
    }
}