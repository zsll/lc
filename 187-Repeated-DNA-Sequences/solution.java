public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if(s != null && s.length() >= 10) {
            HashMap<Character, Integer> m = new HashMap<Character, Integer>();
            
            HashMap<Integer, String> h = new HashMap<Integer, String>();
            m.put('A', 0);
            m.put('C', 1);
            m.put('T', 2);
            m.put('G', 3);
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                sum = (sum<<2) | m.get(s.charAt(i));
            }
            String sub = s.substring(0, 10);
            h.put(sum, sub);
            for(int i = 10; i < s.length(); i++) {
                sum = (sum<<2)&0xFFFFF | m.get(s.charAt(i));
                sub = s.substring(i - 10 + 1, i + 1);
                if(!h.containsKey(sum)) {
                    h.put(sum, sub);
                } else if(res.indexOf(sub) == -1) {
                    /**
                     * Submission Result: Wrong Answer More Details 

Input:
"AAAAAAAAAAAA"
Output:
["AAAAAAAAAA","AAAAAAAAAA"]
Expected:
["AAAAAAAAAA"]*/
                    res.add(sub);
                }
            }
        }
        return res;
    }
}