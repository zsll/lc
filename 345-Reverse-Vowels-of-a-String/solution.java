public class Solution {
    public String reverseVowels(String s) {
        HashSet<Integer> set = findVowelPos(s);
        char [] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(!set.contains(i) && i < j) {
                i++;
            }
            while(!set.contains(j) && i < j) {
                j--;
            }
            if(i < j) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        return new String(c);
    }
    
    HashSet<Integer> findVowelPos(String s) {
        HashSet<Integer> res = new HashSet<Integer>();
        if(s != null && s.length() > 0) {
            HashSet<Character> se = new HashSet<Character>();
            se.add('a');
            se.add('i');
            se.add('o');
            se.add('e');
            se.add('u');
            se.add('A');
            se.add('I');
            se.add('O');
            se.add('E');
            se.add('U');
            for(int i = 0; i < s.length(); i++) {
                if(se.contains(s.charAt(i))) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}