public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings != null && strings.length > 0) {
            HashMap<String, List<String>> m = new HashMap<String, List<String>>();
            for(String s : strings) {
                String k = getKey(s);
                if(!m.containsKey(k)) {
                    m.put(k, new ArrayList<String>());
                }
                m.get(k).add(s);
            }
            for(String s : m.keySet()) {
                res.add(m.get(s));
            }
        }
        return res;
    }
    
    String getKey(String s) {
        StringBuffer sb = new StringBuffer();
        if(s != null && s.length() > 0) {
            for(int i = 1; i < s.length(); i++) {
                /**
                 * Output:
[["abc","bcd","xyz"],["a","z"],["acef"],["az"],["ba"]]
Expected:
[["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
Rotation
*/
                sb.append((s.charAt(i) - s.charAt(i - 1) + 26)%26);
            }
        }
        return sb.toString();
    }
}