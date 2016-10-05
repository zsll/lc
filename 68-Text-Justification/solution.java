public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words != null && words.length > 0) {
            int i = 0;
            while (i < words.length) {
                int j = i, lineLength = 0, wordCount = 0;
                StringBuffer sb = new StringBuffer();
                while(lineLength <= maxWidth && j < words.length) {
                    lineLength += words[j].length();
                    lineLength++;//space;
                    wordCount++;
                    j++;
                }
                if(lineLength <= maxWidth) {
                    for(int k = i; k < j; k++) {
                        sb.append(words[k]);
                        sb.append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    
                } else if(lineLength == maxWidth + 1) {
                    for(int k = i; k < j; k++) {
                        sb.append(words[k]);
                        sb.append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    wordCount--;
                    j--;
                    lineLength -= (words[j].length() + 2);  //actual length
                    if(wordCount == 1) {
                        sb.append(words[i]);
                    } else {
                     int wordLengthWithoutSpace = lineLength - (wordCount - 1);
                    int spaceNum = (maxWidth - wordLengthWithoutSpace)/(wordCount - 1); //Minimum spaces
                    int firstExtraSpace = (maxWidth - wordLengthWithoutSpace) - spaceNum*(wordCount - 1);   //First spaces that needs one more

                        for(int k = i; k < j; k++) {
                            sb.append(words[k]);
                            if(k == j - 1){
                                break;
                            }
                            for(int l = 0; l < spaceNum; l++) {
                                sb.append(" ");
                            }
                            if(firstExtraSpace >= k - i + 1) {
                                sb.append(" ");
                            }
                        }
                    }
                }
                
                    /*Needs to fill rest with spaces
                    Submission Result: Wrong Answer More Details 

Input:
[""]
2
Output:
[""]
Expected:
["  "]
                    */
                while(sb.length() < maxWidth) {
                    sb.append(" ");
                }
                res.add(sb.toString());
                i = j;
            }
        } 
        return res;
    }
}