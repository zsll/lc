public class Solution {
    public boolean isValidSerialization(String preorder) {
        String [] a = preorder.split(",");
        LinkedList<String> l = new LinkedList<String>();
        for(String c : a) {
            l.add(c);
            int s = l.size();
            while(s >= 3 && l.get(s - 1).equals("#") && l.get(s - 2).equals("#")
                && !l.get(s - 3).equals("#")) {
                l.removeLast();
                l.removeLast();
                l.removeLast();
                
                l.add("#");
                s = l.size();   //NoteNote
            } 
        }
        return l.size() <= 1 && l.get(0).equals("#");
    }
}