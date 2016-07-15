public class Solution {
    public boolean isValidSerialization(String preorder) {
        boolean res = true;
        if(preorder != null && preorder.length() > 0) {
            int index = preorder.indexOf(",#,#");
            while(index >= 1) {
                String end = (index + 4 < preorder.length()) ? preorder.substring(index + 4) : "";
                int pre = index - 1;
                while(pre >= 0 &&  preorder.charAt(pre) >= '0' && preorder.charAt(pre) <= '9') {
                    pre--;
                }
                if(index == pre + 1) {
                    res = false;
                    break;
                }
                preorder = preorder.substring(0, pre + 1)  + "#" + end;
                index = preorder.indexOf(",#,#");
            }
            if(!preorder.equals("#")) {
                res = false;
            } 
        }
        return res;
    }
}