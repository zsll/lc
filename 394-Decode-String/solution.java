public class Solution {
    public String decodeString(String s) {
        /**
         * res string buffer
         * when hitting a number, calculate cur number, if current string is not null, add it into stack
         * when hitting a [, add current number into stack
         * when hitting a char, get current String
         * when hitting a ], pop current number in stack, calculate string by number to stack top (if not empty), else append to res
         * 
         */
         StringBuffer res = new StringBuffer();
                  if(s != null && s.length() > 0) {
             Stack<String> stack = new Stack<String>();
             Long num = null;
             String cur = null;
             for(char c : s.toCharArray()) {
                 
                 if (c == '[') {
                     stack.push(num + "");
                     num = null;
                 } 
                 if(c >= '0' && c <= '9') {
                     if(num == null) {
                         num = Long.parseLong(c + "");
                     } else {
                         num = num*10 + Long.parseLong(c + "");
                     }
                     if(cur != null) {
                         stack.push(cur);
                         cur = null;
                     }
                 } else {
                     num = null;
                 }
                 
                 if (c >= 'a' && c <= 'z') {
                     if(stack.empty()) {
                         /**
                          * Submission Result: Wrong Answer More Details 

Input:
"2[abc]3[cd]ef"
Output:
"abcabccdcdcd"
Expected:
"abcabccdcdcdef"*/
                         cur = null;
                         res.append(c);
                     } else {
                         if(cur == null) {
                             cur = c + "";
                         } else {
                             cur = cur + c;
                         }
                     }
                 }
                 
                 if(c == ']') {
                     long repeat = Long.parseLong(stack.pop());
                     StringBuffer sb = new StringBuffer();
                     for(int i = 0; i < repeat; i++) {
                         sb.append(cur);
                     }
                     if(stack.empty()) {
                         res.append(sb);
                         cur = null;
                     } else if (stack.peek().charAt(0) >= 'a' && stack.peek().charAt(0) <= 'z') {
                         String top = stack.pop();
                         cur = top + sb.toString();
                     } else {
                         /*2[2[b]]*/
                         cur = sb.toString();
                     }
                 }
             }
         }
         return res.toString();
    }
}