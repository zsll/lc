public class Solution {
  private List<String> res2 = new ArrayList<String>();
   private int max = 0;
   public List<String> removeInvalidParentheses(String s) {
       dfs(s, "", 0, 0);
       if (res2.size() == 0) {
           res2.add("");
       }

       return res2;
   }

   /**
    * 
    * @param str
    * @param subRes: final result
    * @param countLeft: remaining ( that is not matched from left
    * @param maxLeft:  max number of ( used
    */
   private void dfs(String str, String subRes, int countLeft, int maxLeft) {
       if (str.length() == 0) {
           if (countLeft == 0 && subRes.length() != 0) {
               if (maxLeft > max) {
                   max = maxLeft;
               }
               if (max == maxLeft && !res2.contains(subRes)) {
                   res2.add(subRes.toString());
               }
           }
           return;
       }

       if (str.charAt(0) == '(') {
           dfs(str.substring(1), subRes.concat("("), countLeft + 1, maxLeft + 1);
           dfs(str.substring(1), subRes, countLeft, maxLeft);
       } else if (str.charAt(0) == ')') {
           if (countLeft > 0) {
               dfs(str.substring(1), subRes.concat(")"), countLeft - 1, maxLeft);
           }
           dfs(str.substring(1), subRes, countLeft, maxLeft);
       } else {
           dfs(str.substring(1), subRes.concat(String.valueOf(str.charAt(0))), countLeft, maxLeft);
       }
   }
   
}