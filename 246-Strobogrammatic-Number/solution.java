public class Solution {
    public boolean isStrobogrammatic(String num) {
        boolean res = true;
        if(num != null && num.length() > 0) {
            HashMap<Character, Character> m = new HashMap<Character, Character>();
            m.put('9','6');
            m.put('6','9');
            m.put('1','1');
            m.put('8','8');
            m.put('0','0');
            int i = 0, j = num.length() - 1;
            while(i <= j) {
                char c1 = num.charAt(i), c2 = num.charAt(j);
                if(!m.containsKey(c1) || m.get(c1) != c2) {
                    res = false;
                    break;
                }
                i++;
                j--;
            }
        }
        return res;
    }
    
    
}