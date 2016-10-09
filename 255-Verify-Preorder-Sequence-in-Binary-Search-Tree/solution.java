public class Solution {
        /**
         *       4 
         *     2   6
         *   1  3 5  7
         * 
         * Preorder would be 4 2 1 3 6 5 7
         * 
         */
    
    public boolean verifyPreorder(int[] preorder) {
        boolean res = true;
        if(preorder != null && preorder.length > 0) {
            int stackTop = -1, min = Integer.MIN_VALUE;
            for(int i : preorder) {
                if(i < min) {
                    res = false;
                    break;
                }
                while(stackTop >= 0 && preorder[stackTop] < i) {
                    min = preorder[stackTop];
                    stackTop--;
                }
                preorder[++stackTop] = i;
            }
        }
        return res;
    }
}