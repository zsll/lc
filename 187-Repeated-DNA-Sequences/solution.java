public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        
        if(s == null || s.length() < 10) {
            return res;
        }
        HashMap<Character, Integer> d = new HashMap<Character, Integer>();
        d.put('A', 0);
        d.put('C', 1);
        d.put('G', 2);
        d.put('T', 3);
        HashSet<Integer> m = new HashSet<Integer>();
        int k = 0;
        for(int i = 0; i < 10; i++) {
            k = (k<<2) + d.get(s.charAt(i));    //NoteNote, needs ()
        }
        m.add(k);
        for(int i = 10; i < s.length(); i++) {
            k = ((k<<2) & 0xFFFFF) + d.get(s.charAt(i));
            
            if(!m.add(k) && res.indexOf(s.substring(i - 9, i + 1)) == -1) {
                /**
                 * Input:
"AAAAAAAAAAAA"
Output:
["AAAAAAAAAA","AAAAAAAAAA"]
Expected:
["AAAAAAAAAA"]
*/
                res.add(s.substring(i - 9, i + 1));
            } 
            
        }
        return res;
    }
}