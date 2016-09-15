public class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x < 0) {
        	neg = true;
        	x= 0 -x;
        	
        }
        long r = 0;
        while(x>0) {
        	r = r*10 + x%10;
        	x/=10;
        }
        if(neg) {
        	r = 0 - r;
        	if(r < Integer.MIN_VALUE){
        		r = 0;
        	}
        } else {
        	if(r > Integer.MAX_VALUE){
        		r = 0;
        	}
        }
        return (int)r;
    }
}