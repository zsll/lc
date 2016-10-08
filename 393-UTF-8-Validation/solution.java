public class Solution {
    public boolean validUtf8(int[] data) {
        boolean res = true;
        if(data != null && data.length > 0) {
            int i = 0;
            while(i < data.length) {
                int cur = data[i];
                int starting1s = starting1s(cur);
                if(starting1s == 0) {
                    i++;
                } else if(starting1s == 1) {
                    res = false;
                    break;
                } else {
                    int j = i + 1;
                    for(; j <= Math.min(data.length, i + starting1s - 1); j++) {
                        int starting1s2 = starting1s(data[j]);
                        if(starting1s2 != 1) {
                            break;
                        }
                    }
                    if(j < i + starting1s) {
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }
    
    int starting1s(int i) {
        int mask = 1 << 7;
        int res = 0;
        while((mask & i) > 0) {
            res++;
            mask = mask >>> 1;
        }
        return res;
    }
}