public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if(word != null) {
            //StringBuffer sb = new StringBuffer();   //NoteNote, can't use stringbuffer, for cases like long 19, it will become 110
            List<String> cur = new ArrayList<String>();
            dfs(word, 0, cur, res);
        }
        return res;
    }
    
    void dfs(String word, int pos, List<String> cur, List<String> res) {
        if(pos == word.length()) {
            StringBuffer sb = new StringBuffer();
            for(String s : cur) {
                sb.append(s);
            }
            res.add(new String(sb));
        } else if (pos < word.length()) {
            cur.add(word.charAt(pos) + "");
            dfs(word, pos + 1, cur, res);
            cur.remove(cur.size() - 1);
            if(cur.size() > 0 && !(cur.get(cur.size()  - 1).charAt(0) >= 'a' && cur.get(cur.size()  - 1).charAt(0) <= 'z')) {//previous is not char, in this case, can only increase previous number
                int pre = Integer.parseInt(cur.get(cur.size()  - 1));
                cur.remove(cur.size() - 1);
                cur.add((pre + 1) + "");
                dfs(word, pos + 1, cur, res);
                cur.remove(cur.size() - 1);
                cur.add(pre + "");
            } else {
                cur.add("1");
                dfs(word, pos + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}