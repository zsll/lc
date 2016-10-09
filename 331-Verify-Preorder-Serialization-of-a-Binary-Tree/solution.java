public class Solution {
    public boolean isValidSerialization(String preorder) {
        boolean res = true;
        if(preorder != null && preorder.length() > 0) {
            LinkedList<String> s = new LinkedList<String>();
            String [] a = preorder.split(",");
            for(String i : a) {
                while(s.size() >= 2 && i.equals("#") && s.get(s.size() - 1).equals("#") && !s.get(s.size() - 2).equals("#")) {
                    s.removeLast();
                    s.removeLast();
                } 
                s.add(i);
                
            }
            res = s.size() == 1 && s.get(s.size() - 1).equals("#");
        }
        return res;
    }
}