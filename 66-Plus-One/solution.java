public class Solution {
    public int[] plusOne(int[] digits) {
        int [] res = digits;
        if(digits != null && digits.length > 0) {
            int nextIs9 = -2, last9Pos = -1;//NoteNote, we can't initiate with possible number
            for(int i = 0; i < digits.length; i++) {
                int d = digits[i];
                if((i == 0 || digits[i - 1] != 9) && d  == 9) {
                    nextIs9 = i - 1;
                } 
                if (d == 9) {
                    last9Pos = i;
                } 
            }
            if(last9Pos != digits.length - 1) {
                res[digits.length - 1]++;
            } else {
                if(nextIs9 != -1) {
                    res[nextIs9]++;
                    for(int i = nextIs9 + 1; i < digits.length; i++) {
                        res[i] = 0;
                    }
                } else {
                    res = new int[digits.length + 1];
                    res[0]++;
                }
            }
        }
        return res;
    }
}