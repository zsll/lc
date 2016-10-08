public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        if(n > 0) {
            HashMap<Character, Character> h = new HashMap<Character, Character>();
            h.put('0', '0');
            h.put('1', '1');
            h.put('8', '8');
            h.put('6', '9');
            h.put('9', '6');
            LinkedList<String> q = new LinkedList<String>();
            int digit = 0;
            if(n%2 > 0) {
                q.add("1");
                q.add("0");
                q.add("8");
                digit = 1;
            } else {
                q.offer("");
            }
            while(digit < n) {
                int size = q.size();
                for(int i = 0; i < size; i++) {
                    String s = q.remove();
                    for(char c : h.keySet()) {
                        q.add(c + s + h.get(c));
                    }
                }
                digit+=2;
            }
            for(String s : q) {
                /**
                 * Submission Result: Wrong Answer More Details 

Input:
1
Output:
["1","8"]
Expected:
["0","1","8"]*/
                if(s.charAt(0) != '0' || digit == 1) {
                    res.add(s);
                }
            }
        }
        return res;
    }
}