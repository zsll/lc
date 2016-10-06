public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int i = 0;
        while(i < 32) { //NoteNote
        /**
         * Submission Result: Wrong Answer More Details 

Input:
           1 (00000000000000000000000000000001)
Output:
           1 (00000000000000000000000000000001)
Expected:
  2147483648 (10000000000000000000000000000000)*/
            res = res << 1; //NoteNote
            res |= n&1;
            n = n >>> 1;
            i++;
        }
        return res;
    }
}