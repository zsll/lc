public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs != null && strs.length > 0) {
            HashMap<String, List<String>> m = new HashMap<String, List<String>>();
            for(String s : strs) {
                String key = getKey(s);
                if(!m.containsKey(key)) {
                   m.put(key, new ArrayList<String>());  
                }
                m.get(key).add(s);
            }
            for(String s : m.keySet()) {
                res.add(m.get(s));
            }
        }
        return res;
    }
    
    String getKey(String s) {
        char [] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}