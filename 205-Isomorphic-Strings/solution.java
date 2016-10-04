public class Solution {
    public boolean isIsomorphic(String s, String t) {
        boolean res = false;
        if(s != null && t != null && s.length() == t.length()) {
            res = true;
            HashMap<Character, Character> aToB = new HashMap<Character, Character>();   //no mutual
            HashMap<Character, Character> bToA = new HashMap<Character, Character>();   //no mutual
            for(int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i), tChar = t.charAt(i);
                if(! (aToB.containsKey(sChar) && aToB.get(sChar) != tChar || bToA.containsKey(tChar) && bToA.get(tChar) != sChar ) ){
                    aToB.put(sChar, tChar);
                    bToA.put(tChar, sChar);
                } else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
}