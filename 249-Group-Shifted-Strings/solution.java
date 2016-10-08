public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> h = new HashMap<String, List<String>>();
        for(String s : strings) {
            String code = encode(s);
            if(!h.containsKey(code)) {
                h.put(code, new ArrayList<String>());
            }
            h.get(code).add(s);
        }
        for(Map.Entry<String, List<String>> e : h.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }
    
    String encode(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < s.length(); i++) {
            int diff = (s.charAt(i) - s.charAt(i - 1) + 26)%26;
            sb.append(",");
            sb.append(diff);
        }
        return sb.toString();
    }
}