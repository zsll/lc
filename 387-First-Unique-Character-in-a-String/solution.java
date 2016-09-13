public class Solution {
    public int firstUniqChar(String s) {
        int res = -1;
        if(s != null && s.length() > 0) {
            int len = s.length();
            res = len;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(char c : s.toCharArray()) {
                if(!map.containsKey(c)) {
                    map.put(c,0);
                }
                int pre = map.get(c);
                map.put(c, pre + 1);
            }
            for(int i = 0; i < len; i++) {
                if(map.get(s.charAt(i)) == 1 && i < res) {
                    res = i;
                    break;
                }
            }
            
            if(res == len) {
                res = -1;
            }
        }
        return res;
    }
}