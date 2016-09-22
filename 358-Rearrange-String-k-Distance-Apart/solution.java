public class Solution {
     public String rearrangeString(String str, int k) {
            int length = str.length();
            int[] count = new int[26];
            int[] valid = new int[26];
            for(int i=0;i<length;i++){
                count[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int index = 0;index<length;index++){
                int candidatePos = findValidMax(count, valid, index);
                if( candidatePos == -1) return "";
                count[candidatePos]--;
                valid[candidatePos] = index+k;
                sb.append((char)('a'+candidatePos));
            }
            return sb.toString();
        }
        
        /**
         * index is the position to fill
         * @param count
         * @param valid
         * @param index
         * @return
         */
       private int findValidMax(int[] count, int[] valid, int index){
           int max = 0;
           int candidatePos = -1;
           for(int i=0;i<count.length;i++){//There are at most 26 chars, so complexity would be at most 26N
               if(count[i]>max && index>=valid[i]){	
            	   //Find char with largest frequency and valid position is larger than or equal to the position to fill
                   max = count[i];
                   candidatePos = i;
               }
           }
           return candidatePos;
       }

}