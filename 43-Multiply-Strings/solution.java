public class Solution {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();	//NoteNote: StringBuffer is synchronized, StringBuilder is not.
		String n2 = new StringBuilder(num2).reverse().toString();
		
		int[] d = new int[n1.length()+n2.length()];		// 构建数组存放乘积 NoteNote
		for(int i=0; i<n1.length(); i++){
			for(int j=0; j<n2.length(); j++){
				d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');		// 在正确位置累加乘积
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<d.length; i++){
			int digit = d[i]%10;		// 当前位
			int carry = d[i]/10;		// 进位
			if(i+1<d.length){
				d[i+1] += carry;
			}
			sb.insert(0, digit);		// prepend
		}
		
		// 移除前导零
		while(sb.charAt(0)=='0' && sb.length()>1){
			sb.deleteCharAt(0);
		}
		return sb.toString();
    }
}