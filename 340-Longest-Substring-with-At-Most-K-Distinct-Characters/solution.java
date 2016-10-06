public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        if(s != null && s.length() > 0 && k > 0) {
            HashMap<Character, Integer> h = new HashMap<Character, Integer>();
            int j = 0;
            for(int i = 0; i < s.length(); i++) {
                while(j < s.length() && h.keySet().size() <= k) {
                    if(!h.containsKey(s.charAt(j)) ){
                        h.put(s.charAt(j), 0);
                    }
                    int pre = h.get(s.charAt(j));
                    h.put(s.charAt(j), pre + 1);
                    j++;
                }
                if(h.keySet().size() > k) {
                    j--;
                    h.remove(s.charAt(j));
                }
                res = Math.max(res, j - i);
                char c = s.charAt(i);
                int pre = h.get(c);
                if(pre > 1) {
                    h.put(c, pre - 1);
                } else {
                    h.remove(c);
                }
            }
        }
        return res;
    }
}