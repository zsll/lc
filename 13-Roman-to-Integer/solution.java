public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);
        int res = 0;
        if(s != null && s.length() > 0) {
            int pre = 0;
            for(char c : s.toCharArray()) {
                int cur = h.get(c);
                if(cur > pre) {
                    res -= 2*pre;
                }
                pre = cur;
                res += cur;
            }
        }
        return res;
    }
}