public class Solution {
    public String reverseVowels(String s) {
        char [] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(!isVowel(c[i]) && i < j) {
                i++;
            }
            while(!isVowel(c[j]) && i < j) {
                j--;
            }
            if(i < j) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++; //NoteNote 
                j--;
            }
        }
        return new String(c);
    }
    
    boolean isVowel(char c) {
        HashSet<Character> se = new HashSet<Character>(); se.add('a');
se.add('i');
se.add('o');
se.add('e');
se.add('u');
se.add('A');
se.add('I');
se.add('O');
se.add('E');
se.add('U');
return se.contains(c);
    }
}