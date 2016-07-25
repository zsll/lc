public class Solution {
    public int divide(int dividend, int divisor) {
              if(divisor == 0)
        {
            return Integer.MAX_VALUE;	//NoteNote
        }
        boolean isNeg = (dividend^divisor)>>>31 == 1;	//NoteNote
        int res = 0;
        if(dividend == Integer.MIN_VALUE)	//NoteNote special case
        {
            if(divisor == -1)
            {
                return Integer.MAX_VALUE;
            }
            dividend += Math.abs(divisor);
            res++;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while(divisor <= (dividend>>1))
        {
            divisor <<= 1;
            digit++;
        }
        while(digit>=0)
        {
            if(dividend>=divisor)
            {
                res += 1<<digit;
                dividend -= divisor;
            }
            divisor >>= 1;
            digit--;
        }
        return isNeg?-res:res;
    }
}