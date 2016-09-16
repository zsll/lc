public class Solution {
     public List<String> generateParenthesis(int n) {
       //l = remaining # of (
	   //r = remaining # of )
	   StringBuffer b =new StringBuffer();
	   List<String> result = new ArrayList<String> ();
	   generateParenthesisHelper( n, n, b, result);
	   return result;
	   
   }
   
   public void generateParenthesisHelper(int l, int r, StringBuffer b, List<String> result) {
	   if (l == 0 && r == 0) {
		   result.add(new String(b));
		   return;
	   }
	   //if(r >= l - 1 && l - 1 >= 0) {	//since r >= l already, no need to judge r >= l - 1 

	   if(l - 1 >= 0) {
		   b.append('(');
		   generateParenthesisHelper( l - 1, r,b,result);
		   b.deleteCharAt(b.length() - 1);
	   }
	   
	   if(r - 1 >= l) {//NoteNote >= 0
		   b.append(')');
		   generateParenthesisHelper( l , r - 1,b,result);
		   b.deleteCharAt(b.length() - 1);
	   }

   }
}