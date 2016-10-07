public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        if(strs != null && strs.size() > 0) {
            for(String s : strs) {
                sb.append(s.length());
                sb.append("#");
                sb.append(s);
            }
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        if(s != null && s.length() > 0) {
            int i = 0;
            while(i < s.length()) {
                int j = s.indexOf("#", i);
                int len = Integer.parseInt(s.substring(i, j));
                String w = s.substring(j + 1, j + 1 + len);
                res.add(w);
                i = j + 1 + len;
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));