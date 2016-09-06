public class Solution {
     public int divide(int dividend, int divisor) {
        if (dividend == 0) {	//NoteNote
            return 0;
        }
    	if (divisor == 0) {	//NoteNote
            return dividend > 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
       }
       
       
    	/**
    	 * Submission Result: Wrong Answer More Details 

Input:
-2147483648
-1
Output:
-2147483648
Expected:
2147483647

Without it, we will move 1 to the very left, which will become negative
    	 */
      // if (dividend == Integer.MIN_VALUE && divisor == -1) {	//NoteNote
        //   return Integer.MAX_VALUE;
       //}
       
       boolean isNegative = (dividend < 0 && divisor > 0) || 
                            (dividend > 0 && divisor < 0);
                            
       long a = Math.abs((long)dividend);	//NoteNote, convert to long
       long b = Math.abs((long)divisor);
       //int a = Math.abs(dividend), b = Math.abs(divisor);
       long result = 0;
       
       //each loop adds a_0*2^0/b to res
       while(a >= b){
           int shift = 0;
           while(a >= (b << shift)){	//NoteNote: the reason we need to convert it to long is that if using int
        	   //2147483647, 1 will go into a dead loop
               shift++;
           }
           //After while b << shift > a, so needs to minus 1
           a -= b << (shift - 1);
           result += (long)1 << (shift - 1); //since b is multiplied by 2 to the power of  (shift - 1)
       }
       /* below also works
        * 
        * while(a >= b){
           long shift = 1;
           while(a >= b*shift){
               shift*=10;
           }
           //After while b << shift > a, so needs to minus 1
           a -= b *shift/10;
           result += 1 *shift/10;
       }
        */
       /**
        * Note, however, that large numbers (usually larger than 2147483647 and smaller than -2147483648) will lose some of the bits and would be represented incorrectly.

For instance, 2147483648 would be represented as -2147483648.
        */
       if(!isNegative && result > Integer.MAX_VALUE) {
    	   result = Integer.MAX_VALUE;
       }
       return isNegative? -(int)result: (int)result;
    }
}