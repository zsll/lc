public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        if(s != null && s.length() > 0) {
            int k = 2;
            HashMap<Character, Integer> h = new HashMap<Character, Integer>();
            int j = 0;
            for(int i = 0; i < s.length(); i++) {
                while(j < s.length() && h.keySet().size() <= k) {
                    char c = s.charAt(j);
                    if(!h.containsKey(c)) {
                        h.put(c, 0);
                    }
                    int pre = h.get(c);
                    h.put(c, pre + 1);
                    j++;
                }
                if(h.keySet().size() > k) {
                    j--;
                    h.remove(s.charAt(j));
                }
                res = Math.max(j - i, res);
                char c = s.charAt(i);
                int pre = h.get(c);
                if(pre == 1) {
                    h.remove(c);
                } else {
                    h.put(c, pre - 1);
                }
            }
        }
        return res;
    }
}