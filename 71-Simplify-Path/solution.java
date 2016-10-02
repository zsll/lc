public class Solution {
    public String simplifyPath(String path) {
        StringBuffer sb = new StringBuffer();
        sb.append("/");
        if(path != null && path.length() > 1) {
            String [] a = path.split("/");
            LinkedList<String> stack = new LinkedList<String>();
            for(String s : a) {
                if(!s.equals(".") && s.length() > 0) {  //NoteNote 2nd condition
                    if(s.equals("..")) {
                        if(stack.size() > 0) {
                            stack.removeLast();
                        }
                    } else {
                        stack.add(s);
                    }
                }
            }
            for(String s : stack) {
                sb.append(s);
                sb.append("/");
            }
            /*Submission Result: Wrong Answer More Details 

Input:
"/"
Output:
""
Expected:
"/"
NoteNote: we need the if condition below

Alternative is to use: if(path != null && path.length() > 1) {
            */
            if(sb.length() > 1) {
                sb.setLength(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}