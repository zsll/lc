public class Solution {
    public boolean isIsomorphic(String s, String t) {
        boolean res = true;
        if(s == null && t != null || t == null && s != null) {
            res = false;
        } else if (s != null && t != null) {
            if(s.length() != t.length()) {
                res = false;
            } else {
                int [] st = new int[257];    //if not set, will be 0
                int [] ts = new int[257];
                for(int i = 0; i < s.length(); i++) {
                    int sc = (int)(s.charAt(i)  + 1);  //1 to 256
                    int tc = (int)(t.charAt(i)  + 1);
                    if(st[sc] == 0 && ts[tc] == 0) {
                        st[sc] = tc;
                        ts[tc] = sc;
                    } else if  ( (st[sc] > 0 && (ts[tc] == 0 || st[sc] != tc) ) 
                    ||  (ts[tc] > 0 && (st[sc] == 0 || ts[tc] != sc ) )){
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }
}