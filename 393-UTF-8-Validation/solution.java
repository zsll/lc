public class Solution {
    public boolean validUtf8(int[] data) {
        boolean res = true;
        int i = 0;
        while (i < data.length) {
            if(!startWith0(data[i])) {
                int j = i + 1;
                int startingOnes = getStarting1Num(data[i]);
                if(startingOnes == 1) {
                    /*single number 10010001*/
                    res = false;
                    break;
                }
                while(j < data.length && j - i < startingOnes && startWith10(data[j])) {
                    j++;
                }
                if(j - i < startingOnes) {
                    res = false;
                    break;
                } else {
                    i = j;
                }
            } else {
                i++;
            }
        }
        return res;
    }
    
    boolean startWith0(int a) {
        return (a & (1 << 7)) == 0;
    }
    
    boolean startWith10(int a) {
        return (a >> 6) == 2;
    }
    
    int getStarting1Num(int a) {
        int t = (1 << 7);
        int res = 0;
        while((t&a) > 0) {//NoteNote the & sign has lower priority than >
            t = t >> 1;
            res++;
        }
        return res;
    }
}