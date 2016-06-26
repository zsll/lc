public class Solution {
    public int calculate(String s) {
    int result = 0;
	String [] o = s.split("[0-9]+");	//get operators by excluding numbers
	String [] n = s.split("[\\+\\-\\*/]");	////get operators by excluding operators
	
	List<Integer> numbers = new ArrayList<Integer>();
	
	List<String> operaters = new ArrayList<String>();

	for(int i = 0; i < n.length; i++) {
		if(n[i].trim().length() > 0) {
			numbers.add(Integer.parseInt(n[i].trim()));
		}
	}
	for(int i = 0; i < o.length; i++) {
		if(o[i].trim().length() > 0) {
			operaters.add(o[i].trim());
		}
	}
	
	for(int i = 0; i < operaters.size(); i++) {
		if(operaters.get(i).equals("*") || operaters.get(i).equals("/")) {
			int product = operaters.get(i).equals("*") ? numbers.get(i)* numbers.get(i+1) : numbers.get(i) / numbers.get(i+1); 
			numbers.remove(i+1);
			numbers.remove(i);
			operaters.remove(i);
			numbers.add(i, product);
			i--;
		} 
	}
	result = numbers.get(0);
	for(int i = 0; i < operaters.size(); i++) {
		if(operaters.get(i).equals("+")) {
			result += numbers.get(i + 1);
		} else {
			result -= numbers.get(i + 1);
		}
	}
	return result;
    }
}