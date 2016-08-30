public class Solution {
    public String numberToWords(int num) {
        if(num == 0) {
	    		return "Zero";
	    	}
	    	StringBuffer sb = new StringBuffer();
	        int [] nums = {1000000000, 1000000, 1000, 100, 
	        		90, 80, 70, 60, 50, 40, 30, 20,
	        		19, 18, 17, 16, 15, 14, 13, 12, 11, 10,
	        		9, 8, 7, 6, 5, 4, 3, 2, 1};
	        
	
	        String [] a = {"Billion", "Million", "Thousand", "Hundred", 
	        		"Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty",
	        		"Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten",
	        		"Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
	        for(int i = 0; i < a.length; i++) {
	            if(num >= nums[i]) {
	                int n = num/nums[i];
	                num = num%nums[i];
	                if(i <= 3) {
	                    sb.append(numberToWords(n) + " ");
	                }
	                if(num == 0){
	                    sb.append(a[i]);
                         break;
	                    
	                } else {
	                    sb.append(a[i] + " ");
	                }
	            }
	        }
    
	        return sb.toString();
    }
}