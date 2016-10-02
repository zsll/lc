public class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        } else {
            String pre = "1";
            for(int k = 2; k <= n; k++) {
                StringBuffer sb = new StringBuffer();
                int i = 0, cnt = 0;
                char c = 0;
                while(i < pre.length()) {
                    if(i == 0 || pre.charAt(i) != c) {
                        if(c != 0) {
                            sb.append(cnt).append(c);
                        }
                        cnt = 1;
                        c = pre.charAt(i);
                    } else {
                        cnt++;
                    }
                    i++;
                }
                sb.append(cnt).append(c);
                pre = sb.toString();
            }
            return pre;
        }
    }
}