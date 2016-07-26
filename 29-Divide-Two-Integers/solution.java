public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {	//NoteNote
            return 0;
        }
    	if (divisor == 0) {	//NoteNote
            return dividend > 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
       }
       
       
       if (dividend == Integer.MIN_VALUE && divisor == -1) {	//NoteNote
           return Integer.MAX_VALUE;
       }
       
       boolean isNegative = (dividend < 0 && divisor > 0) || 
                            (dividend > 0 && divisor < 0);
long a = Math.abs((long)dividend);	//NoteNote, convert to long
       long b = Math.abs((long)divisor);
       int result = 0;
       
       //each loop adds a_0*2^0/b to res
       while(a >= b){
           int shift = 1;
           while(a >= b*shift){
               shift*=10;
           }
           //After while b << shift > a, so needs to minus 1
           a -= b *shift/10;
           result += 1 *shift/10;
       }
       return isNegative? -result: result;
    }
}