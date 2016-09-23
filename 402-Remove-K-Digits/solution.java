public class Solution {
    public String removeKdigits(String A, int k) {
        if(A == null || A.length() <= k) {
		return "0";
	}
	if(k == 0) {
	    return A;
	}
	StringBuffer b = new StringBuffer(A);
	int count = 0;
	//for(int j = 0; j < k; j++) {
		for(int i = 0; i < b.length(); i++) {
			if(isDown(b,i)) {
				b.deleteCharAt(i);
				count++;
				if(k == count)
					break;
				if(i == 0) {
					i--;
				} else {
					i -= 2;	//looking back
				}
			}
		}
	//}
	
	/**
	 * Wrong Answer

总耗时: 612 ms
4 / 13 数据通过测试.
输入
90249, 2
输出
024
期望答案
24
	 */
	while(b.length() > 0 && b.charAt(0) == '0') {
		b.deleteCharAt(0);
	}
	return b.toString();
	
    }
    
     public boolean isDown(StringBuffer b, int i) {
		boolean result = false;
		if(i==b.length() - 1 || b.charAt(i) > b.charAt(i+1) 
				) {
			result = true;
		}
		return result;
	}
}