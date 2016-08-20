public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> remainingLeft = new ArrayList<Integer>();
		ArrayList<Integer> remainingRight = new ArrayList<Integer>();
	 
		result.add("");	//stores result for each step
		remainingLeft.add(n);	
		remainingRight.add(n);	
	 
		for (int i = 0; i < 2 * n; i++) {//Every time insert one ( or ) and update result and diff
			ArrayList<String> temp1 = new ArrayList<String>();
			ArrayList<Integer> temp2 = new ArrayList<Integer>(); 
			ArrayList<Integer> temp3 = new ArrayList<Integer>(); 
	 
			for (int j = 0; j < result.size(); j++) {	//NoteNote the result.size()
				String s = result.get(j);
				int l = remainingLeft.get(j);
				int r = remainingRight.get(j);
	 
				if (l - 1 >= 0 ) {
					temp1.add(s + "(");
					temp3.add(r);
					temp2.add(l - 1);
				}
	 
				 
				if (r - 1 >= 0 && l <= r-1) {
					temp1.add(s + ")");
					temp2.add(l );
					temp3.add(r  - 1);
				}
			}
	 
			result = new ArrayList<String>(temp1);	//Please note res is updated 
			remainingLeft = new ArrayList<Integer>(temp2);
			remainingRight = new ArrayList<Integer>(temp3);
		}
	 
		return result;
    }
}