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
                        if(lineLength == maxWidth && k == i && j - i > 1) { //Move last space to the pos after first word
                            sb.append(" ");
                        } 
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    res.add(sb.toString());
                    break;
                } else if(lineLength == maxWidth + 1) {
                    for(int k = i; k < j; k++) {
                        sb.append(words[k]);
                        sb.append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    res.add(sb.toString());
                } else {
                    wordCount--;
                    if(wordCount == 1) {
                        res.add(words[i]);
                    } else {
                        
                        j--;
                        lineLength -= (words[j].length() + 2);  //actual length
                        int spaceNum = (maxWidth - lineLength)/(wordCount - 1); //Minimum spaces
                        int firstExtraSpace = (maxWidth - lineLength) - spaceNum*(wordCount - 1);   //First spaces that needs one more
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
                        res.add(sb.toString());
                    }
                }
                i = j;
            }
        } 
        return res;
    }
}