public class Solution {

   public List<String> removeInvalidParentheses(String s) {
       List<String> res = new ArrayList<String>();
       if(s != null ) {
           /* NoteNote
            * Can't have s.length != 0
            * && s.length() > 0
            */
           List<StringBuffer> stringQ = new ArrayList<StringBuffer>();
           List<Integer> usedL = new ArrayList<Integer>();
           List<Integer> usedR = new ArrayList<Integer>();
           stringQ.add(new StringBuffer());
           usedL.add(0);
           usedR.add(0);
           for(char c : s.toCharArray()) {
               List<StringBuffer> stringQNext = new ArrayList<StringBuffer>();
               List<Integer> usedLNext = new ArrayList<Integer>();
               List<Integer> usedRNext = new ArrayList<Integer>();
               for(int i = 0; i < stringQ.size(); i++) {
                   int usedLeft = usedL.get(i);
                   int usedRight = usedR.get(i);
                           StringBuffer sb = new StringBuffer(stringQ.get(i));
                   if(c != ')' && c!= '(') {
                       
                           stringQNext.add(sb.append(c));
                           usedLNext.add(usedLeft);
                           usedRNext.add(usedRight);
                   } else if(c == '(') {
                           //Use Left
                           stringQNext.add(sb.append(c));
                           usedLNext.add(usedLeft + 1);
                           usedRNext.add(usedRight);
                           //Remove left
                           sb = new StringBuffer(stringQ.get(i));
                           stringQNext.add(sb);
                           usedLNext.add(usedLeft);
                           usedRNext.add(usedRight);
                   } else {    //right
                       if(usedRight + 1 <= usedLeft) {
                           stringQNext.add(sb.append(c));
                           usedLNext.add(usedLeft);
                           usedRNext.add(usedRight + 1);
                       }
                       //Remove right
                           sb = new StringBuffer(stringQ.get(i));
                           stringQNext.add(sb);
                           usedLNext.add(usedLeft);
                           usedRNext.add(usedRight);
                   }
               }
               
                   stringQ = stringQNext;
                   usedL = usedLNext;
                   usedR = usedRNext;
           }
           int maxSize = 0;
               for(int i = 0; i < stringQ.size(); i++) {
                   if(usedL.get(i) == usedR.get(i)) {
                       maxSize = Math.max(maxSize, stringQ.get(i).length());
                   }
               }
           Set<String> visited = new HashSet<String>();
           for(int i = 0; i < stringQ.size(); i++) {
                   if(stringQ.get(i).length() == maxSize && !visited.contains(stringQ.get(i).toString()) && usedL.get(i) == usedR.get(i)) {
                       visited.add(stringQ.get(i).toString());
                       res.add(stringQ.get(i).toString());
                   }
               }
       }
       return res;
   }
   
}