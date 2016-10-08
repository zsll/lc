public class Solution {
    public String decodeString(String s) {
        if(s == null) return null;
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<String> l2 = new LinkedList<String>();
        l2.add("");
        int curNum = 0;
        for(char c : s.toCharArray()) {
            if(isNum(c)) {
                curNum = curNum*10 + c - '0';
            } else if (c == '[') {
                l1.add(curNum);
                curNum = 0;
                l2.add("");
            } else if (c == ']') {
                int k = l1.removeLast();
                String curS = l2.removeLast();
                String preStr = l2.removeLast();
                l2.add(preStr + genNewString(k, curS));
            } else {
                String preStr = l2.removeLast();
                l2.add(preStr + c);
            }
        }
        return l2.get(0);
    }
    
    boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
    
    String genNewString(int k, String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < k; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}