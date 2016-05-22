public class Solution {
    public String longestCommonPrefix(String[] ss) {
StringBuffer b = new StringBuffer();
        if(ss != null && ss.length > 0)  {
        	int len = 0;

    		boolean stop = false;	//Note here since we got a double loop, we need one more flag to skip out
        	while(len < ss[0].length()) {
        		char c = ss[0].charAt(len);
        		for(int i = 1; i < ss.length ; i++) {
        		    if(len == ss[i].length()) {
        				stop = true;
        				break;
        			}
        			if(c != ss[i].charAt(len)) {
        				stop = true;
        				break;
        			}
        		}
        		if(stop) {
        			break;
        		}
    			b.append(c);
        		len++;
        	}
        }
        return new String(b);
    }
}